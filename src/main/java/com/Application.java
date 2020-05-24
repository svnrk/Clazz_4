package com;

import com.school.Course;
import com.school.Teacher;
import com.servlet.JettyServer;

public class Application {
    public static void main(String[] args) {

//http://localhost:1332/courses
//http://localhost:1332/course_length?name=math
//http://localhost:1332/course_length?name=dutch
//http://localhost:1332/course_length?name=english
//http://localhost:1332/hello?name=Bob%Bobby


        JettyServer jettyServer = new JettyServer();

        Teacher mathTeacher = new Teacher("Math", "Teacher", "14-03-1980");
        Course math = new Course("math", 3, "01-09-2020", "20-12-2020", mathTeacher);

        Teacher dutchTeacher = new Teacher("Dutch", "Teacher", "14-03-1990");
        Course dutch = new Course("dutch", 6, "01-10-2020", "20-12-2020", dutchTeacher);

        Teacher engTeacher = new Teacher("English", "Teacher", "14-03-1970");
        Course english = new Course("english", 6, "01-11-2020", "20-12-2020", engTeacher);

        try {
            jettyServer.start();
        } catch (Exception ex) {
            System.out.println("Something went horribly wrong");
        }
    }
}
