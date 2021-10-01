package com.example.lucas.multimidia.dao.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lincoln.multimidia.R;
import com.example.lucas.multimidia.dao.dao.AutorDAO;
import com.example.lucas.multimidia.dao.model.Autor;


public class CadastrarEditarAutor extends Activity {
	static final int RESULT_SALVAR = 1;
	static final int RESULT_EXCLUIR = 2;

	// Campos texto
	private EditText campoNome;
	private EditText campoEndereco;
	private EditText campoCpf;
	private Long id;
	AutorDAO autorDAO;


	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.form_cadastrar_editar_autor);

		campoNome = (EditText) findViewById(R.id.campoNome);
		campoEndereco = (EditText) findViewById(R.id.campoEndereco);
		campoCpf = (EditText) findViewById(R.id.campoCpf);
		autorDAO = new AutorDAO(this);

		id = null;

		Bundle extras = getIntent().getExtras();
		// Se for para Editar, recuperar os valores ...
		if (extras != null) {
		    id = extras.getLong("_id");
			AutorDAO autorDAO = new AutorDAO(this);

			if (id != null) {
				// é uma edição, busca o autor...
				Autor autor = autorDAO.buscarAutor(id);
				campoNome.setText(autor.getNome());
				campoEndereco.setText(autor.getEndereco());
				campoCpf.setText(autor.getCpf());
			}
		}

		ImageButton btCancelar = (ImageButton) findViewById(R.id.btCancelar);
		btCancelar.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				setResult(RESULT_CANCELED);
				// Fecha a tela
				finish();
			}
		});

		// Listener para salvar o autor
		ImageButton btSalvar = (ImageButton) findViewById(R.id.btSalvar);
		btSalvar.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				salvar();
			}
		});

		ImageButton btExcluir = (ImageButton) findViewById(R.id.btExcluir);

		if (id == null) {
			// Se id está nulo, não pode excluir
			btExcluir.setVisibility(View.INVISIBLE);
		} else {
			// Listener para excluir o autor
			btExcluir.setOnClickListener(new OnClickListener() {
				public void onClick(View view) {
					excluir();
				}
			});
		}
	}


	public void salvar() {


		Autor autor = new Autor();
		if (id != null) {
			//é uma atualização
			autor.setId(id);
			
		}
		autor.setNome(campoNome.getText().toString());
		autor.setEndereco(campoEndereco.getText().toString());
		autor.setCpf(campoCpf.getText().toString());

		autorDAO.salvar(autor);

		//OK
		setResult(RESULT_OK, new Intent());

		//Fecha a tela
		finish();
	}

	public void excluir() {
		if (id != null) {
			{
				autorDAO.apagar(id);
			}

			// OK
			setResult(RESULT_OK, new Intent());

			// Fecha a tela
			finish();
		}
	}



    @Override
    protected void onPause() {
        super.onPause();
        // Cancela para não ficar nada na tela pendente
        setResult(RESULT_CANCELED);

        // Fecha a tela
        finish();
    }



}
