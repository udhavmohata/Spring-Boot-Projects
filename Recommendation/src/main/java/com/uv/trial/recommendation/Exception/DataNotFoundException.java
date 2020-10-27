package com.uv.trial.recommendation.Exception;

public class DataNotFoundException extends RuntimeException
{
    public DataNotFoundException()
    {
        super("Product of this Size Not Available");
    }
}
