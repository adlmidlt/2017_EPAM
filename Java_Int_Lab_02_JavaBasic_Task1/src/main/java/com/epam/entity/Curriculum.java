package com.epam.entity;

import java.util.List;
import java.util.Objects;

public class Curriculum {

    private String nameCurriculum;
    private List<Course> courses;

    public Curriculum() {
    }

    public Curriculum(String nameCurriculum, List<Course> courses) {
        this.nameCurriculum = nameCurriculum;
        this.courses = courses;
    }

    public String getNameCurriculum() {
        return nameCurriculum;
    }

    public void setNameCurriculum(String nameCurriculum) {
        this.nameCurriculum = nameCurriculum;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curriculum that = (Curriculum) o;
        return Objects.equals(nameCurriculum, that.nameCurriculum) &&
                Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCurriculum, courses);
    }

    @Override
    public String toString() {
        return nameCurriculum;
    }
}
