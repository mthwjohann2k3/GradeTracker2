/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file TrackAssignmentActivity.java
 */

package com.example.gradetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gradetracker.database.entities.GradeTrackerRepository;
import com.example.gradetracker.databinding.ActivityTrackAssignmentBinding;

public class TrackAssignmentActivity extends AppCompatActivity {
    private ActivityTrackAssignmentBinding binding;
    private GradeTrackerRepository repository;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.gradetracker.databinding.ActivityTrackAssignmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        repository = GradeTrackerRepository.getRepository(getApplication());
        binding.returnToDashboardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(StudentDashboardActivity.studentDashboardIntentFactory(getApplicationContext()));
            }
        });
    }

    static Intent trackAssignmentIntentFactory(Context context) {
        return new Intent(context, StudentDashboardActivity.class);
    }
}
