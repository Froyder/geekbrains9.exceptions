package ru.geek.homeworks.lesson9.exeptions;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException(String message) {
       super(message);
    }
}
