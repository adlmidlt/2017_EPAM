package com.epam.service;

import com.epam.entity.Student;
import com.epam.dao.StudentDao;

public class DemoService {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDao();
        Student student = new Student();

/*        System.out.println("Список отсортированных студентов по среднему баллу:");
        studentDao.sortByAvgMark(studentDao.getStudentList());*/

/*        System.out.println("Список отсортированных студентов, которым осталось дней до окончания учебы: ");
        studentDao.sortByEndDaysOfCourse(studentDao.getStudentList());*/

/*        System.out.println("Список отсортированных студентов, которым осталось часов до окончания учебы: ");
        studentDao.sortByEndHourOfCourse(studentDao.getStudentList());*/

/*        System.out.println("Результаты студентов во время обучения на курсах: ");
        studentDao.deductedOrCredited(studentDao.getStudentList());*/

/*        studentDao.luckyStudent(studentDao.getStudentList());*/
    }
}
