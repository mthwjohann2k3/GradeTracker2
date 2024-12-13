/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file StudentRegistrationActivity.java
 */

package com.example.gradetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
            public void onClick(View view) {
                addUser();
            }
        });
    }

    private void addUser() {

        String username = binding.userNameCreateEditText.getText().toString();
        String email = binding.emailCreateEditText.getText().toString();
        String password = binding.passwordCreateEditText.getText().toString();
        String reenterPassword = binding.passwordReenterCreateEditText.getText().toString();
        String accessCode = binding.accessCodeCreateEditText.getText().toString();

        if (username.isEmpty()) {
            toastMaker("username should not be blank");
            return;
        }
        if (email.isEmpty()) {
            toastMaker("email should not be blank");
            return;
        }
        if (password.isEmpty()) {
            toastMaker("please enter a password");
            return;
        }
        if (reenterPassword.isEmpty()) {
            toastMaker("please re-enter the password");
            return;
        }
        if (!reenterPassword.equals(password)) {
            toastMaker("passwords do not match");
            return;
        }
        if (accessCode.isEmpty()) {
            toastMaker("please enter an access code");
            return;
        }

        startActivity(StudentDashboardActivity.studentDashboardIntentFactory(getApplicationContext()));
    }

    private void toastMaker(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    static Intent registrationIntentFactory(Context context) {
        return new Intent(context, StudentRegistrationActivity.class);
    }
}
