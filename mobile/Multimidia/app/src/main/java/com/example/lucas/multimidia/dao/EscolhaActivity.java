package com.example.lucas.multimidia.dao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lucas.multimidia.R;
import com.example.lucas.multimidia.dao.view.CadastrarEditarAutor;


public class EscolhaActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escolha);
    }

    public void escolherOpcao(View view){
            Intent intent = new Intent(this, MultimidiaActivity.class);
            startActivity(intent);
    }


    public void opcao(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void web(View view){
        Intent intent = new Intent(this, CadastrarEditarAutor.class);
        startActivity(intent);
    }





    private void alert(String s){
        Toast.makeText(this,s, Toast.LENGTH_LONG).show();
    }
}
