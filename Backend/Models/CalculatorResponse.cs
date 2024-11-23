namespace Backend.Models
{
   public class CalculatorResponse
   {
      public bool Successful { get; set; }
      public string Message { get; set; }

      public CalculatorResponse()
      {
         Successful = false;
         Message = "Call completed.";
      }

      public CalculatorResponse(bool success, string msg)
      {
         Successful = success;
         Message = msg;
      }
   }
}