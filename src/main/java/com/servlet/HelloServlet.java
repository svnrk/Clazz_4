package com.servlet;

import com.hello.Greeter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    private Greeter greeter = new Greeter();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            String name = request.getParameter("name");

            String greeting = greeter.sayHello(name);

            response.setContentType("text/plain");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(greeting);
        }
        catch (IOException e){
            System.out.println("IOException");
        }
    }
}