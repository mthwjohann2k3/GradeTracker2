/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file StudentRegistrationActivity.java
 */

package com.example.gradetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import com.example.gradetracker.database.entities.GradeTrackerRepository;
import com.example.gradetracker.database.entities.User;
import com.example.gradetracker.databinding.ActivityStudentRegistrationBinding;

public class StudentRegistrationActivity extends AppCompatActivity {

    private ActivityStudentRegistrationBinding binding;
    private GradeTrackerRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = GradeTrackerRepository.getRepository(getApplication());

        binding.createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyUser();
            }
        });
    }

    private void verifyUser() {

        String username = binding.userNameCreateEditText.getText().toString();
        String email = binding.emailCreateEditText.getText().toString();
        String password = binding.passwordCreateEditText.getText().toString();
        String reenterPassword = binding.passwordReenterCreateEditText.getText().toString();
        String accessCode = binding.accessCodeCreateEditText.getText().toString();

        if (username.isEmpty()) {
            //toastMaker("username should not be blank");
            return;
        }
    }

    static Intent registrationIntentFactory(Context context) {
        return new Intent(context, StudentRegistrationActivity.class);
    }
}
