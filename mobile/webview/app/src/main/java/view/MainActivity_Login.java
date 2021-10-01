package view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.aluno.webview.R;



public class MainActivity_Login extends AppCompatActivity {

    Button btnLogar, btnCadastrar;
    TextView txtLogin, txtSenha;
    User s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar= (Button) findViewById(R.id.btnCadastrar);
        btnLogar= (Button) findViewById(R.id.btnLogar);
        txtLogin =(TextView) findViewById(R.id.txtLogin);
        txtSenha =(TextView) findViewById(R.id.txtSenha);
    }

    public void FazerCadastro(View view){
         s=new User(txtLogin.getText().toString(), txtSenha.getText().toString());

            Toast toast = Toast.makeText(this, "Cadastrado", Toast.LENGTH_LONG);
            toast.show();
        }



    public void FazerLogin(View view){
       // if(s.getUsuario().equals(txtLogin.getText().toString()) && s.getSenha().equals(txtSenha.getText().toString())){
                Toast toast = Toast.makeText(this, "Entrando", Toast.LENGTH_LONG);
                toast.show();
                startActivity(new Intent(this, DashboardActivity.class));
         //  }else{
           //     Toast toast = Toast.makeText(this, R.string.erro_autenticacao, Toast.LENGTH_LONG);
             //   toast.show();
        //}
        }
    }

