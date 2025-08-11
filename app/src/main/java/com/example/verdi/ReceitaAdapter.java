package com.example.verdi;

import android.content.Context;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ReceitaAdapter extends RecyclerView.Adapter<ReceitaAdapter.ViewHolder> {

    private List<Receita> listaReceitas;
    private Context context;
    private AppDatabase db;

    // Novo construtor com AppDatabase
    public ReceitaAdapter(List<Receita> listaReceitas, Context context, AppDatabase db) {
        this.listaReceitas = listaReceitas;
        this.context = context;
        this.db = db;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_receita, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Receita receita = listaReceitas.get(position);
        holder.titulo.setText(receita.getTitulo());
        holder.imgReceita.setImageResource(receita.getImagem());

        holder.btnVerMais.setOnClickListener(v ->
                Toast.makeText(context, "Abrir detalhes de " + receita.getTitulo(), Toast.LENGTH_SHORT).show());

        holder.btnFavoritar.setOnClickListener(v -> {
            ReceitaFavorita favorita = new ReceitaFavorita(receita.getTitulo(), receita.getImagem());
            db.favoritoDao().inserirFavorito(favorita);
            Toast.makeText(context, "Adicionado aos favoritos", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return listaReceitas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        ImageView imgReceita;
        Button btnVerMais, btnFavoritar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.txtTituloReceita);
            imgReceita = itemView.findViewById(R.id.imgReceita);
            btnVerMais = itemView.findViewById(R.id.btnVerMais);
            btnFavoritar = itemView.findViewById(R.id.btnFavoritar); // novo botão
        }
    }
}
