class calculator
{
   #displayElement;
   #instructions = "Enter values below, then select an operation.";

   showInstructions ()
   {
      // TODO: Remove the "error" class if it happens to be there.
      this.#displayElement.innerHTML = this.#instructions;
   }

   // The display area has three different formats.
   //    1. Instructions only (one line centered vertically and horizontally)
   //    2. Results with one line for result type, and a second line with the calculated value. Both are centered vertically and horizontally.
   //    3. Error with one line to indicate the error and a second line with a reminder of the correct format. Both are centered vertically and horizontally.
   //       Additionally, the background should turn red (along with the font color becoming white).
   displayResult (result)
   {
      let r = JSON.parse(result);
      if (r.successful)
      {
         let msg = "<span>" + r.message + "</span><span>" + r.data + "</span>";
         this.#displayElement.innerHTML = msg;
         // In case the display is currently showing an error.
         this.#displayElement.classList.remove("error");
         this.#displayElement.classList.add("normal");
      }
      else
      {
         let msg = "<span>" + r.message + "</span><span>" + r.message2 + "</span>";
         this.#displayElement.innerHTML = msg;
         this.#displayElement.classList.remove("normal");
         this.#displayElement.classList.add ("error");
      }
   }

   makeRequest (cmd, url, data)
   {
      let self = this;
      let xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function ()
      {
         if (this.readyState == 4 && this.status == 200)
         {
            self.displayResult (xhttp.responseText);
         }
      };

      xhttp.open(cmd, url, true);

      xhttp.setRequestHeader("Content-Type", "application/json");
      let json = JSON.stringify(data);
      xhttp.send(json);
   }

   collectData ()
   {
      let valuesElement = document.getElementById("valuesInput");

      // In case we wish to parse the input on the client as well...
      //let lines = valuesElement.value.split("\n");
      let lines = valuesElement.value;
      return (lines);
   }

   clear ()
   {
      // Set the values input box to blank
      let valuesElement = document.getElementById("valuesInput");
      valuesElement.value = "";

      // Reset the display to the default instruction string.
      this.showInstructions();
   }

   requestStdDev ()
   {
      let data = this.collectData();
      this.makeRequest ("POST", "/Calculator/CalculateStdDev", data);
   }

   requestPopulationStdDev ()
   {
      let data = this.collectData();
      this.makeRequest("POST", "/Calculator/CalculatePopulationStdDev", data);
   }

   requestMean ()
   {
      let data = this.collectData();
      this.makeRequest("POST", "/Calculator/CalculateMean", data);
   }

   requestZScore ()
   {
      let valuesElement = document.getElementById("valuesInput");
      let values = valuesElement.value.split(",");
      let json = { value: values[0], mean: values[1], stdDev: values[2] };

      this.makeRequest("POST", "/Calculator/CalculateZScore", json);
   }

   requestLinearRegression ()
   {
      let data = this.collectData();
      this.makeRequest("POST", "/Calculator/CalculateLinearRegression", data);
   }

   requestYValue ()
   {
      let data = this.collectData();
      this.makeRequest("POST", "/Calculator/CalculateYValue", data);
   }

   init ()
   {
      let clear = document.getElementById("clear");
      clear.addEventListener("click", () => { this.clear() });

      let stdDev = document.getElementById("stdDev");
      stdDev.addEventListener("click", () => { this.requestStdDev() });

      let popStdDev = document.getElementById("popStdDev");
      popStdDev.addEventListener("click", () => { this.requestPopulationStdDev() });

      let mean = document.getElementById("mean");
      mean.addEventListener("click", () => { this.requestMean() });

      let zscore = document.getElementById("zscore");
      zscore.addEventListener("click", () => { this.requestZScore() });

      let linreg = document.getElementById("linreg");
      linreg.addEventListener("click", () => { this.requestLinearRegression() });

      let compy = document.getElementById("compy");
      compy.addEventListener("click", () => { this.requestYValue() });

      this.#displayElement = document.getElementById("display");
      this.showInstructions();
   }
}
