/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file TeacherDashboardActivity.java
 */

package com.example.gradetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker.database.entities.GradeTrackerRepository;
import com.example.gradetracker.databinding.ActivityTeacherDashboardBinding;

public class TeacherDashboardActivity extends AppCompatActivity {

    private GradeTrackerRepository repository;

    private ActivityTeacherDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.gradetracker.databinding.ActivityTeacherDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repository = GradeTrackerRepository.getRepository(getApplication());
        binding.logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Alert message.
            }
        });
    }

    static Intent teacherDashboardIntentFactory(Context context) {
        return new Intent(context, TeacherDashboardActivity.class);
    }
}
