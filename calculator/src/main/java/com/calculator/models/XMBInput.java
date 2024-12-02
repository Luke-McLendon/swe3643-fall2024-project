package com.calculator.models;

public class XMBInput
{
    public double x = 0;
    public double m = 0;
    public double b = 0;

    @Override
    public boolean equals(Object obj)
    {
        XMBInput xmb = (XMBInput)obj;

        if ((xmb.x == x) && (xmb.m == m) && (xmb.b == b))
            return true;
        return false;
    }
}