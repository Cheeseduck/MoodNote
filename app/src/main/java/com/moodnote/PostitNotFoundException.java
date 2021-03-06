package com.moodnote;

public class PostitNotFoundException extends RuntimeException{

    public PostitNotFoundException(String message) {
        super(message);
    }
}
