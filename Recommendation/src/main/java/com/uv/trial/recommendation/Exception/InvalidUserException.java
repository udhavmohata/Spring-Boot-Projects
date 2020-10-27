package com.uv.trial.recommendation.Exception;

public class InvalidUserException extends RuntimeException
{
    public InvalidUserException() {
        super("Invalid username and password");
    }
}
