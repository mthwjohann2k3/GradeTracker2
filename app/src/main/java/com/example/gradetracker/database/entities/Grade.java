package com.example.gradetracker.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetracker.database.GradeTrackerDatabase;

@Entity(tableName = GradeTrackerDatabase)
public class Grade {
    @PrimaryKey(autoGenerate = true)
    private int studentId;
    private int assignmentId;
    private double grade;
    private String comments;
}
