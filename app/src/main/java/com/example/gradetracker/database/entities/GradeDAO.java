/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file GradeDAO.java (interface)
 */

package com.example.gradetracker.database.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gradetracker.database.GradeTrackerDatabase;

import java.util.List;

@Dao
public interface GradeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Grade grade);

    @Query("SELECT * FROM " + GradeTrackerDatabase.GRADE_TABLE)
    List<Grade> getAllRecords();

    @Query("SELECT * FROM " + GradeTrackerDatabase.GRADE_TABLE + " WHERE :userId")
    LiveData<List<Grade>> getAllLogsByUserId(int userId);

    @Query("SELECT * FROM " + GradeTrackerDatabase.GRADE_TABLE + " WHERE :loggedInUserId")
    List<Grade> getRecordsbyUserId(int loggedInUserId);
}
