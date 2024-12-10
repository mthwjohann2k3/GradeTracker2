/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file GradeSubmissionActivity.java
 */

package com.example.gradetracker;

import static com.example.gradetracker.database.GradeTrackerDatabase.databaseWriteExecutor;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.gradetracker.database.entities.User;
import com.example.gradetracker.database.entities.UserDAO;

public class GradeSubmissionActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseWriteExecutor.execute(() -> {
            UserDAO dao = INSTANCE.userDAO();
            dao.deleteAll();
            User teacher = new User("teacher1", "teacher1@csumb.edu", "teacher1");
            teacher.setRole(true);
            dao.insert(teacher);
            User testUser1 = new User("testuser1", "testuser1@csumb.edu", "testuser1");
            dao.insert(testUser1);
        });
    }
}
