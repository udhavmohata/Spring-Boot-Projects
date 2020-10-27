package com.uv.trial.recommendation.Exception;

public class InvalidBrandException extends RuntimeException
{
    public InvalidBrandException(String s)
    {
        super(s+" Not Found");
    }

}
