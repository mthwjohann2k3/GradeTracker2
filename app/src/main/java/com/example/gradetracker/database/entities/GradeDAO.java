/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file GradeDAO.java (interface)
 */

package com.example.gradetracker.database.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gradetracker.database.GradeTrackerDatabase;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface GradeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Grade grade);

    @Query("SELECT * FROM " + GradeTrackerDatabase.GRADE_TABLE)
    ArrayList<Grade> getAllRecords();

    @Query("SELECT * FROM " + GradeTrackerDatabase.GRADE_TABLE)
    LiveData<List<Grade>> getAllLogsByUserId(int userId);

    @Query("SELECT * FROM " + GradeTrackerDatabase.GRADE_TABLE)
    List<Grade> getRecordsbyUserId(int loggedInUserId);
}
