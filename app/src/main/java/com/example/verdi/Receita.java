package com.example.verdi;

public class Receita {
    private String titulo;
    private int imagem; // ID do recurso drawable

    public Receita(String titulo, int imagem) {
        this.titulo = titulo;
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getImagem() {
        return imagem;
    }
}
