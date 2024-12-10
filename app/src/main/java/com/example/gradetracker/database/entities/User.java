/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file User.java
 */

package com.example.gradetracker.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetracker.database.GradeTrackerDatabase;

import java.util.Objects;

@Entity(tableName = GradeTrackerDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int userId;
    private String username;
    private String email;
    private String password;
    private boolean role;
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        role = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && role == user.role && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, email, password, role);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}
