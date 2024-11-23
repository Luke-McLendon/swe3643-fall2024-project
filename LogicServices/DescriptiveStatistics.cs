using System.Text.RegularExpressions;

namespace LogicServices
{
   public class DescriptiveStatistics
   {
      // ---------------------------------------------------------------------
      // Extraction/Parsing Functions
      // ---------------------------------------------------------------------
      private List<double> ParseForDoublesList(string input)
      {
         List<double> values = new List<double>();

         // First split the input at newlines.
         string[] ary = Regex.Split(input, "\r\n|\r|\n");

         foreach (var s in ary)
         {
            if (s != "")
               // TODO: The standard parser for double strips commas. So 3,3,0 becomes 330. Find a fix for this.
               values.Add(double.Parse(s));
         }

         return values;
      }

      private List<double> ParseForDoublesLine(string input)
      {
         List<double> values = new List<double>();

         // First split the input by commas.
         string[] ary = Regex.Split(input, ",");

         foreach (var s in ary)
         {
            if (s != "")
               // TODO: The standard parser for double strips commas. So 3,3,0 becomes 330. Find a fix for this.
               values.Add(double.Parse(s));
         }

         return values;
      }

      // ---------------------------------------------------------------------
      // Validation Functions
      // ---------------------------------------------------------------------
      // Performs a combination of parsing input into a list of doubles, implicitly validating that
      // the input therefore consists of doubles, as well as validating the more general requirement
      // of the input not being empty. 
      private bool IsValidDoubleList(string input, out List<double> values)
      {
         values = null;

         try
         {
            values = ParseForDoublesList(input);

            if ((values == null) || (values.Count == 0))
               return false;
         }
         catch
         {
            return (false);
         }

         return (true);
      }

      // Trivial pass-through specifically for standard deviation (in case more specific validations become desired).
      public bool IsDataValidForSampleStandardDeviation(string input, out List<double> values)
      {
         bool okay = IsValidDoubleList(input, out values);

         if ((!okay) || (values.Count < 2))
            return false;

         return true;
      }

      // Trivial pass-through specifically for standard deviation (in case more specific validations become desired).
      public bool IsDataValidForPopulationStandardDeviation(string input, out List<double> values)
      {
         return IsValidDoubleList(input, out values);
      }

      // Trivial pass-through specifically for mean (in case more specific validations become desired).
      public bool IsDataValidForMean(string input, out List<double> values)
      {
         return IsValidDoubleList(input, out values);
      }

      public bool IsDataValidForZScore(string input, out double value, out double mean, out double sd)
      {
         value = 0;
         mean = 0;
         sd = 0;
         try
         {
            List<double> values = ParseForDoublesLine(input);

            if ((values == null) || (values.Count != 3))
               return false;
            else
            {
               if (values[2] == 0)
                  return (false);

               value = values[0];
               mean = values[1];
               sd = values[2];
            }
            return (true);
         }
         catch
         {
            return (false);
         }
      }

      // ---------------------------------------------------------------------
      // Calculation Functions
      // ---------------------------------------------------------------------
      public double StandardDeviation(List<double> values)
      {
         // Get the mean.
         double mean = Mean(values);

         // Get the sum of the squares of the differences
         // between the values and the mean.
         var squares_query =
             from double value in values
             select (value - mean) * (value - mean);
         double sum_of_squares = squares_query.Sum();

         return Math.Sqrt(sum_of_squares / (values.Count() - 1));
      }

      public double PopulationStandardDeviation(List<double> values)
      {
         // Get the mean.
         double mean = values.Sum() / values.Count();

         // Get the sum of the squares of the differences
         // between the values and the mean.
         var squares_query =
             from double value in values
             select (value - mean) * (value - mean);
         double sum_of_squares = squares_query.Sum();

         return Math.Sqrt(sum_of_squares / values.Count());
      }

      public double Mean(List<double> values)
      {
         double mean = values.Sum() / values.Count();
         return (mean);
      }

      public double ZScore(double value, double mean, double stdDev)
      {
         double zScore = (value - mean) / stdDev;
         return (zScore);
      }
   }
}
