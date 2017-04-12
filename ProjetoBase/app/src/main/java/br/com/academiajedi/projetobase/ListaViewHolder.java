package br.com.academiajedi.projetobase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Miqueias on 4/12/17.
 */

public class ListaViewHolder extends RecyclerView.ViewHolder {

    public TextView textViewNome;
    public TextView textViewSexo;
    public TextView textViewIdade;

    public ListaViewHolder(View itentView) {
        super(itentView);

        textViewNome = (TextView) itentView.findViewById(R.id.txtNome);
        textViewSexo = (TextView) itentView.findViewById(R.id.txtSexo);
        textViewIdade = (TextView) itentView.findViewById(R.id.txtIdade);

    }



}
