/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file ViewGradesActivity.java
 */

package com.example.gradetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker.database.entities.GradeTrackerRepository;
import com.example.gradetracker.databinding.ActivityViewGradesBinding;

public class ViewGradesActivity extends AppCompatActivity {
    private ActivityViewGradesBinding binding;
    private GradeTrackerRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.gradetracker.databinding.ActivityViewGradesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repository = GradeTrackerRepository.getRepository(getApplication());
        binding.returnToDashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(StudentDashboardActivity.studentDashboardIntentFactory(getApplicationContext()));
            }
        });
    }

    static Intent viewGradesIntentFactory(Context context) {
        return new Intent(context, StudentDashboardActivity.class);
    }
}
