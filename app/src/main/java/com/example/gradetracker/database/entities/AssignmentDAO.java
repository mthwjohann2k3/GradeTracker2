/**
 * @author Mathew S. Johann
 * @date December 11, 2024
 * @file AssignmentDAO.java (interface)
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
public interface AssignmentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Assignment assignment);

    @Query("SELECT * FROM " + GradeTrackerDatabase.ASSIGNMENT_TABLE)
    List<Assignment> getAllAssignments();

    @Query("SELECT * FROM " + GradeTrackerDatabase.ASSIGNMENT_TABLE + " WHERE :userId")
    LiveData<List<Assignment>> getAllAssignmentsByUserId(int userId);

    @Query("SELECT * FROM " + GradeTrackerDatabase.ASSIGNMENT_TABLE + " WHERE :loggedInUserId")
    List<Assignment> getRecordsbyUserId(int loggedInUserId);
}