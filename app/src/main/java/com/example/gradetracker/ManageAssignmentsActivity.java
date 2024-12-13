/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file ManageAssignmentsActivity.java
 */

package com.example.gradetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gradetracker.database.entities.Assignment;
import com.example.gradetracker.database.entities.Grade;
import com.example.gradetracker.database.entities.User;
import com.example.gradetracker.database.entities.GradeTrackerRepository;
import com.example.gradetracker.databinding.ActivityManageAssignmentBinding;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ManageAssignmentsActivity extends AppCompatActivity {
    private ActivityManageAssignmentBinding binding;
    private GradeTrackerRepository repository;
    private String mTitle = "";
    private String mDescription = "";
    private LocalDateTime mDueDate;

    private int loggedInUserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.gradetracker.databinding.ActivityManageAssignmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        repository = GradeTrackerRepository.getRepository(getApplication());

        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInformationFromDisplay();
                insertAssignment();
                updateDisplay();
            }
        });

        binding.returnToDashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = TeacherDashboardActivity.teacherDashboardIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    private void insertAssignment() {
        if (mTitle.isEmpty()) {
            return;
        }
        Assignment assignment = new Assignment(mTitle, mDescription, mDueDate, loggedInUserId);
        repository.insertAssignment(assignment);
    }
    private void updateDisplay() {
        ArrayList<Grade> allGrades = repository.getAllAssignmentsByUserId(loggedInUserId);
        if (allGrades.isEmpty()) {
            binding.assignmentDisplayTextView.setText("No assignments added.");
        }
        StringBuilder sb = new StringBuilder();
        for (Grade grade : allGrades) {
            sb.append(grade);
        }
        binding.assignmentDisplayTextView.setText(sb.toString());
    }

    private void getInformationFromDisplay() {
        mTitle = binding.titleInputEditText.getText().toString();
        mDescription = binding.descriptionInputEditText.getText().toString();
        try {
            mDueDate = LocalDateTime.parse(binding.dueDateLabelTextView.getText().toString());
        } catch (NumberFormatException e) {
            Log.d(MainActivity.TAG, "Error reading value from reps edit text.");
        }
    }

    public static Intent manageAssignmentsIntentFactory(Context context) {
        Intent intent = new Intent(context, ManageAssignmentsActivity.class);
        return intent;
    }
}
