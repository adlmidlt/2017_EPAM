package com.epam.dao;

import com.epam.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CurriculumDao {

    private List<Course> courseListJ2EE = new ArrayList<>();
    private List<Course> courseListJava = new ArrayList<>();

    public CurriculumDao() {
        initCourseListJ2EE();
        initCourseListJava();
    }

    public void initCourseListJ2EE() {
        courseListJ2EE.add(0, new Course("Технология Java Servlet", 16));
        courseListJ2EE.add(1, new Course("Struct Framework", 24));
        courseListJ2EE.add(2, new Course("Spring Framework", 48));
        courseListJ2EE.add(3, new Course("Hibernate", 20));
    }

    public void initCourseListJava() {
        courseListJava.add(0, new Course("Обзор технологии Java", 8));
        courseListJava.add(1, new Course("Библиотека JFC?Swing", 16));
        courseListJava.add(2, new Course("Технология JDBC", 16));
        courseListJava.add(3, new Course("Технология JAX", 52));
        courseListJava.add(4, new Course("Библиотека commons", 44));
    }

    public List<Course> getCourseListJ2EE() {
        return courseListJ2EE;
    }

    public List<Course> getCourseListJava() {
        return courseListJava;
    }
}
