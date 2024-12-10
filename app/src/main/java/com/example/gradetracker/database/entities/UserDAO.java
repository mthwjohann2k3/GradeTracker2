/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file UserDAO.java (interface)
 */

package com.example.gradetracker.database.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gradetracker.database.GradeTrackerDatabase;

import java.util.List;

public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + GradeTrackerDatabase.USER_TABLE + " ORDER BY username")
    LiveData<List<User>> getAllUsers();

    @Query("DELETE from " + GradeTrackerDatabase.USER_TABLE)
    void deleteAll();

    @Query("SELECT * from " + GradeTrackerDatabase.USER_TABLE + " WHERE username == :username" )
    LiveData<User> getUserByUserName(String username);

    @Query("SELECT * from " + GradeTrackerDatabase.USER_TABLE + " WHERE userId == :userId" )
    LiveData<User> getUserByUserId(int userId);
}
