/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file ClassPerformance.java
 */

package com.example.gradetracker;

import static com.example.gradetracker.database.GradeTrackerDatabase.databaseWriteExecutor;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker.database.entities.User;
import com.example.gradetracker.database.entities.UserDAO;
import com.example.gradetracker.databinding.ActivityClassPerformanceBinding;

public class ClassPerformance extends AppCompatActivity {
    private ActivityClassPerformanceBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.returnToDashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go back to dashboard.
            }
        });
    }

}
