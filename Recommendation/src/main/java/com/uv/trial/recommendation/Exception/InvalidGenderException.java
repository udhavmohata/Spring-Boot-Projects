package com.uv.trial.recommendation.Exception;

public class InvalidGenderException extends RuntimeException
{
    public InvalidGenderException()
    {
        super("Enter a valid Gender");
    }
}
