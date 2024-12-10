/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file TeacherDashboardActivity.java
 */

package com.example.gradetracker;

import android.os.Bundle;

public class TeacherDashboardActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.gradetracker.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
