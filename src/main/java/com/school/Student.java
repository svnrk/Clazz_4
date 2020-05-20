package com.school;

import com.hello.Greeter;

import java.util.ArrayList;
import java.util.List;

public class Student extends PersonImpl {

    private List<Course> courses;
    private static List<Student> students = new ArrayList<>();

    public Student(String firstName, String lastName) {
        super(firstName, lastName, null);
    }

    public Student(String firstName, String lastName, String date) {
        super(firstName, lastName, date);
        courses = new ArrayList<>();
        if (!students.contains(this)){
            students.add(this);
        }
    }

    @Override
    public void sayHello() {
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello(getFullName()));
        System.out.println("Student");
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<String> getTeachers(){
        List<String> teachers = new ArrayList<>();

        for (Course course : courses){
            String teacherName = course.getTeacher().getFullName();
            teachers.add(teacherName);
        }
        return teachers;
    }

    public static List<Student> getAllStudents() {
        return students;
    }
    public static void removeStudent(Student student) {
        students.remove(student);
    }
    public static void removeStudent(int index) {
        students.remove(index);
    }

}
