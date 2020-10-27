package com.uv.trial.recommendation.EncoderDecoder;

import java.util.Base64;

public class Base64Encryption
{
    public String Encode(String code)
    {
        return Base64.getEncoder().encodeToString(code.getBytes());
    }



    public String Decode(String code)
    {
        Base64.Decoder decoder = Base64.getDecoder();
        String[] str = code.split(" ");
        return new String(decoder.decode(str[1]));
    }
}
