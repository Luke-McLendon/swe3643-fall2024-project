using Backend.Models;
using LogicServices;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace Backend.Controllers
{
   public class CalculatorController : Controller
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
      public IActionResult Index()
      {
         return View("Calculator");
      }

      // ----------------------------------------------------------------------
      //
      [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
      public IActionResult Error()
      {
         return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
      }

      // ----------------------------------------------------------------------
      //
      [HttpPost]
      public CalculatorResponse CalculateStdDev([FromBody] string data)
      {
         List<double> values;
         bool isValid = statsSvc.IsDataValidForSampleStandardDeviation(data, out values);
         if (! isValid)
            return (new CalculatorError (false, "Invalid Input", "Standard Deviation format is one number per line"));
         else
         {
            double sd = statsSvc.StandardDeviation(values);
            return (new CalculatorAnswer<double>(true, "Sample Standard Deviation", sd));
         }
      }

      // ----------------------------------------------------------------------
      //
      [HttpPost]
      public CalculatorResponse CalculatePopulationStdDev([FromBody] string data)
      {
         List<double> values;
         bool isValid = statsSvc.IsDataValidForPopulationStandardDeviation(data, out values);
         if (!isValid)
            return (new CalculatorError(false, "Invalid Input", "Standard Deviation format is one number per line"));
         else
         {
            double psd = statsSvc.PopulationStandardDeviation(values);
            return (new CalculatorAnswer<double>(true, "Population Standard Deviation", psd));
         }
      }

      // ----------------------------------------------------------------------
      //
      [HttpPost]
      public CalculatorResponse CalculateMean([FromBody] string data)
      {
         List<double> values;
         bool isValid = statsSvc.IsDataValidForMean(data, out values);
         if (!isValid)
            return (new CalculatorError(false, "Invalid Input", "Mean format is one number per line"));
         else
         {
            double mean = statsSvc.Mean(values);
            return (new CalculatorAnswer<double>(true, "Mean", mean));
         }
      }

      // ----------------------------------------------------------------------
      //
      [HttpPost]
      public CalculatorResponse CalculateZScore([FromBody] string data)
      {
         if (! statsSvc.IsDataValidForZScore(data, out double value, out double mean, out double sd))
            return (new CalculatorError(false, "Invalid Input", "Z-Score format is \"value, mean, stdDev\" on one line separated by commas"));
         {
            double zScore = statsSvc.ZScore(value, mean, sd);
            return (new CalculatorAnswer<double>(true, "Z-Score", zScore));
         }
      }

      // ----------------------------------------------------------------------
      //
      [HttpPost]
      public CalculatorResponse CalculateLinearRegression([FromBody] string data)
      {
         List<XYPair> values;
         if (!linearRegSvc.IsDataValidForLinearRegression(data, out values))
            return (new CalculatorError(false, "Invalid Input", "Simple Linear Regression format is one x, y value per line"));
         {
            string formula = linearRegSvc.CalculateLinearRegression(values);
            return (new CalculatorAnswer<string>(true, "Single Linear Regression Formula", formula));
         }
      }

      // ----------------------------------------------------------------------
      //
      [HttpPost]
      public CalculatorResponse CalculateYValue([FromBody] string data)
      {
         if (!linearRegSvc.IsDataValidForYValue(data, out double x, out double m, out double b))
            return (new CalculatorError(false, "Invalid Input", "Predict Y format is \"x,m,b\" on one line separated by commas"));
         {
            double yValue = linearRegSvc.CalculateYValue(x, m, b);
            return (new CalculatorAnswer<double>(true, "Single Linear Regression Prediction", yValue));
         }
      }
   }
}
