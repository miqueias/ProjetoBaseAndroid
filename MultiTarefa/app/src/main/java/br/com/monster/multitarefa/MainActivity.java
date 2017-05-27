package br.com.monster.multitarefa;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView imgDownload;
    Button btnDownload;
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciando os objetos da nossa tela
        imgDownload = (ImageView) findViewById(R.id.imgDownload);
        btnDownload = (Button) findViewById(R.id.btnDownload);

        //click do botão
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baixarImagem();

            }
        });

    }

    public void baixarImagem() {

        progressDialog = ProgressDialog.show(MainActivity.this, "Unibratec", "Baixando imagem...");

        //criando a nova thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //1 -transformando a url em objeto
                    URL url = new URL("http://qasidasproject.free.fr/images/droid.png");
                    //2 -abrindo a conexão http
                    HttpURLConnection http = (HttpURLConnection) url.openConnection();
                    //3 - pegando a imagem em byte code
                    InputStream inputStream = http.getInputStream();
                    //4 - transformando em bitmap
                    final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            imgDownload.setImageBitmap(bitmap);
                        }
                    });

                    Log.i("MainActivity",  "Baixou a imagem");

                } catch (Exception e) {
                    progressDialog.dismiss();
                    Log.i("MainActivity",  "Não Baixou a imagem");
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
