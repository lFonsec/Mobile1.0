package com.example.lucas.multimidia.dao.view;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.lincoln.multimidia.R;
import com.example.lucas.multimidia.dao.dao.AutorDAO;
import com.example.lucas.multimidia.dao.database.CriacaoBancoAutorScript;
import com.example.lucas.multimidia.dao.model.Autor;

import java.util.List;




public class MainActivity2 extends ListActivity {

	protected static final int INSERIR_EDITAR = 1;
	protected static final int BUSCAR = 2;

	public static AutorDAO autorDAO;
	private CriacaoBancoAutorScript criacaobanco;
	private List<Autor> autores;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		criacaobanco = new CriacaoBancoAutorScript(this);
		autorDAO = new AutorDAO(this);
		atualizarLista();
	}

	protected void atualizarLista() {
		// Pega a lista de autores e exibe na tela
		autores = autorDAO.listarAutores();

		// Adaptador de lista customizado para cada linha com um autor
		setListAdapter(new AutorListAdapter(this, autores));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, INSERIR_EDITAR, 0, "Inserir Novo").setIcon(R.drawable.novo);
		menu.add(0, BUSCAR, 0, "Buscar").setIcon(R.drawable.pesquisar);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// Clicou no menu
		switch (item.getItemId()) {
		case INSERIR_EDITAR:
			// Abre a tela com o formulário para adicionar
			startActivityForResult(new Intent(this, CadastrarEditarAutor.class), INSERIR_EDITAR);
			break;
		case BUSCAR:
			// Abre a tela para buscar o autor pelo nome
			startActivity(new Intent(this, BuscarAutor.class));
			break;
		}
		return true;
	}

	@Override
	protected void onListItemClick(ListView l, View v, int posicao, long id) {
		super.onListItemClick(l, v, posicao, id);
		// Usuário clicou em algum autor da lista
		// Recupera o autor selecionado
		Autor autor = autores.get(posicao);
		// Cria a intent para abrir a tela de editar
		Intent it = new Intent(this, CadastrarEditarAutor.class);
		// Passa o id do autor como parâmetro
		it.putExtra("_id", autor.getId());
		// Abre a tela de edicao
		startActivityForResult(it, INSERIR_EDITAR);
	}


	@Override
	protected void onActivityResult(int codigo, int codigoRetorno, Intent it) {
		super.onActivityResult(codigo, codigoRetorno, it);

		// Quando a activity CadastrarEditarAutor retornar, devemos atualizar a lista
		if (codigoRetorno == RESULT_OK) {
			// atualiza a lista na tela
			atualizarLista();
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// Fecha o banco
		autorDAO.fechar();
	}
}