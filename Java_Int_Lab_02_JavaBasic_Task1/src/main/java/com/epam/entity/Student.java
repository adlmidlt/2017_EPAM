package com.epam.entity;

import java.util.List;
import java.util.Objects;

public class Student {

    private String lastName;
    private String firstName;
    private Curriculum curriculum;
    private List<Integer> marks;

    public Student() {
    }

    public Student(String lastName, String firstName, Curriculum curriculum, List<Integer> marks) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.curriculum = curriculum;
        this.marks = marks;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(lastName, student.lastName) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(curriculum, student.curriculum) &&
                Objects.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, curriculum, marks);
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + "- до окончания обучения по программе " + curriculum;
    }
}
