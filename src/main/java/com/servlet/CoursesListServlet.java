package com.servlet;
import com.school.Course;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CoursesListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            //String name = request.getParameter("name");


            String courses = Course.getCourses().toString();

            response.setContentType("text/plain");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(courses);
        }
        catch (IOException e){
            System.out.println("IOException");
        }
    }

}


