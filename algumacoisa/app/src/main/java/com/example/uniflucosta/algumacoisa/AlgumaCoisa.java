package com.example.uniflucosta.algumacoisa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class AlgumaCoisa extends AppCompatActivity {
    EditText edtNum1,  edtNum2, resultado;
    Button btnSomar ,btnDividir, btnMultiplicar, btnSubtrair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alguma_coisa);
        edtNum1    = (EditText) findViewById(R.id.edtNum1);
        edtNum2    = (EditText) findViewById(R.id.edtNum2);
        resultado  = (EditText) findViewById(R.id.resultado);

        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnSomar     = (Button) findViewById(R.id.btnSomar);
        btnSubtrair     = (Button) findViewById(R.id.btnSubtrair);

        btnSomar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                double num1 = Double.parseDouble(edtNum1.getText().toString());
                double num2 = Double.parseDouble(edtNum2.getText().toString());
                double soma = num1 + num2;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(AlgumaCoisa.this);
                dialogo.setTitle("Resultado");
                dialogo.setMessage("A soma é " + soma);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
                edtNum1.setText("");
                edtNum2.setText("");

            }
        });
            btnMultiplicar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View V) {
                    double num1 = Double.parseDouble(edtNum1.getText().toString());
                    double num2 = Double.parseDouble(edtNum2.getText().toString());
                    double multiplicar = num1 * num2;
                    AlertDialog.Builder dialogo = new AlertDialog.Builder(AlgumaCoisa.this);
                    dialogo.setTitle("Resultado");
                    dialogo.setMessage("A multiplição é " + multiplicar);
                    dialogo.setNeutralButton("OK", null);
                    dialogo.show();
                    edtNum1.setText("");
                    edtNum2.setText("");

                }
            });
                btnDividir.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View V) {
                                                      double num1 = Double.parseDouble(edtNum1.getText().toString());
                                                      double num2 = Double.parseDouble(edtNum2.getText().toString());
                                                      double dividir = num1 / num2;
                                                      AlertDialog.Builder dialogo = new AlertDialog.Builder(AlgumaCoisa.this);
                                                      dialogo.setTitle("Resultado");
                                                      dialogo.setMessage("A divisão é " + dividir);
                                                      dialogo.setNeutralButton("OK", null);
                                                      dialogo.show();
                                                      edtNum1.setText("");
                                                      edtNum2.setText("");

                                                  }
                                              });
                     btnSubtrair.setOnClickListener(new View.OnClickListener(){


                        @Override
                        public void onClick (View V){
                        double num1 = Double.parseDouble(edtNum1.getText().toString());
                        double num2 = Double.parseDouble(edtNum2.getText().toString());
                        double subtrair = num1 - num2;
                        AlertDialog.Builder dialogo = new AlertDialog.Builder(AlgumaCoisa.this);
                        dialogo.setTitle("Resultado");
                        dialogo.setMessage("A subtração é " + subtrair);
                        dialogo.setNeutralButton("ok", null);
                        dialogo.show();
                            edtNum1.setText("");
                            edtNum2.setText("");

                    }

                    });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alguma_coisa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
