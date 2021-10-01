package com.example.lucas.multimidia.dao;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.media.AudioManager;
        import android.media.MediaPlayer;
        import android.media.MediaPlayer.OnPreparedListener;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.MediaController;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.widget.VideoView;

        import com.example.lucas.multimidia.R;


public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnLogin = (Button) findViewById(R.id.btnEntrar);

    }

    public void Ola(View view) {
        TextView tLogin = (TextView) findViewById(R.id.edtUsuario);
        TextView tSenha = (TextView) findViewById(R.id.edtSenha);
        String login = tLogin.getText().toString();
        String senha = tSenha.getText().toString();
     //   if(login.equals("lfc")&&senha.equals("123")){
            alert("Login realizado com Sucesso");
            Intent intent = new Intent(this, EscolhaActivity.class);
            startActivity(intent);
       // }else {
         //   alert("Login ou Senha Incorreto");
        //}
    }

    private void alert(String s){
        Toast.makeText(this,s, Toast.LENGTH_LONG).show();
    }

    }
