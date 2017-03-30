package br.com.academiajedi.projetobase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //recuprando os valores passados pela tela 1
        String valorEmail = getIntent().getStringExtra("email");
        String valorSenha = getIntent().getStringExtra("senha");

        //associamos os componentes da nossa tela a nossa activity
        //estamos criando variaveis dos tipos correespondentes no layout
        //referenciando essas variaveis atreves do id de cada elemento
        TextView txtEmail = (TextView) findViewById(R.id.id_text_email2);
        TextView txtSenha = (TextView) findViewById(R.id.id_text_senha2);

        //alteramos o texto dos componentes para os valores passados da outra tela
        txtEmail.setText(valorEmail);
        txtSenha.setText(valorSenha);

    }
}
