package com.example.movienerd;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="user")
public class User {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    @NonNull
    private int id;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "isLogged")
    private Boolean isLogged;

    public Boolean getIsLogged() {
        return isLogged;
    }

    public void setIsLogged(Boolean logged) {
        isLogged = logged;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){};

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
