/**
 * @author Mathew S. Johann
 * @date December 9, 2024
 * @file Grade.java
 */

package com.example.gradetracker.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.gradetracker.database.GradeTrackerDatabase;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(tableName = GradeTrackerDatabase)
public class Grade {
    @PrimaryKey(autoGenerate = true)
    private int studentId;
    private int assignmentId;
    private double grade;
    private String comments;

    public Grade(int studentId, int assignmentId, double grade, String comments) {
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.grade = grade;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return studentId == grade1.studentId && assignmentId == grade1.assignmentId && Double.compare(grade, grade1.grade) == 0 && Objects.equals(comments, grade1.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, assignmentId, grade, comments);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
