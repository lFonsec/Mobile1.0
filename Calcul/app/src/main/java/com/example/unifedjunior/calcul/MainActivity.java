package com.example.unifedjunior.calcul;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtNum1, edtNum2;
    Button btnSomar;
    Button btnMult;
    Button btnDiv;
    Button btnSub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        btnSomar = (Button) findViewById(R.id.btnSomar);
        btnDiv   = (Button) findViewById(R.id.btnDiv);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnSub  = (Button) findViewById(R.id.btnSub);

        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(edtNum1.getText().toString());
                double num2 = Double.parseDouble(edtNum2.getText().toString());
                double soma = num1 + num2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Resultado");
                dialogo.setMessage("A soma é " + soma);
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
                edtNum1.setText("");
                edtNum2.setText("");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(edtNum1.getText().toString());
                double num2 = Double.parseDouble(edtNum2.getText().toString());
                double div   = num1 / num2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Resultado");
                dialogo.setMessage("A Divisão é " + div);
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
                edtNum1.setText("");
                edtNum2.setText("");
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(edtNum1.getText().toString());
                double num2 = Double.parseDouble(edtNum2.getText().toString());
                double mult   = num1 * num2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Resultado");
                dialogo.setMessage("A Multiplicação é " + mult);
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
                edtNum1.setText("");
                edtNum2.setText("");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(edtNum1.getText().toString());
                double num2 = Double.parseDouble(edtNum2.getText().toString());
                double sub   = num1 - num2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Resultado");
                dialogo.setMessage("A Subtração é " + sub);
                dialogo.setNeutralButton("Ok", null);
                dialogo.show();
                edtNum1.setText("");
                edtNum2.setText("");
            }
        });
    }
}
