package com.calculatorlogic;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.calculator.models.XMBInput;

import java.util.ArrayList;
import java.util.List;

public class LinearRegression
{
   // ---------------------------------------------------------------------
   // Extraction/Parsing Functions
   // ---------------------------------------------------------------------
   private List<Double> ParseForDoublesLine(String input)
   {
      List<Double> values = new ArrayList<Double>();

      // First split the input by commas.
      String blah = input.replace("\"", "");
      String[] ary = blah.split(",");

      for (String s : ary)
      {
         Double d = Double.valueOf(s);
         values.add(d);
      }

      return values;
   }

   public List<XYPair> IsDataValidForLinearRegression (String input)
   {
      List<XYPair> values = new ArrayList<XYPair> ();

      try
      {
         // First split the input at newlines.
         String blah = input.replace("\"", "");
         String blah2 = blah.replace("\\", "");
         String blah3 = blah2.replace("n", "%");
         String[] ary = blah3.split("%");

         for (String s: ary)
         {
            if (!s.isEmpty())
            {
               // Expect two values per line (comma separated).
               String[] xy = s.split(",");

               if (xy.length != 2)
               {
                  //System.out.println("lr length not 2");
                  return (null);
               }

               XYPair pair = new XYPair();
               pair.x = Double.valueOf(xy[0]);
               pair.y = Double.valueOf(xy[1]);
               values.add(pair);
            }
         }
      }
      catch(Exception e)
      {
         //System.out.println("lr exception");
         return (null);
      }

      if (values.isEmpty())
      {
         //System.out.println("lr size is 0");
         return null;
      }
      //System.out.println("lr good");
      return values;
   }


   public XMBInput IsDataValidForYValue (String input)
   {
      XMBInput d = new XMBInput ();
      try
      {
         List<Double> values = ParseForDoublesLine(input);

         //System.out.println(values);
         //if (values == null)
         //{
         //   //System.out.println("y value bad");
         //   return (null);
         //}
         if (values.size() != 3)
         {
            return (null);
         }
         else
         {
            d.x = values.get(0);
            d.m = values.get(1);
            d.b = values.get(2);
            //System.out.println("y value good");
         }
      }

      catch (Exception e)
      {
         //System.out.println("y value exception");
         return (null);
      }
      return (d);
   }

   public String CalculateLinearRegression(List<XYPair> values)
   {
      if ((values == null) || (values.isEmpty()))
         return null;
      // Find averages for x and y
      double sumx = 0.0, sumy = 0.0;
      for (XYPair pair : values)
      {
         sumx += pair.x;
         sumy += pair.y;
      }
      double avgx = sumx / values.size();
      double avgy = sumy / values.size();

      // Find sum of the square of differences
      double sumsqx = 0.0;
      double mtemp = 0.0;
      for (XYPair pair : values)
      {
         sumsqx += Math.pow((avgx - pair.x), 2);
         double t = (avgx - pair.x) * (avgy - pair.y);
         //System.out.println(t);
         mtemp += t;
      }
      //System.out.println(sumsqx);
      double m = mtemp / sumsqx;
      double b = avgy - (m * avgx);

      return ("y = " + m + "x + " + b);
   }

   public Double CalculateYValue(XMBInput input)
   {
      if (input == null)
           return null;
      double y = input.m * input.x + input.b;
      return (y);
   }
}
