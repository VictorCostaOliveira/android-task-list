package com.example.victor.projetodiogo.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.victor.projetodiogo.Model.User;

import java.util.List;

/**
 * Created by victor on 13/06/18.
 */
@Dao
public interface UserDao {

    @Query("SELECT *  FROM user WHERE email LIKE :email AND encrypted_password LIKE :password LIMIT 1")
    User findAuthenticatedUser(String email, String password);

    @Insert
    void insertAll(User... user);

    @Delete
    void delete(User user);
}
