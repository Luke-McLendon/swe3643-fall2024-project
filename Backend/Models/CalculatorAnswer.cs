namespace Backend.Models
{
   public class CalculatorAnswer<T> : CalculatorResponse
   {
      public T? Data { get; set; }

      public CalculatorAnswer() : base (false, "")
      {
         Data = default(T);
      }

      public CalculatorAnswer(bool success, string msg, T value) : base(success, msg)
      {
         Data = value;
      }
   }
}
