package com.school;

import com.hello.Greeter;

public class Teacher extends PersonImpl {
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Teacher(String firstName, String lastName, String date) {
        super(firstName, lastName, date);
    }

    @Override
    public void sayHello(){
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello(getFullName()));
        System.out.println("Teacher");
    }

}
