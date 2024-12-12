/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file GradeSubmissionActivity.java
 */

package com.example.gradetracker;

import static com.example.gradetracker.database.GradeTrackerDatabase.databaseWriteExecutor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        binding.returnToDashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go back to dashboard.
                Intent intent = new Intent(TeacherDashboardActivity.teacherDashboardIntentFactory(getApplicationContext()));
                startActivity(intent);
            }
        });
    }
}
