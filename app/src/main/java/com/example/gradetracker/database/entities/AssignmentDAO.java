/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file AssignmentDAO.java (interface)
 */

package com.example.gradetracker.database.entities;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gradetracker.database.GradeTrackerDatabase;

import java.util.ArrayList;
import java.util.List;

public interface AssignmentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Assignment assignment);

    @Query("SELECT * FROM " + GradeTrackerDatabase.ASSIGNMENT_TABLE)
    ArrayList<Assignment> getAllRecords();

    @Query("SELECT * FROM " + GradeTrackerDatabase.ASSIGNMENT_TABLE)
    LiveData<List<Assignment>> getAllLogsByUserId(int userId);

    @Query("SELECT * FROM " + GradeTrackerDatabase.ASSIGNMENT_TABLE)
    List<Grade> getRecordsbyUserId(int loggedInUserId);
}