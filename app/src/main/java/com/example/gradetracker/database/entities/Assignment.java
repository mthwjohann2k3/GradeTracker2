/**
 * @author Mathew S. Johann
 * @date December 12, 2024
 * @file Assignment.java
 */

package com.example.gradetracker.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetracker.database.GradeTrackerDatabase;

import java.time.LocalDateTime;
import java.util.Objects;
//add objects

@Entity(tableName = GradeTrackerDatabase.ASSIGNMENT_TABLE)
public class Assignment {
    @PrimaryKey(autoGenerate = true)
    private int assignmentId;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private int teacherId;

    public Assignment(String title, String description, LocalDateTime dueDate, int teacherId) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return assignmentId == that.assignmentId && teacherId == that.teacherId && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(dueDate, that.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentId, title, description, dueDate, teacherId);
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
