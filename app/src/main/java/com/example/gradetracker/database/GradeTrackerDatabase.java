package com.example.gradetracker.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.gradetracker.MainActivity;
import com.example.gradetracker.database.entities.Grade;
import com.example.gradetracker.database.entities.GradeDAO;
import com.example.gradetracker.database.entities.User;
import com.example.gradetracker.database.entities.UserDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TypeConverters(LocalDateTypeConverter.class)
@Database(entities = {Grade.class, User.class}, version = 1, exportSchema = false)
public abstract class GradeTrackerDatabase extends RoomDatabase {

    public static final String USER_TABLE = "usertable";
    public static final String ASSIGNMENT_TABLE = "assignmentTable";
    private static final String DATABASE_NAME = "GradeTrackerDatabase";
    public static final String GRADE_TABLE = "gradeTable";
    private static volatile GradeTrackerDatabase INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static GradeTrackerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (GradeTrackerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            GradeTrackerDatabase.class,
                                    DATABASE_NAME
                            )
                            .fallbackToDestructiveMigration()
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.i(MainActivity.TAG, "DATABASE CREATED!");
            databaseWriteExecutor.execute(() -> {
                UserDAO dao = INSTANCE.userDAO();
                dao.deleteAll();
                User admin = new User("admin1", "admin1@csumb.edu", "admin1");
                admin.setRole(true);
                dao.insert(admin);
                User testUser1 = new User("testuser1", "testuser1@csumb.edu", "testuser1");
                dao.insert(testUser1);
            });
        }
    };

    public abstract GradeDAO gradeDAO();

    public abstract UserDAO userDAO();

}
