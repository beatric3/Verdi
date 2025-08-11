package com.example.verdi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    private TextView tvNome, tvEmail;
    private Button btnLogout;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tvNome = findViewById(R.id.tvNome);
        tvEmail = findViewById(R.id.tvEmail);
        btnLogout = findViewById(R.id.btnLogout);

        prefs = getSharedPreferences("cadastro", MODE_PRIVATE);

        String nome = prefs.getString("nome", "Nome não encontrado");
        String email = prefs.getString("email", "Email não encontrado");

        tvNome.setText("Nome: " + nome);
        tvEmail.setText("Email: " + email);

        btnLogout.setOnClickListener(v -> {
            // Limpa os dados salvos
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();

            // Volta para o login
            Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

