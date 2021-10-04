package com.epam.entity;

import java.util.Objects;

public class Course {

    private String nameCourse;
    private int duration;

    public Course() {
    }

    public Course(String nameCourse, int duration) {
        this.nameCourse = nameCourse;
        this.duration = duration;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return duration == course.duration &&
                Objects.equals(nameCourse, course.nameCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCourse, duration);
    }

    @Override
    public String toString() {
        return "Course{" +
                "nameCourse='" + nameCourse + '\'' +
                ", duration=" + duration +
                '}';
    }
}
