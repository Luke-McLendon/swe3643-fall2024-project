namespace Backend.Models
{
   public class CalculatorError : CalculatorResponse
   {
      public string Message2 { get; set; }

      public CalculatorError (bool success, string msg, string msg2) : base(success, msg)
      {
         Message2 = msg2;
      }
   }
}
