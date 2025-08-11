package com.example.verdi;

import android.content.Context;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FavoritoAdapter extends RecyclerView.Adapter<FavoritoAdapter.ViewHolder> {

    private List<ReceitaFavorita> lista;
    private Context context;
    private FavoritoDao dao;

    public FavoritoAdapter(List<ReceitaFavorita> lista, Context context, FavoritoDao dao) {
        this.lista = lista;
        this.context = context;
        this.dao = dao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorito, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ReceitaFavorita favorito = lista.get(position);
        holder.txtTitulo.setText(favorito.getTitulo());
        holder.img.setImageResource(favorito.getImagemResId());

        holder.btnRemover.setOnClickListener(v -> {
            dao.removerFavorito(favorito);
            lista.remove(holder.getAdapterPosition());
            notifyItemRemoved(holder.getAdapterPosition());
            Toast.makeText(context, "Removido dos favoritos", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo;
        ImageView img;
        Button btnRemover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTituloFavorito);
            img = itemView.findViewById(R.id.imgFavorito);
            btnRemover = itemView.findViewById(R.id.btnRemover);
        }
    }
}

