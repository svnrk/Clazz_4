package com;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    Teacher mathTeacher = new Teacher("Math", "Teacher", "14-03-1980");
    Teacher dutchTeacher = new Teacher("Dutch", "Teacher", "14-03-1990");
    Course math = new Course("Mathematics 101", 3, "01-09-2020", "20-12-2020", mathTeacher);
    Course dutch = new Course("Dutch history", 6, "01-10-2020", "20-12-2020", dutchTeacher);
    Student jack = new Student("Jack", "Cool", "12-12-1990");
    Student bob = new Student("Bob", "Robb", "11-12-1990");

    @Test
    public void addsNewStudents(){
    Student john = new Student("John", "Paul");
    String output1 = john.getFirstName();
    Assert.assertEquals("John", output1);
    Student.removeStudent(john);
//    com.Student jack = new com.Student("Jack", "Cool", "12-12-1990");
    String output2 = jack.getFirstName();
    Assert.assertEquals("Jack", output2);
}



    @Test

    public void setAndGetCourses() {
    String output1 = null;
    jack.addCourse(math);
    List<Course> courses = jack.getCourses();
    for (Course course : courses){
        output1 = course.getName();
    }
    assertEquals("Mathematics 101", output1);

    String output2 = null;
    jack.addCourse(dutch);
    courses = jack.getCourses();
    for (Course course : courses){
        output2 += " " + course.getName();

    }
    assertEquals("null Mathematics 101 Dutch history", output2);
}

@Test
public void getsTeachers(){
    String output1 = null;
    jack.addCourse(math);
    List<String> teachers = jack.getTeachers();
    for (String teacher : teachers){
        output1 = teacher;
    }
    assertEquals("Math Teacher", output1);
}

@Test
    public void getsAndRemovesAllStudents(){

    List<Student> students = Student.getAllStudents();
    for (int i = students.size()-1; i>=0;i--) {
        System.out.println(students.get(i).getFirstName());
        Student.removeStudent(i);
    }
    assertEquals(0, students.size());

}

@Test
    public void saysHello(){
        jack.sayHello();
}
}