package com.school;


import com.hello.Greeter;
import com.utils.*;
import java.time.ZonedDateTime;

public class PersonImpl implements Person {
    private String firstName;
    private String lastName;
    private String fullName;
    private ZonedDateTime dateOfBirth;

    public PersonImpl(String firstName, String lastName) {
        new PersonImpl(firstName, lastName, null);
    }

    public PersonImpl(String firstName, String lastName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.dateOfBirth = DateConverter.dateStringToZDT(date);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public ZonedDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getAge() {
        return DateConverter.getAgeInYears(dateOfBirth);
    }

    public void sayHello() {
        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello(getFullName()));
    }

    @Override
    public String toString() {
        return  fullName;
    }
}
