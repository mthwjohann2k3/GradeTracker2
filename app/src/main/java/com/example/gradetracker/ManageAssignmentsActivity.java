/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file ManageAssignmentsActivity.java
 */

package com.example.gradetracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gradetracker.database.entities.GradeTrackerRepository;
import com.example.gradetracker.databinding.ActivityManageAssignmentBinding;

public class ManageAssignmentsActivity extends AppCompatActivity {
    private ActivityManageAssignmentBinding binding;
    private GradeTrackerRepository repository;

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
        //loginUser(savedInstanceState);

        //User is not logged in at this point, go to login screen
        /**
        if (loggedInUserId == -1) {
            Intent intent = LoginActivity.loginIntentFactory(getApplicationContext());
            startActivity(intent);
        }
         */

        //updateSharedPreference();

        //binding.logDisplayTextView.setMovementMethod(new ScrollingMovementMethod());
        //updateDisplay();
        binding.logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
