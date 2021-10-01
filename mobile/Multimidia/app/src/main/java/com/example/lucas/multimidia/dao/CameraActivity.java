package com.example.lucas.multimidia.dao;
import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.example.lucas.multimidia.R;

public class CameraActivity extends Activity {
    private static final int CAPTURAR_IMAGEM = 1;
    private static final int CAPTURAR_VIDEO = 2;
    private Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
    }

    public void capturarImagem(View v){
        boolean temCamera = getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA);
        if(temCamera){
            File pasta = Environment
                    .getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES);
            String nomeImagem = pasta.getPath() + "/" +
                    System.currentTimeMillis() + ".jpg";


            uri = Uri.fromFile(new File(nomeImagem));
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, CAPTURAR_IMAGEM);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Salvou Imagem!",Toast.LENGTH_LONG).show();
                adicionarNaGaleria();
            } else {
                Toast.makeText(this, "Erro!",Toast.LENGTH_LONG).show();

            }
        }else if(requestCode == CAPTURAR_VIDEO){
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Video Gravado!"+data.getDataString(),
                        Toast.LENGTH_LONG).show();
                uri = data.getData();
            }else{
                Toast.makeText(this,
                        "Video nao foi Gravado!"+data.getDataString(),Toast.LENGTH_LONG).show();
            }
        }
    }

    public void visualizarImagem(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "image/jpeg");
        startActivity(intent);
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

    public void capturarVideo(View v){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 5);
        startActivityForResult(intent, CAPTURAR_VIDEO);
    }

    public void visualizarVideo(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "video/mp4");
        startActivity(intent);
    }
}





