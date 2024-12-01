package com.calculator.models;

public class CalculatorAnswer extends CalculatorResponse
{
   public Object Data = null;

   public CalculatorAnswer(Boolean success, String msg, Object value)
   {
      super(success, msg);
      Data = value;
   }
}