package com.example.movienerd.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.movienerd.Film;

import java.util.List;

@Dao
public interface FilmDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addFilm(Film film);

    @Transaction
    @Query("SELECT * FROM film WHERE isInWatchlist == 1")
    LiveData<List<Film>> getWatchList();

    @Transaction
    @Query("SELECT * FROM film WHERE isWatched == 1")
    LiveData<List<Film>> getWatchedFilms();
}
