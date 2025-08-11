package com.example.verdi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnBuscarReceitas, btnRestaurantes, btnFavoritos, btnPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.homeLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa os botões
        btnBuscarReceitas = findViewById(R.id.btnBuscarReceitas);
        btnRestaurantes = findViewById(R.id.btnRestaurantes);
        btnFavoritos = findViewById(R.id.btnFavoritos);
        btnPerfil = findViewById(R.id.btnPerfil);

        btnBuscarReceitas.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReceitasActivity.class);
            startActivity(intent);
        });

        btnRestaurantes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RestaurantesActivity.class);
            startActivity(intent);
        });

        btnFavoritos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
            startActivity(intent);
        });

        btnPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
            startActivity(intent);
        });
    }
}
