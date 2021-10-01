package com.example.lucas.multimidia.dao.view;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lincoln.multimidia.R;
import com.example.lucas.multimidia.dao.dao.AutorDAO;
import com.example.lucas.multimidia.dao.model.Autor;


public class BuscarAutor extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		ImageButton btBuscar = (ImageButton) findViewById(R.id.btBuscar);
		btBuscar.setOnClickListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// Cancela para nao ficar nada pendente na tela
		setResult(RESULT_CANCELED);

		// Fecha a tela
		finish();
	}


	public void onClick(View view) {

		EditText nome = (EditText) findViewById(R.id.campoNome);
		EditText endereco = (EditText) findViewById(R.id.campoEndereco);
		EditText cpf = (EditText) findViewById(R.id.campoCpf);
		AutorDAO autorDAO = new AutorDAO(this);


		// Recupera o nome do autor
		String nomeautor = nome.getText().toString();

		// Busca o autor pelo nome
		Autor autor = autorDAO.buscarAutorPorNome(nomeautor);

		if (autor != null) {
			// Atualiza os campos com o resultado
			nome.setText(autor.getNome());
			endereco.setText(autor.getEndereco());
			cpf.setText(autor.getCpf());
		} else {
			// Limpa os campos
			nome.setText("");
			endereco.setText("");
			cpf.setText("");

			Toast.makeText(BuscarAutor.this, "Nenhum autor encontrado", Toast.LENGTH_SHORT).show();
		}
	}

}
