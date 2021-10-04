package com.epam.dao;

import com.epam.entity.Course;
import com.epam.entity.Curriculum;
import com.epam.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDao {

    private List<Curriculum> curriculumList = new ArrayList<>();
    private CurriculumDao curriculumDao = new CurriculumDao();
    private List<Student> studentList = new ArrayList<>();

    public StudentDao() {
        initCurriculum();
        initStudent();
    }

    // Добавляем к учебному плану курсы.
    public void initCurriculum() {
        curriculumList.add(0, new Curriculum("J2EE Developer", curriculumDao.getCourseListJ2EE()));
        curriculumList.add(1, new Curriculum("Java Developer", curriculumDao.getCourseListJava()));
    }

    public List<Curriculum> getCurriculumList() {
        return curriculumList;
    }

    public void initStudent() {
        studentList.add(0, new Student("Ivan", "Petrov", getCurriculumList().get(0),
                Arrays.asList(4, 4, 3, 5, 5, 5, 5, 5, 5)));
        studentList.add(1, new Student("Igor", "Sidorov", getCurriculumList().get(1),
                Arrays.asList(5, 4, 5, 4, 4, 5, 2, 5, 5, 5)));
        studentList.add(2, new Student("Ilia", "Scvorcov", getCurriculumList().get(1),
                Arrays.asList(5, 4, 5, 4, 5, 2, 3, 5, 4)));
        studentList.add(3, new Student("Lena", "Larionova", getCurriculumList().get(1),
                Arrays.asList(5, 4, 5, 4, 4, 2, 2, 4, 5)));
        studentList.add(4, new Student("Petya", "Julik", getCurriculumList().get(0),
                Arrays.asList(4, 5, 5, 5, 5, 2, 5, 5, 4, 4, 5, 5)));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    // Средний балл.
    public double getAvgMark(Student student) {
        return student.getMarks().stream().mapToDouble(i -> i).sum() / student.getMarks().size();
    }

    // Сумма текущих оценок.
    public int getSumOfMark(Student student) {
        return student.getMarks().stream().mapToInt(i -> i).sum();
    }

    // Список студентов по отсортированному баллу.
    public void sortByAvgMark(List<Student> students) {
        students.sort((o1, o2) -> Double.compare(getAvgMark(o2), getAvgMark(o1)));
        for (Student student : students) {
            System.out.println(student.getLastName() +" " + student.getFirstName() +
                    ", средний балл = " + getAvgMark(student));
        }
    }

    // Полное количество дней на курсе
    public int getFullDaysOfCourse(Curriculum curriculum) {
        int fullDuration = 0;
        List<Course> courses = curriculum.getCourses();
        for (Course course : courses) {
            fullDuration += course.getDuration();
        }
        return fullDuration / 8;
    }

    // Сколько дней осталось студенту до окончания курса.
    public int getStayDaysForCourses(Student student, Curriculum curriculum) {
        int fullDuration = 0;
        List<Course> courses = curriculum.getCourses();
        for (Course course : courses) {
            fullDuration += course.getDuration();
        }
        int workHoursInDays = 8;
        return (fullDuration / workHoursInDays) - student.getMarks().size();
    }

    // Cколько часов осталось студенту до окончания курса.
    public int getStayHoursForCourses(Student student, Curriculum curriculum) {
        int fullDuration = 0;
        List<Course> courses = curriculum.getCourses();
        for (Course course : courses) {
            fullDuration += course.getDuration();
        }
        int workHoursInDays = 8;
        return ((fullDuration / workHoursInDays) - student.getMarks().size()) * workHoursInDays;
    }

    // Список студентов по отсортированному оставшиеся дней до окончания программы.
    public void sortByEndDaysOfCourse(List<Student> students) {
        students.sort((o1, o2) -> Integer.compare(getStayDaysForCourses(o2, o2.getCurriculum()),
                                                  getStayDaysForCourses(o1, o1.getCurriculum())));
        for (Student student : students) {
            System.out.println(student.getLastName() +" " + student.getFirstName() +
                    ", осталось " + getStayDaysForCourses(student, student.getCurriculum()) + " (день(я)/дней).");
        }
    }

    // Список студентов по отсортированному оставшиеся часов до окончания программы.
    public void sortByEndHourOfCourse(List<Student> students) {
        students.sort((o1, o2) -> Integer.compare(getStayDaysForCourses(o2, o2.getCurriculum()),
                                                  getStayDaysForCourses(o1, o1.getCurriculum())));
        for (Student student : students) {
            System.out.println(student.getLastName() +" " + student.getFirstName() +
                    ", осталось " + getStayHoursForCourses(student, student.getCurriculum()) + " (час(а)/часов).");
        }
    }

    // Решает судьбу студента.
    public void deductedOrCredited(List<Student> students) {
        for (Student student1 : students) {
            double avg = getAvgMark(student1);
            System.out.println("\n" + student1.getLastName() + " " + student1.getFirstName() +
                    " - До окончания обучения по программе " + student1.getCurriculum() +
                    " осталось " + getStayDaysForCourses(student1, student1.getCurriculum()) +
                    " (день(я)/дней). Средний балл - ");
            if (4.5d - avg < 0.000001) {
                System.out.printf("%.1f может продолжить обучение.", avg);
            } else {
                System.out.printf("%.1f отчислен. ", avg);
            }
        }
    }

    // Получаем сумму текущих оценок студента, получаем сумму оценок за оставшиеся дни,
    // если бы студент получал за ним максимальный балл, делим результат на общее количество дней.
    public boolean studentChanceToContinueStudying(Student student) {
        return (getSumOfMark(student) + getStayDaysForCourses(student, student.getCurriculum()) * 5) /
        getFullDaysOfCourse(student.getCurriculum()) < 4.5;
    }

    // Студенту повезло.
    public void luckyStudent(List<Student> students) {
        System.out.println("Есть верояность что студент не будет отчислен: ");
        for (Student student : students) {
            if (!studentChanceToContinueStudying(student)) {
                System.out.println(student.getLastName() + " " + student.getFirstName());
            }
        }
    }
}
