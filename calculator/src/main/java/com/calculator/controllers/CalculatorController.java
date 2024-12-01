package com.calculator.controllers;

import java.util.List;

import com.calculator.models.*;
import com.calculatorlogic.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController
{
   private DescriptiveStatistics statsSvc;
   private LinearRegression linearRegSvc;

   // ----------------------------------------------------------------------
   //
   public CalculatorController() 
   {
      statsSvc = new DescriptiveStatistics();
      linearRegSvc = new LinearRegression();
   }

   // ----------------------------------------------------------------------
   //
   private String toJSON (Object o)
   {
      ObjectMapper om = new ObjectMapper();
      String json = null;
      try
      {
         json = om.writeValueAsString (o);
      }
      catch (Exception e)
      {
      }

      return (json);
   }
   
   // ----------------------------------------------------------------------
   //
   @PostMapping(path="/CalculateStdDev", consumes = MediaType.APPLICATION_JSON_VALUE,
           produces = MediaType.APPLICATION_JSON_VALUE)
   public String CalculateStdDev(@RequestBody String data)
   {
      //ZScoreInput i = om.readValue(data, ZScoreInput.class);
      List<Double> values = statsSvc.IsDataValidForSampleStandardDeviation(data);
      if (values == null)
      {
         CalculatorError error = new CalculatorError(false, "Invalid Input", "Standard Deviation format is one number per line");
         return (toJSON (error));
      }
      else
      {
         Double sd = statsSvc.StandardDeviation(values);
         CalculatorAnswer answer = new CalculatorAnswer(true, "Sample Standard Deviation", sd);
         return (toJSON (answer));
      }
   }

   // ----------------------------------------------------------------------
   //
   @PostMapping(path="/CalculatePopulationStdDev", consumes = MediaType.APPLICATION_JSON_VALUE,
           produces = MediaType.APPLICATION_JSON_VALUE)
   public String CalculatePopulationStdDev(@RequestBody String data)
   {
      List<Double> values = statsSvc.IsDataValidForPopulationStandardDeviation(data);
      if (values == null) {
         CalculatorError error = new CalculatorError(false, "Invalid Input", "Pop-Standard Deviation format is one number per line");
         return (toJSON (error));
      }
      else
      {
         Double psd = statsSvc.PopulationStandardDeviation(values);
         CalculatorAnswer answer = new CalculatorAnswer(true, "Population Standard Deviation", psd);
         return (toJSON (answer));
      }
   }

   // ----------------------------------------------------------------------
   //
   @PostMapping(path="/CalculateMean", consumes = MediaType.APPLICATION_JSON_VALUE,
           produces = MediaType.APPLICATION_JSON_VALUE)
   public String CalculateMean(@RequestBody String data)
   {
      List<Double> values = statsSvc.IsDataValidForMean(data);
      if (values == null)
      {
         CalculatorError error = new CalculatorError(false, "Invalid Input", "Mean format is one number per line");
         return (toJSON (error));
      }
      else
      {
         Double mean = statsSvc.Mean(values);

         CalculatorAnswer answer = new CalculatorAnswer(true, "Mean", mean);
         return (toJSON (answer));
      }
   }

   // ----------------------------------------------------------------------
   //
   @PostMapping(path="/CalculateZScore", consumes = MediaType.APPLICATION_JSON_VALUE,
           produces = MediaType.APPLICATION_JSON_VALUE)
   public String CalculateZScore(@RequestBody String data)
   {
      ZScoreInput z = statsSvc.IsDataValidForZScore(data);

      if (z == null)
      {
         CalculatorError error = new CalculatorError(false, "Invalid Input", "Z-Score format is \"value, mean, stdDev\" on one line separated by commas");
         return (toJSON (error));
      }
      else
      {
         Double zScore = statsSvc.ZScore(z);
         CalculatorAnswer answer = new CalculatorAnswer(true, "Z-Score", zScore);
         return (toJSON (answer));
      }
   }

   // ----------------------------------------------------------------------
   //
   @PostMapping(path="/CalculateLinearRegression", consumes = MediaType.APPLICATION_JSON_VALUE,
           produces = MediaType.APPLICATION_JSON_VALUE)
   public CalculatorResponse CalculateLinearRegression(@RequestBody String data)
   {
      List<XYPair> values = linearRegSvc.IsDataValidForLinearRegression(data);
      if (values == null)
         return (new CalculatorError(false, "Invalid Input", "Simple Linear Regression format is one x, y value per line"));
      else
      {
         String formula = linearRegSvc.CalculateLinearRegression(values);
         return (new CalculatorAnswer(true, "Single Linear Regression Formula", formula));
      }
   }

   // ----------------------------------------------------------------------
   //
   @PostMapping(path="/CalculateYValue", consumes = MediaType.APPLICATION_JSON_VALUE,
           produces = MediaType.APPLICATION_JSON_VALUE)
   public CalculatorResponse CalculateYValue(@RequestBody String data)
   {
      XMBInput input = linearRegSvc.IsDataValidForYValue(data);
      if (input == null)
         return (new CalculatorError(false, "Invalid Input", "Predict Y format is \"x,m,b\" on one line separated by commas"));
      else
      {
         Double yValue = linearRegSvc.CalculateYValue(input);
         return (new CalculatorAnswer(true, "Single Linear Regression Prediction", yValue));
      }
   }
}
