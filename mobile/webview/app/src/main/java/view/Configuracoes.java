package view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.aluno.webview.R;


public class Configuracoes extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracao);

    }

    public void abrirBrowser(View view){
        startActivity(new Intent(this, Web_View.class));
    }


}
