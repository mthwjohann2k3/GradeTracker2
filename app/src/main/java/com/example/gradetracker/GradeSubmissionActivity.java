/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file GradeSubmissionActivity.java
 */

package com.example.gradetracker;

import static com.example.gradetracker.database.GradeTrackerDatabase.databaseWriteExecutor;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.gradetracker.database.entities.User;
import com.example.gradetracker.database.entities.UserDAO;
import com.example.gradetracker.databinding.ActivityGradeSubmissionBinding;

public class GradeSubmissionActivity extends AppCompatActivity {
    private ActivityGradeSubmissionBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
