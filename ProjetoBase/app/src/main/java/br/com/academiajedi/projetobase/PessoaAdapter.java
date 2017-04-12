package br.com.academiajedi.projetobase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Miqueias on 4/12/17.
 */

public class PessoaAdapter extends RecyclerView.Adapter<ListaViewHolder> {

    private List<Pessoa> pessoaList;

    public PessoaAdapter(List<Pessoa> pessoas) {
        pessoaList = pessoas;
    }

    /*
    Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view.
     */
    @Override
    public ListaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListaViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.linha_lista, parent, false));
    }

    /*
    Método que recebe o ViewHolder e a posição da lista.
    Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
    É onde a mágica acontece!
     */
    @Override
    public void onBindViewHolder(ListaViewHolder holder, int position) {
        holder.textViewNome.setText(pessoaList.get(position).getNome());
        holder.textViewSexo.setText(pessoaList.get(position).getSexo());
        holder.textViewIdade.setText(Integer.toString(pessoaList.get(position).getIdade()));

    }

    /*
    Método que deverá retornar quantos itens há na lista.
     */
    @Override
    public int getItemCount() {
        //size() devolve a quantidade de itens contidos dentro do array
        return pessoaList.size();
    }
}
