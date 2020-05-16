package com.school;

import com.school.Course;
import com.school.Student;
import com.school.Teacher;
import com.school.StudentListPrinter;
import org.junit.Test;

public class StudentListPrinterTest {
    Teacher mathTeacher = new Teacher("Math", "com.school.Teacher", "14-03-1980");
    Course math = new Course("Mathematics 101", 3, "01-09-2020", "20-12-2020", mathTeacher);
    Student jack = new Student("Jack", "Cool", "12-12-1990");
    Student bob = new Student("Bob", "Robb", "11-12-1990");

    @Test
    public void printsAllStudents(){
        StudentListPrinter.printAllStudentList();
        System.out.println("All");
    }

    @Test
    public void printsCourseStudents(){
        jack.addCourse(math);
        math.addStudent(bob);
        StudentListPrinter.printCourseStudentList(math.getStudents());
    }
}
