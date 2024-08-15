/**
 * This BankCard class is the parent class for this bank project
 * This class stores values for card ID, Client Name, Issuer Bank, Bank Account and Balance Amount
 * and constructor to accecpt the above data from the user
 * with getter or accessor method to return the vaules of their corresponding value while calling it from other class
 * and setter or mutator method to change the pre-existing data.
 * Finally a display method to output the required data
 * @author (Himal Sharma)
 * @version (5.1.0)
 */
public class BankCard
{
   private int card_Id;                     //declaring variable card ID
   private String client_Name;              //declaring variable Client Name
   private String issuer_Bank;              //declaring variable Issuer Bank
   private String bank_Account;             //declaring variable Bank Account
   private double balance_Amount;           //declaring variable Balance Amount
   
   
   /*constructor of class BankCard which accecpts parameter as card ID, Issuer Bank,Bank Account,
    Balance Amount */
   public BankCard(int card_Id, String issuer_Bank, String bank_Account, double balance_Amount)
   {
       this.card_Id = card_Id;
       this.client_Name = "";
       this.bank_Account = bank_Account;
       this.balance_Amount = balance_Amount;
       this.issuer_Bank = issuer_Bank;
   }
   
   /*
    * getter or accessor method of the declared variable is created for:
    * card ID, Client Name, Bank Account, Balance Amount, Issuer Bank
    */
   public int getCard_Id()
   {
       return this.card_Id;         //return sends the value of the variable when calling the method
   }
   
   public String getclient_Name()
   {
       return this.client_Name;
   }
   
   public String getbank_Account()
   {
       return this.bank_Account;
   }
   
   public double getbalance_Amount()
   {
       return this.balance_Amount;
   }
   
   public String getissuer_Bank()
   {
       return this.issuer_Bank;
   }

   /*
    * Setter or mutator method for Client Name and Balance Amount
    * is created to change their value
    */
   public void setclient_Name(String client_Name)
   {
       this.client_Name = client_Name;
   }
   
   public void setbalance_Amount(double balance_Amount)
   {
       this.balance_Amount = balance_Amount;
   }
   
   /*
    * display method is created to display the user credintals
    * with a condition to display enter Client Name if not entered
    */
   public void display()
   {
       System.out.println("Your card Id is "+card_Id);
       System.out.println("Your issuer bank is "+issuer_Bank);
       System.out.println("Your bank account is "+bank_Account);
       System.out.println("Your balance amount is "+balance_Amount);
       if (client_Name == "") {
           System.out.println("Please enter the client name\n");
       }
       else {
           System.out.println("Your client name is "+client_Name);
       }
   }
   
}
