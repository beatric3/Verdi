package com.example.verdi;

import androidx.room.*;
import java.util.List;

@Dao
public interface FavoritoDao {

    @Insert
    void inserirFavorito(ReceitaFavorita favorito);

    @Delete
    void removerFavorito(ReceitaFavorita favorito);

    @Query("SELECT * FROM favoritos")
    List<ReceitaFavorita> listarFavoritos();
}
