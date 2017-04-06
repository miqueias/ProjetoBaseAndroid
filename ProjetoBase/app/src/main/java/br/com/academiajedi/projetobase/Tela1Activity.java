package br.com.academiajedi.projetobase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tela1Activity extends AppCompatActivity {

    private Context c = this; // a variavel contexto serve como uma referencia da activity

    //o onCreate é o método responsavel por criar a tela do android e exibila no device
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setamos o layout que vai ser carregado por essa activity
        setContentView(R.layout.activity_tela1);

        //importando a fonte
        final Typeface oxygenRegular = Typeface.createFromAsset(getResources().getAssets(), "PressStart2P-Regular.ttf");

        //associamos os componentes da nossa tela a nossa activity
        //estamos criando variaveis dos tipos correespondentes no layout
        //referenciando essas variaveis atreves do id de cada elemento
        final TextView txtEmail = (TextView) findViewById(R.id.id_text_email);
        final TextView txtSenha = (TextView) findViewById(R.id.id_text_senha);

        Button btnEntrar = (Button) findViewById(R.id.id_button_entrar);
        //atribuindo a fonte ao botão
        btnEntrar.setTypeface(oxygenRegular);

        //definimos o evento de click do botão
        //caso tenhamos mais botões, cada botão tem o seu proprio evento
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //utilizamos o intent para navegar até a outra tela
                Intent intent = new Intent(c, Tela2.class);
                //podemos enviar valores para a proxima utilzado o putextra
                intent.putExtra("email", txtEmail.getText().toString());
                intent.putExtra("senha", txtSenha.getText().toString());
                //nagevamos até a proxima dela
                startActivity(intent);
            }
        });


    }
}
