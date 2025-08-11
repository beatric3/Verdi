package com.example.verdi;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {ReceitaFavorita.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instancia;

    public abstract FavoritoDao favoritoDao();

    public static synchronized AppDatabase getInstancia(Context context) {
        if (instancia == null) {
            instancia = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "verdi_db")
                    .allowMainThreadQueries() // temporário para facilitar testes
                    .build();
        }
        return instancia;
    }
}
