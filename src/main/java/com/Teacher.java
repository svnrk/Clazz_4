package com;

public class Teacher extends PersonImpl {
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Teacher(String firstName, String lastName, String date) {
        super(firstName, lastName, date);
    }

    @Override
    public void sayHello(){
        System.out.println("Hello teacher, " + getFullName());
    }

}
