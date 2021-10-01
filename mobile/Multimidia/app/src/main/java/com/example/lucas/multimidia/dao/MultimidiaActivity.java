package com.example.lucas.multimidia.dao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lucas.multimidia.R;

public class MultimidiaActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_player);
    }


    public void escolherOpcao(View view){
        if(view.getId() == R.id.mediaplayer){
            Intent intent = new Intent(this, MediaPlayerActivity.class);
            startActivity(intent);
        }

    }
}