package com.uv.trial.recommendation.Exception;

public class NotUniqueException extends RuntimeException
{
    public NotUniqueException() {
        super("Entered Mobile Number already exists");
    }
}
