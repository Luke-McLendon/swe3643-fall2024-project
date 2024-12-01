package com.calculator.models;

public class ZScoreInput
{
    public double value;
    public double mean;
    public double stdDev;

    public String toString()
    {
        return value + ", " + mean + ", " + stdDev;
    }

    public boolean equals (Object o)
    {
        ZScoreInput z = (ZScoreInput)o;

        if ((z.value == value) && (z.mean == mean)  && (z.stdDev == stdDev))
            return true;
        return false;
    }
}