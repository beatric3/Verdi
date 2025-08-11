package com.example.verdi;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import java.util.List;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private FavoritoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        AppDatabase db = AppDatabase.getInstancia(this);
        List<ReceitaFavorita> lista = db.favoritoDao().listarFavoritos();

        recycler = findViewById(R.id.recyclerFavoritos);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FavoritoAdapter(lista, this, db.favoritoDao());
        recycler.setAdapter(adapter);
    }
}
