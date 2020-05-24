package com.servlet;

import com.school.Course;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseNumberOfWorkdaysServlet  extends HttpServlet {
    Integer days;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            String name = request.getParameter("name");
            List<Course> courses = Course.getCourses();
            for (Course c : courses){
                if (c.getName().equals(name)){
                    days = c.getNumberOfWorkDaysMinusHolidays();
                }
            }

            response.setContentType("text/plain");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().print("Number of workdays for "+ name+" course: ");
            response.getWriter().println(days);
        }
        catch (IOException e){
            System.out.println("IOException");
        }
    }
}
