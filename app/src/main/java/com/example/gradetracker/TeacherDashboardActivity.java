/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file TeacherDashboardActivity.java
 */

package com.example.gradetracker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gradetracker.databinding.ActivityTeacherDashboardBinding;

public class TeacherDashboardActivity extends AppCompatActivity {

    private ActivityTeacherDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.gradetracker.databinding.ActivityTeacherDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
