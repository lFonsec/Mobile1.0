package br.lucas.dao;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import br.lucas.lua.model.Autor;

public class AlunoDAO {
    private static final String CATEGORIA =
            "categoria_autor";
    // Nome do banco
    private static final String NOME_BANCO =
            "bdautores";
    protected SQLiteDatabase db;
    public AlunoDAO(Context ctx) {
        // Abre o banco de dados ja existente
        db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
    }
    // Salva o autor, insere um novo ou atualiza
    public long salvar(Autor autor) {
        long id = autor.getId();
        ContentValues values = new ContentValues();
        values.put("nome", autor.getNome());
        values.put("endereco", autor.getEndereco());
        values.put("cpf", autor.getCpf());
        if (id != 0) {
            String _id = String.valueOf(autor.getId());
            String where = "_id" + "=?";
            String[] whereArgs = new String[] { _id };
            int count = db.update("autor", values, where, whereArgs);
        } else {
            // Insere novo
            id = db.insert("autor", "", values);
        }
        return id;
    }
    // Deleta o autor com o id fornecido
    public int apagar(long id) {
        String where = "_id" + "=?";
        String _id = String.valueOf(id);
        String[] whereArgs = new String[] { _id };
        int count = db.delete("autor", where, whereArgs);
        Log.i(CATEGORIA, "Deletou [" + count + "] registros");
        return count;
    }
    // Retorna uma lista com todos os autores
    public List<Autor> listarAutores() {
        Cursor c = db.query("autor", new String[]{"_id", "nome",
                        "endereco"
                        ,
                        "cpf"}, null, null,
                null, null, null, null);
        List<Autor> autores = new ArrayList<Autor>();
        if (c.moveToFirst()) {
            // Recupera os indices das colunas
            int idxId = c.getColumnIndex("_id");
            int idxNome = c.getColumnIndex("nome");
            int idxEndereco = c.getColumnIndex("endereco");
            int idxCpf = c.getColumnIndex("cpf");
            do {
                Autor autor = new Autor();
                // recupera os atributos de autor
                autor.setId(c.getLong(idxId));
                autor.setNome(c.getString(idxNome));
                autor.setEndereco(c.getString(idxEndereco));
                autor.setCpf(c.getString(idxCpf));
                autores.add(autor);
            } while (c.moveToNext());
        }
        return autores;
    }
    // Busca o autor pelo id
    public Autor buscarAutor(long id) {
        // select * from autor where _id=?
        Cursor c = db.query(true, "autor", new String[] { "_id", "nome", "endereco", "cpf" }, "_id" + "=" + id, null,
                null, null, null, null);
        if (c.getCount() > 0) {
            // Posiciona no primeiro elemento do cursor
            c.moveToFirst();
            Autor autor = new Autor();
            // Le os dados
            autor.setId(c.getLong(0));
            autor.setNome(c.getString(1));
            autor.setEndereco(c.getString(2));
            autor.setCpf(c.getString(3));
            return autor;
        }
        return null;
    }
    // Busca o autor pelo nome "select * from autor where nome=?"
    public Autor buscarAutorPorNome(String nome) {
        Autor autor = null;
        try {
            // Idem a: SELECT _id,nome,placa,ano from autor where nome = ?
            Cursor c = db.query("autor", new String[] { "_id", "nome", "endereco", "cpf" }, "nome" +
                    "='" + nome + "'", null, null, null, null);
            if (c.moveToNext()) {
                autor = new Autor();
                // utiliza os metodos getLong(), getString(), getInt(), etc para recuperar os valores
                autor.setId(c.getLong(0));
                autor.setNome(c.getString(1));
                autor.setEndereco(c.getString(2));
                autor.setCpf(c.getString(3));
            }
        } catch (SQLException e) {
            Log.e(CATEGORIA, "Erro ao buscar o autor pelo nome: " + e.toString());
            return null;
        }
        return autor;
    }
    // Fecha o banco
    public void fechar() {
        // fecha o banco de dados
        if (db != null) {
            db.close();
        }
    }
}