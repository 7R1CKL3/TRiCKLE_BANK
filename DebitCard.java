
/**
 * This DebitCard class is the child class of BankCard class for this bank project
 * This class stores values for PIN Number, Withdrawal Amount, Date of Withdrawaland and if the withdrawal has been made or not
 * with a constructor to retrive Balance Amount,card ID, Bank Account,
 * Issuer Bank, Client Name and PIN Number from the user.
 * With setters method to return the value while calling the method
 * And mutator method to change the value if required by calling the method
 * with a method to withdraw the amount responding to balance amount and pin number
 *Finally a display method to output the required data
 * @author (Himal Sharma)
 * @version (5.1.0)
 */
public class DebitCard extends BankCard
{
   private int pin_Number;                  //declaring variable of PIN Number
   private int withdrawal_Amount;           //declaring variable of Withdrawal Amount
   private String date_Of_Withdrawal;       //declaring variable of Date of Withdrawal
   private boolean has_Withdrawn;           //declaring data for withdrawn or not
   
   /*
    * constructor of class DebitCard which accecpts parameter as Balance Amount,card ID, Bank Account,
    * Issuer Bank, Client Name and PIN Number
    */
   public DebitCard(double balance_Amount, int card_Id, String bank_Account, String issuer_Bank, String client_Name, int pin_Number)
   {
       super(card_Id,issuer_Bank,bank_Account,balance_Amount);
       super.setclient_Name(client_Name);
       this.pin_Number = pin_Number;
       this.has_Withdrawn = false;
   }
   
   /*
    * getter or accessor method of the declared variable is created for:
    * PIN Number, Withdrawal Amount, Date of Withdrawal, Has Withdrawn
    */
   public int getpin_Number()
   {
       return this.pin_Number;           //return sends the value of the variable when calling the method
   }
   
   public int getwithdrawal_Amount()
   {
       return this.withdrawal_Amount;
   }
   
    public String getdate_Of_Withdrawal()
   {
       return this.date_Of_Withdrawal;
   }
   
    public boolean gethas_Withdrawn()
   {
       return this.has_Withdrawn;
   }

   /*
    * Setter or mutator method to
    *change the value of withdrawal amount
    */
   public void setwithdrawal_Amount(int withdrawal_Amount)
   {
       this.withdrawal_Amount = withdrawal_Amount;
   }
   
   /*
    * withdraw method for withdrawal process
    * after the sufficient balance is present and the pin number is correct and deduct the amount withdrawn
    */
   public void withdraw(int withdrawal_Amount, String date_Of_Withdrawal, int pin_Number)
   {
       if (this.pin_Number == pin_Number && withdrawal_Amount <= super.getbalance_Amount()) {
             this.has_Withdrawn = true;
             this.withdrawal_Amount = withdrawal_Amount;
             double remaining_Balance=super.getbalance_Amount() - withdrawal_Amount;
             super.setbalance_Amount(remaining_Balance);
             this.date_Of_Withdrawal = date_Of_Withdrawal;
             
       }
       else {
           System.out.println("Sorry, you have either entered wrong pin number or your account doesnot have sufficient balance");
        }
   }
   
   /*
    * display method to display the necessary credintals
    * with the relevant condition to show which data to be shown
    */
   public void display()
        {
        super.display();
            if (this.has_Withdrawn == true) { 
            System.out.println("\nWithdrawn Details");            
            System.out.println("\nThe withdrawal amount is "+this.withdrawal_Amount);
            System.out.println("The Date of withdrawal is "+this.date_Of_Withdrawal);
            System.out.println("Your pin number is "+this.pin_Number);
        }
        else {
            System.out.println("\nYour balance amount is "+this.getbalance_Amount());
        }
        }
}