package com.calculatorlogic;

import com.calculator.models.ZScoreInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class DescriptiveStatistics
{
   // ---------------------------------------------------------------------
   // Extraction/Parsing Functions
   // ---------------------------------------------------------------------
   private List<Double> ParseForDoublesList(String input)
   {
      List<Double> values = new ArrayList<Double>();

      String blah = input.replace("\"", "");
      String blah2 = blah.replace("\\", "");
      String blah3 = blah2.replace("n", ",");
      // First split the input at newlines.
      String[] ary = blah3.split(",");
      for (String s : ary)
      {
         if (s != "")
            // TODO: The standard parser for Double strips commas. So 3,3,0 becomes 330. Find a fix for this.
            values.add(Double.valueOf(s));
      }

      return values;
   }

   //get rid of this - unused
   private List<Double> ParseForDoublesLine(String input)
   {
      List<Double> values = new ArrayList<Double>();

      // First split the input by commas.
      String[] ary = input.split(",");

      for (String s : ary)
      {
         if (s != "")
            // TODO: The standard parser for Double strips commas. So 3,3,0 becomes 330. Find a fix for this.
            values.add(Double.valueOf(s));
      }

      return values;
   }

   // ---------------------------------------------------------------------
   // Validation Functions
   // ---------------------------------------------------------------------
   // Performs a combination of parsing input into a list of Doubles, implicitly validating that
   // the input therefore consists of Doubles, as well as validating the more general requirement
   // of the input not being empty. 
   private List<Double> IsValidDoubleList(String input)
   {
      List<Double> values = null;

      try
      {
         values = ParseForDoublesList(input);

         if ((values == null) || (values.size() == 0))
            return null;
      }
      catch (Exception e)
      {
         return (null);
      }

      return (values);
   }

   // Trivial pass-through specifically for standard deviation (in case more specific validations become desired).
   public List<Double> IsDataValidForSampleStandardDeviation(String input)
   {
      List<Double> values = IsValidDoubleList(input);

      if ((values == null) || (values.size() < 2))
         return null;

      return values;
   }

   // Trivial pass-through specifically for standard deviation (in case more specific validations become desired).
   public List<Double> IsDataValidForPopulationStandardDeviation(String input)
   {
      List<Double> values = IsValidDoubleList(input);

      if ((values == null) || (values.size() < 1))
         return null;

      return values;
   }

   // Trivial pass-through specifically for mean (in case more specific validations become desired).
   public List<Double> IsDataValidForMean(String input)
   {
      List<Double> values = IsValidDoubleList(input);

      if ((values == null) || (values.size() < 1))
         return null;

      return values;
   }

   public ZScoreInput IsDataValidForZScore(String input)
   {
      ObjectMapper om = new ObjectMapper();
      ZScoreInput i = null;

      try
      {
         i = om.readValue(input, ZScoreInput.class);
      }
      catch (Exception e)
      {
         //System.out.println(e.getMessage());
         return (null);
      }

      //need to do proper validation here
      if (input == null)
         return null;

      return (i);
   }

   // ---------------------------------------------------------------------
   // Calculation Functions
   // ---------------------------------------------------------------------
   private Double SumOfSquares (List<Double> values)
   {
      // Get the mean.
      Double mean = Mean(values);

      // Get the sum of the squares of the differences between the values and the mean.
      double sumOfSquares = 0.0;
      for (Double d : values)
      {
         double diff = d - mean;
         sumOfSquares += (diff * diff);
      }

      return (sumOfSquares);
   }

   private Double SummationOfList (List<Double> values)
   {
      double sum = 0.0;
      for (Double double1 : values)
      {
         sum += double1;
      }

      return (sum);
   }

   //sample standard deviation
   public Double StandardDeviation(List<Double> values)
   {
      if ((values == null) || (values.size() == 0))
         return null;
      // Get the sum of the squares of the differences between the values and the mean.
      double sumOfSquares = SumOfSquares(values);

      return Math.sqrt(sumOfSquares / (values.size() - 1));
   }

   public Double PopulationStandardDeviation(List<Double> values)
   {
      if ((values == null) || (values.size() == 0))
         return null;
      double sumOfSquares = SumOfSquares(values);

      return Math.sqrt(sumOfSquares / values.size());
   }

   public Double Mean(List<Double> values)
   {
      if ((values == null) || (values.size() == 0))
         return null;
      Double mean = SummationOfList(values) / values.size();
      return (mean);
   }

   public Double ZScore(ZScoreInput input)
   {
      if ((input == null) || (input.stdDev == 0.0))
         return null;
      Double zScore = (input.value - input.mean) / input.stdDev;
      return (zScore);
   }
}