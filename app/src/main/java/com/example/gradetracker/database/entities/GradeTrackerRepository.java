/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file GradeTrackerRepository.java
 */

package com.example.gradetracker.database.entities;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Entity;

import com.example.gradetracker.MainActivity;
import com.example.gradetracker.database.GradeTrackerDatabase;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Entity
public class GradeTrackerRepository {
    private final GradeDAO gradeDAO;
    private final UserDAO userDAO;
    private ArrayList<Grade> allGrades;
    private static GradeTrackerRepository repository;

    public GradeTrackerRepository(Application application) {
        GradeTrackerDatabase db = GradeTrackerDatabase.getDatabase(application);
        this.gradeDAO = db.gradeDAO();
        this.allGrades = (ArrayList<Grade>) this.gradeDAO.getAllRecords();
    }

    public ArrayList<Grade> getAllGrades() {
        Future<ArrayList<Grade>> future = GradeTrackerDatabase.databaseWriteExecutor.submit(
                new Callable<ArrayList<Grade>>() {
                    @Override
                    public ArrayList<Grade> call() throws Exception {
                        return GradeDAO.getAllRecords();
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            Log.i(MainActivity.TAG, "Problem when getting all GymLogs in the repository");
        }
        return null;
    }

    public static GradeTrackerRepository getRepository(Application application) {
        if (repository != null) {
            return repository;
        }
        Future<GradeTrackerRepository> future = GradeTrackerDatabase.databaseWriteExecutor.submit(
                new Callable<GradeTrackerRepository>() {
                    @Override
                    public GradeTrackerRepository call() throws Exception {
                        return new GradeTrackerRepository(application);
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.i(MainActivity.TAG, "Problem getting GymLogRepository, thread error.");
        }
        return null;
    }

    public void insertGrade(Grade grade) {
        GradeTrackerDatabase.databaseWriteExecutor.execute(() -> {
            //GradeDAO.insert(grade);
        });
    }

    /**
    public ArrayList<Grade> getAllGrades() {
        Future<ArrayList<Grade>> future = GradeTrackerDatabase.databaseWriteExecutor.submit(
                new Callable<ArrayList<Grade>>() {
                    @Override
                    public ArrayList<Grade> call() throws Exception {
                        return (ArrayList<Grade>) gradeDAO.getAllRecords();
                    }
                });
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.i(MainActivity.TAG, "Problem when getting all GymLogs in the repository");
        }
        return null;
    }
     */

    public void insertUser(User... user) {
        GradeTrackerDatabase.databaseWriteExecutor.execute(() ->
        {
            userDAO.insert(user);
        });
    }

    public LiveData<User> getUserByUserName(String username) {
        return userDAO.getUserByUserName(username);
    }

    public LiveData<User> getUserByUserId(int userId) {
        return userDAO.getUserByUserId(userId);
    }

    public ArrayList<Grade> getAllLogsByUserId(int loggedInUserId) {
        Future<ArrayList<Grade>> future = GradeTrackerDatabase.databaseWriteExecutor.submit(
                new Callable<ArrayList<Grade>>() {
                    @Override
                    public ArrayList<Grade> call() throws Exception {
                        return (ArrayList<Grade>) gradeDAO.getRecordsbyUserId(loggedInUserId);
                    }
                });
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.i(MainActivity.TAG, "Problem when getting all GymLogs in the repository");
        }
        return null;
    }

}
