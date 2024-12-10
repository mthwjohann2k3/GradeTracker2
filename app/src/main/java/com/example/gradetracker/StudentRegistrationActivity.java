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

    private ActivityMainBinding binding;

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

        String username = binding.userNameLoginEditText.getText().toString();

        if (username.isEmpty()) {
            toastMaker("username should not be blank");
            return;
        }
        LiveData<User> userObserver = repository.getUserByUserName(username);
        userObserver.observe(this, user -> {
            if (user != null) {
                String password = binding.passwordLoginEditText.getText().toString();
                if (password.equals(user.getPassword())) {
                    startActivity(MainActivity.mainActivityIntentFactory(getApplicationContext(), user.getUsername()));
                } else {
                    toastMaker("Invalid password");
                    binding.passwordLoginEditText.setSelection(0);
                }
            } else {
                toastMaker(String.format("%s is not a valid username", username));
                binding.userNameLoginEditText.setSelection(0);
            }
        });
    }
}
