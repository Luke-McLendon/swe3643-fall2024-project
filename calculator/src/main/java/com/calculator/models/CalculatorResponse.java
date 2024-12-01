package com.calculator.models;

   public class CalculatorResponse
   {
      public Boolean Successful;
      public String Message;

      public CalculatorResponse()
      {
         Successful = false;
         Message = "Call completed.";
      }

      public CalculatorResponse(Boolean success, String msg)
      {
         Successful = success;
         Message = msg;
      }
   }
