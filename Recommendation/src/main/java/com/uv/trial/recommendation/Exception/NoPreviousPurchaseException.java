package com.uv.trial.recommendation.Exception;

public class NoPreviousPurchaseException extends RuntimeException
{
    public NoPreviousPurchaseException()
    {
        super("No Previous Purchase Found");
    }
}
