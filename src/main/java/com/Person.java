package com;

import java.time.ZonedDateTime;

public interface Person {

    String getFirstName();

    String getLastName();

    String getFullName();

    ZonedDateTime getDateOfBirth();

    Long getAge();

    void sayHello();
}