package br.lucas.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
public class CriacaoBancoAutorScript {
    // Script para fazer drop na tabela
    private static final String SCRIPT_DATABASE_DELETE = "DROP TABLE IF EXISTS autor";
    protected SQLiteDatabase db;
    // Cria a tabela com o "_id" sequencial
    private static final String[] SCRIPT_DATABASE_CREATE = new String[] {
            "create table autor ( _id integer primary key autoincrement, nome text not null,endereco text not null,cpf text not null);",
            "insert into autor(nome,endereco,cpf) values('Helder','Rua x','123132');"};
// Nome do banco
private static final String NOME_BANCO =
        "bdautores";
// Controle de versao
private static final int VERSAO_BANCO = 3;
// Nome da tabela
public static final String TABELA_AUTOR = "autor";
// Classe utilitaria para abrir, criar, e atualizar o banco de dados
private SQLiteHelper dbHelper;
// Cria o banco de dados com um script SQL
public CriacaoBancoAutorScript(Context ctx) {
        // Criar utilizando um script SQL
        dbHelper = new SQLiteHelper(ctx, CriacaoBancoAutorScript.NOME_BANCO,
        CriacaoBancoAutorScript.VERSAO_BANCO,
        CriacaoBancoAutorScript.SCRIPT_DATABASE_CREATE,
        CriacaoBancoAutorScript.SCRIPT_DATABASE_DELETE);
        // abre o banco no modo escrita
        db = dbHelper.getWritableDatabase();
        }
// Fecha o banco
public void fechar() {
        if (db != null) {
        db.close();
        }
        if (dbHelper != null) {
        dbHelper.close();
        }
        }
        }
