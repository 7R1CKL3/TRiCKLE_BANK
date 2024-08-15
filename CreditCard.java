
/**
 * This CreditCard class is the child class of BankCard class for this bank project
 *This class stores values for CVC Number, Credit Limit, Interest Rate, Expiration Date, Grace Period 
 *Finally a display method to output the required data
 * @author (Himal Sharma)
 * @version (5.1.0)
 */
public class CreditCard extends BankCard
{
  private int cvc_Number;               //declaring variable of CVC Number
  private double credit_Limit;          //declaring variable of Credit Limit
  private double interest_Rate;         //declaring variable of Interest Rate
  private String expiration_Date;       //declaring variable of Expiration Date
  private int grace_Period;             //declaring variable of Grace Peroid
  private boolean is_Granted;           //declaring data for credit has been granted or not
  
  /*
   * constructor of class CreditCard which accecpts parameters as Card ID, Client Name, Issuer Bank,
   * Bank Amount, Balance Amount, CVC Number, Interest Rate, Expiration Date
   */
  public CreditCard(int card_Id, String client_Name, String issuer_Bank, String bank_Account, double balance_Amount, int cvc_Number, int interest_Rate, String expiration_Date)
  {
      super(card_Id, issuer_Bank, bank_Account, balance_Amount);
      this.cvc_Number = cvc_Number;
      this.interest_Rate = interest_Rate;
      this.expiration_Date = expiration_Date;
      this.is_Granted = false;
  }
  
  /*
   * getter or accessor method for CVC Number, Credit Limit, Interest Rate, Expiration Date,
   * Grace Period, is_Granted
   */
  public int getcvc_Number()
  {
      return this.cvc_Number;       //return sends the value of the variable when calling the method
  }
  
  public double getcredit_Limit()
  {
      return this.credit_Limit;
  }
  
  public double getinterest_Rate()
  {
      return this.interest_Rate;
  }
  
  public String getexpiration_Date()
  {
      return this.expiration_Date;
  }
  
  public int getgrace_Period()
  {
      return this.grace_Period;
  }
  
  public boolean getis_Granted()
  {
      return this.is_Granted;
  }
  
  /*
   * Setter or mutator method to make a credit if 
   * there is sufficient balance present in the account
   */
  public void setcredit_Limit(double credit_Limit, int grace_Period)
  {
      if (credit_Limit <= 2.5 * getbalance_Amount()) {
          this.is_Granted = true;
          this.credit_Limit = credit_Limit;
          this.grace_Period = grace_Period;
      }
      else {
          System.out.println("The Credit cannot be issued due to insufficient balance");
      }
  }
  
  /*
   * cancelCreditCard method to cancel the Credi
   */
  public void cancelCreditCard()
  {
      this.cvc_Number = 0;
      this.credit_Limit = 0;
      this.grace_Period = 0;
      this.is_Granted = false;
  }
  
  /*
   * display method to display the necessary credintals
   * with the relevant condition to show which data to be shown
   */
  public void display()
  {
      if(is_Granted == true) {
        super.display();
        System.out.println("Credit Card Details\n");
        System.out.println("\nCVC number is " + this.cvc_Number);
        System.out.println("Interest rate is " + this.interest_Rate);
        System.out.println("Expiration Date is " + this.expiration_Date);
        System.out.println("Credit limit is " + this.credit_Limit);
        System.out.println("Grace Period is " + this.grace_Period);
    }
    else {
        System.out.println("Credit Card Details\n");
        System.out.println("\nCVC number is " + this.cvc_Number);
        System.out.println("Interest rate is " + this.interest_Rate);
        System.out.println("Expiration Date is " + this.expiration_Date);
    }
  }
}
