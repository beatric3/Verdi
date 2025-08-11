package com.example.verdi;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import java.util.ArrayList;
import java.util.List;

public class ReceitasActivity extends AppCompatActivity {

    private RecyclerView recyclerReceitas;
    private ReceitaAdapter adapter;
    private List<Receita> listaReceitas;
    private AppDatabase db; // banco de dados Room

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita);

        // Instância do banco Room
        db = AppDatabase.getInstancia(this);

        recyclerReceitas = findViewById(R.id.recyclerReceitas);
        recyclerReceitas.setLayoutManager(new LinearLayoutManager(this));

        listaReceitas = new ArrayList<>();
        listaReceitas.add(new Receita("Macarrão ao pesto", R.drawable.fundo_macarrao));
        listaReceitas.add(new Receita("Salada tropical", R.drawable.fundo_macarrao));
        listaReceitas.add(new Receita("Sopa detox", R.drawable.fundo_macarrao));

        // Passa o banco para o adapter
        adapter = new ReceitaAdapter(listaReceitas, this, db);
        recyclerReceitas.setAdapter(adapter);
    }
}
