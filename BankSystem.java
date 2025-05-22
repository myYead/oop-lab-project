import java.util.Scanner;


class Account {
    public String customerName;
    public int accountNumber;
    public String accountType;
    public double balance;


// Method to initialize account details
    public void initialize(String name, int accNum, String acType, double initialBalance) {
        this.customerName = name;
        this.accountNumber = accNum;
        this.accountType = acType;
        this.balance = initialBalance;

    }

     // Method to withdraw money
		    public void withdraw(double amount) {
		        if (amount <= balance) {
		            balance -= amount;
		            System.out.println("Amount withdrawn: " + amount);

		        } else {
		            System.out.println("Insufficient balance.You can not withdraw money");
		        }
    }


  // Method to deposit amount
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited: " + amount);
    }
//method to display name and acnumber
public void displayInfo(String name,int AcNumber,String AccountType){

	System.out.println("name: "+name);
	System.out.println("Account Number: "+AcNumber);
	System.out.println("Account Type: "+AccountType);
	}

// Method to display balance
    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

}

// Savings Account class
class SavAccount extends Account {
    public double interestRate = 0.05; // 5% annual interest

    // Method to compute and deposit compound interest
    public void computeAndDepositInterest(double IntRate,int years) {
		IntRate=IntRate/100;
        double compoundInterest = balance * Math.pow((1 + IntRate), years) - balance;
        balance += compoundInterest;
        System.out.println("Interest added for " + years + " year: " + compoundInterest);
    }



}

// Current Account class
class CurrAcount extends Account {
    public double minimumBalance = 1000.0;
    public double serviceCharge = 10.0;



    // Check minimum balance and impose penalty if necessary
    public void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Balance fell below minimum. Service charge imposed: " + serviceCharge);
        }
    }
}


public class BankSystem {
    public static void main(String[] args) {


        SavAccount savings = new SavAccount();
        CurrAcount current = new CurrAcount();

         //ead
         				String AccountType;
						Scanner scanner = new Scanner(System.in);


						System.out.println("Enter your name: ");
						String name = scanner.nextLine();

						System.out.println("Enter Your Account Number: ");
						int AcNumber = scanner.nextInt();



						System.out.println("Initial Balance: ");
						double IniBalance = scanner.nextInt();

						System.out.println("Deposit amount: ");
						double DipoAmount = scanner.nextInt();

						System.out.print("Withdraw amount: ");
						double withdrawAmount = scanner.nextInt();
						scanner.nextLine();


						System.out.println("Account Type(savings or current):" );
						String acType = scanner.nextLine();


						if(acType.equalsIgnoreCase("savings")){
							AccountType="Savings";

							System.out.println("Give Yearly Interest rate: ");
							double IntRate = scanner.nextDouble();
							System.out.println("How many years: ");
							int years = scanner.nextInt();

							System.out.println("------- ");
							System.out.println("------- ");
							System.out.println("Money Recipt:");



							savings.initialize(name, AcNumber, AccountType, IniBalance);
							        savings.deposit(DipoAmount);
							        savings.computeAndDepositInterest(IntRate,years);
							        savings.withdraw(withdrawAmount);
							        savings.displayInfo(name,AcNumber,AccountType);
      							    savings.displayBalance();
							}
							else if(acType.equalsIgnoreCase("current")){
								AccountType="Current";
								System.out.println("Output------- ");
								        current.initialize(name, AcNumber, AccountType, IniBalance);
								        current.deposit(DipoAmount);
								        current.checkMinimumBalance();
								        current.withdraw(withdrawAmount);
								        current.displayInfo(name,AcNumber,AccountType);
        								current.displayBalance();
								}
								else{
									System.out.println("Please Enter valid Account Type");

									}




    }
}
