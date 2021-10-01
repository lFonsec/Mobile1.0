package com.lucas.br.locationapp;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity {

    EditText txtIP;
    TextView lblCountry, lblRegion, lblCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        txtIP = (EditText)findViewById(R.id.txtIP);
        lblCountry = (TextView)findViewById(R.id.lblCountry);
        lblRegion = (TextView)findViewById(R.id.lblRegion);
        lblCity = (TextView)findViewById(R.id.lblCity);
    }

    public void btnCarregarOnClick(View view){

        //permite conexão com a Internet na Thread principal
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            String ip = txtIP.getText().toString();
            Localizacao localizacao = ClienteGeoIP.retornarLocalizacaoPorIp(ip);
            lblRegion.setText("Estado: " + localizacao.getRegion());
            lblCity.setText("Cidade: " + localizacao.getCity());
            lblCountry.setText("País: " + localizacao.getCountry());
        }
        catch(Exception ex){
            Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


}
