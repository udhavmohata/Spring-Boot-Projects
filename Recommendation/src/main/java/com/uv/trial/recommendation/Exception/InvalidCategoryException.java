package com.uv.trial.recommendation.Exception;

public class InvalidCategoryException extends RuntimeException
{
    public InvalidCategoryException()
    {
        super("Entered Category Not Found. Enter a valid Category");
    }
}
