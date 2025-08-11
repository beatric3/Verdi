package com.example.verdi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favoritos")
public class ReceitaFavorita {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String titulo;
    private int imagemResId; // ID da imagem drawable

    public ReceitaFavorita(String titulo, int imagemResId) {
        this.titulo = titulo;
        this.imagemResId = imagemResId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImagemResId() {
        return imagemResId;
    }
}
