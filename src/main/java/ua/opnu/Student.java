package ua.opnu;

import java.util.ArrayList;

public class Student {
    String name;
    int year; // від 1 до 4
    ArrayList<String> courses;

    public Student(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім");
        }
        if (year < 1 || year > 4) {
            throw new IllegalArgumentException("Рік навчання має бути від 1 до 4");
        }

        this.name = name;
        this.year = year;
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            throw new IllegalArgumentException("Назва дисципліни не може бути порожньою");
        }
        courses.add(courseName);
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getName() {
        return this.name;
    }

    public int getTuition() {
        return this.year * 20000;
    }

    public int getYear() {
        return this.year;
    }

    public static void main(String[] args) {
        Student s = new Student("Андрій", 2);

        s.addCourse("Програмування");
        s.addCourse("Бази даних");
        s.addCourse("Математика");

        System.out.println(s.getName() + ": кількість вивчаємих дисциплін - " + s.getCourseCount());

        System.out.println(s.getName() + ": рік навчання - " + s.getYear());

        System.out.println(s.getName() + ": заплатив за навчання - " + s.getTuition());
    }
}