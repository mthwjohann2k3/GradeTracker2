package com.example.gradetracker.database.entities;

import android.app.Application;
import android.util.Log;

import com.example.gradetracker.MainActivity;
import com.example.gradetracker.database.GradeTrackerDatabase;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class GradeTrackerRepository {
    private GradeDAO gradeDAO;
    private ArrayList<Grade> allGrades;

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

    public void insetGrade(Grade grade) {
        GradeTrackerDatabase.databaseWriteExecutor.execute(() -> {
            GradeDAO.insert(grade);
        });
    }

}
