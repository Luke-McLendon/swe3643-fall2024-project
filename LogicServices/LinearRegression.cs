using System.Linq;
using System.Text.RegularExpressions;

namespace LogicServices
{
   public class XYPair
   {
      public double x { get; set; }
      public double y { get; set; }
   }

   public class LinearRegression
   {
      // ---------------------------------------------------------------------
      // Extraction/Parsing Functions
      // ---------------------------------------------------------------------
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

      public bool IsDataValidForLinearRegression (string input, out List<XYPair> values)
      {
         values = new List<XYPair> ();

         try
         {
            // First split the input at newlines.
            string[] ary = Regex.Split(input, "\r\n|\r|\n");

            foreach (var s in ary)
            {
               if (s != "")
               {
                  // Expect two values per line (comma separated).
                  string[] xy = s.Split(',');

                  if (xy.Length != 2)
                     return (false);

                  XYPair pair = new XYPair();
                  pair.x = double.Parse(xy[0]);
                  pair.y = double.Parse(xy[1]);
                  values.Add(pair);
               }
            }
         }
         catch
         {
            return (false);
         }

         if (values.Count == 0)
            return false;

         return true;
      }

      public bool IsDataValidForYValue (string input, out double x, out double m, out double b)
      {
         x = 0;
         m = 0;
         b = 0;
         try
         {
            List<double> values = ParseForDoublesLine(input);

            if ((values == null) || (values.Count != 3))
               return false;
            else
            {
               x = values[0];
               m = values[1];
               b = values[2];
            }
            return (true);
         }
         catch
         {
            return (false);
         }
      }

      public string CalculateLinearRegression(List<XYPair> values)
      {
         // Find averages for x and y
         double sumx = 0, sumy = 0;
         foreach (XYPair pair in values)
         {
            sumx += pair.x;
            sumy += pair.y;
         }
         double avgx = sumx / values.Count;
         double avgy = sumy / values.Count;

         // Find sum of the square of differences
         double sumsqx = 0;
         double mtemp = 0;
         foreach (XYPair pair in values)
         {
            sumsqx += Math.Pow((avgx - pair.x), 2);
            double t = (avgx - pair.x) * (avgy - pair.y);
            mtemp += t;
         }
         double m = mtemp / sumsqx;
         double b = avgy - (m * avgx);

         return ("y = " + m + "x + " + b);
      }

      public double CalculateYValue(double x, double m, double b)
      {
         double y = m * x + b;
         return (y);
      }
   }
}
