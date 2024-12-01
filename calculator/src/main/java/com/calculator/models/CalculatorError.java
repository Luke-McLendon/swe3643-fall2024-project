package com.calculator.models;

   public class CalculatorError extends CalculatorResponse
   {
      public String Message2;

      public CalculatorError (Boolean success, String msg, String msg2)
      {
         super(success, msg);
         Message2 = msg2;
      }
   }

