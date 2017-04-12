package br.com.academiajedi.projetobase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PessoaAdapter pessoaAdapter;
    List<Pessoa> pessoaList; //lista com os objetos que serão exibidos na RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_layout_recycler);
        //informas que a nossa lista terá um tamanho fixo, isso melhor a performance do app
        recyclerView.setHasFixedSize(true);

        // Configurando o gerenciador de layout para ser uma lista.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adicionando objetos a lista
        // a lista pode ser carregada de um banco de dados ou web  service
        pessoaList = new ArrayList<>();
        pessoaList.add(new Pessoa("Miqueias", "M", 30));
        pessoaList.add(new Pessoa("José", "M", 60));
        pessoaList.add(new Pessoa("Maria", "F", 24));
        pessoaList.add(new Pessoa("Matheus", "M", 11));
        pessoaList.add(new Pessoa("Lucas", "M", 9));

        // Adiciona o adapter que irá anexar os objetos à lista.
        // Está sendo criado com lista vazia, pois será preenchida posteriormente.
        pessoaAdapter = new PessoaAdapter(pessoaList);
        recyclerView.setAdapter(pessoaAdapter);

        // Configurando um dividr entre linhas, para uma melhor visualização.
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
