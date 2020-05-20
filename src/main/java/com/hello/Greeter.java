package com.hello;

public class Greeter {
    Counter counter = new Counter();

    public String sayHello() {
        return "Hello!";
    }

    public String sayHello(String name) {

        int len = counter.nameLength(name);
        int letters = counter.nameLetterCount(name);

        return String.format("Hello %s, with name length %d and %d letters.", name, len, letters );
    }
}
