/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file TeacherDashboardActivity.java
 */

package com.example.gradetracker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
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
        binding.classPerformanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ClassPerformance.classPerformanceIntentFactory(getApplicationContext()));
            }
        });
        binding.manageAssignmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ManageAssignmentsActivity.manageAssignmentsIntentFactory(getApplicationContext()));
            }
        });
        binding.gradeSubmissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(GradeSubmissionActivity.gradeSubmissionIntentFactory(getApplicationContext()));
            }
        });
        binding.logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutDialog();
            }
        });
    }

    private void showLogoutDialog() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(TeacherDashboardActivity.this);
        final AlertDialog alertDialog = alertBuilder.create();

        alertBuilder.setMessage("Logout?");

        alertBuilder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(MainActivity.mainActivityIntentFactory(getApplicationContext()));
            }
        });

        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertBuilder.create().show();

    }

    static Intent teacherDashboardIntentFactory(Context context) {
        return new Intent(context, TeacherDashboardActivity.class);
    }
}
