/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file StudentRegistrationActivity.java
 */

package com.example.gradetracker;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.LiveData;

import com.example.gradetracker.database.entities.GradeTrackerRepository;
import com.example.gradetracker.database.entities.User;
import com.example.gradetracker.databinding.ActivityLoginBinding;

public class StudentRegistrationActivity {

    private ActivityLoginBinding binding;
    private static GymLogRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        repository = GradeTrackerRepository.getRepository(getApplication());

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
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
        String reenterPassword = binding.reeenterPasswordCreateEditText.getText().toString();
        String accessCode = binding.accessCodeCreateEditText.getText().toString();

        if (username.isEmpty()) {
            toastMaker("username should not be blank");
            return;
        }
    }
}
