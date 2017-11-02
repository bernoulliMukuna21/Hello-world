import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class HelloWorld {

  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    ArrayList<Integer> dataInput = new ArrayList<Integer>();
    System.out.println("Enter: ");
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      for(String dt: line.split("~")){
        dataInput.add(Integer.parseInt(dt));
      }
      System.out.println(dataInput);
      monthlyPayAndToIntPay(dataInput);
    }
  }
  static void monthlyPayAndToIntPay(ArrayList<Integer>givenData){
	    int loanAmount = givenData.get(0);
	    /*
	    * Since i am going to work out the monthly payment, i would have to convert
	    * the period of time to pay from years to months. the line of code will do
	    * that for me.
	    */
	    double numberOfPeriods = givenData.get(1)*12;
	    /**
	     * Now i am going to convert the interest rate from annual to monthly. the 
	     * line below will do that for me.
	    */
	    double ratePerPeriod = (double )givenData.get(2)/1200;
	    int downPayment = givenData.get(3);
	    int presentValue = loanAmount-downPayment;
	    /**
	     * right below is the calculation of the monthly fixed payment.
	    */
	    double monthlyPayment = (double)
	    (ratePerPeriod*presentValue)/(1-(Math.pow((1+ratePerPeriod),-numberOfPeriods)));
	    /**
	     * here is the total interest payment. i have taken the monthly fixed payment
	     * then multiply it by the period of repayments in months. Then i have subtracted 
	     * by present value
	    */
	    double totalIntPay = (monthlyPayment*numberOfPeriods)-presentValue;
	    System.out.println("$"+decimalConversion(monthlyPayment)
	                       +"~$"+Math.round(totalIntPay));
	  }
	  /**
	   * this method beow is to convert a number to two decimal places.
	  */
	  static double decimalConversion(double a){
	    a = Math.round(a*100);
	    a = a/100;
	    return a;
	  }
}
