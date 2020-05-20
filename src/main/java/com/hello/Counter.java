package com.hello;

public class Counter {
    public int nameLength(String name){
        return name.length();
    }

    public int nameLetterCount(String name){
        int len = name.length();
        int letterCount = 0;
        for (int i = 0; i<len; i++){
            if (Character.isLetter(name.charAt(i))){
                letterCount++;
            }
        }
        return letterCount;
    }
}
