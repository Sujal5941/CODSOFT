import java.util.Scanner;  

//creating class BankAccount
class BankAccount 
{  
    private double balance;   // keep balance private

    public BankAccount(double initialBalance) 
    {  
        if (initialBalance >= 0) //This segment is for initial balance(validates the initial amount)
        {  
            this.balance = initialBalance;  
        }
         else 
        {  
            this.balance = 0.0;  
            System.out.println("Invalid initial balance. Setting to $0.0.");  
        }  
    }  

    public double getBalance()  //Get the Current balance
    {  
        return balance;  
    }  

    public boolean deposit(double amount)  //Deposit a specified amount
    {  
        if (amount > 0)     //if-else block for checking whether the amount is positive
        {  
            balance = balance + amount;  
            return true;  
        }  
        return false;  
    }  

    public boolean withdraw(double amount) //Withdraw a specified amount
    {  
        if (amount > 0 && amount <= balance)  //if-else block for checking whether the amount is positive and does not exceed the current balance
        {                                     
            balance = balance - amount;  
            return true;  
        }  
        return false;  
    }  
}  

//Creating class ATM to Acts as the interface for the user to interact with their BankAccount.  
class ATM 
{  
    private BankAccount account;  

    public ATM(BankAccount account)
    {  
        this.account = account;  
    }  

    public void displayMenu()  // Displaying a menu of options (check balance, deposit, withdraw, exit).
    {  
        System.out.println("Welcome to the ATM!");  
        System.out.println("1. Check Balance");  
        System.out.println("2. Deposit");  
        System.out.println("3. Withdraw");  
        System.out.println("4. Exit");  
        System.out.print("Choose an option: ");  
    }  

    public void checkBalance()      //Checking and displaying the current balance of the account.
    {  
        System.out.printf("Your balance: $%.2f%n", account.getBalance());  
    }  

    public void deposit() 
    {  
        Scanner scan = new Scanner(System.in);       //Handaling the deposit by taking deposited amount from the user 
        System.out.print("Enter amount to deposit: ");  
        double amount = scan.nextDouble();  

        if (account.deposit(amount))        //if-else block to check the deposited amount is successfully deposited or not
        {  
            System.out.printf("Successfully deposited: $%.2f%n", amount);  
        }
        else
        {  
            System.out.println("Deposit failed. Please enter a valid amount.");  
        }  
    }  

    public void withdraw()      //Handaling the Withdrawals by taking Withdrawal amount from the user 
    {  
        Scanner scan = new Scanner(System.in);  
        System.out.print("Enter amount to withdraw: ");  
        double amount = scan.nextDouble();  

        if (account.withdraw(amount))       //if-else block to check the Withdrawal amount is successfully Withdrawal or not
        {  
            System.out.printf("Successfully withdrew: $%.2f%n", amount);  
        }
        else 
        {  
            System.out.println("Withdrawal failed. Please check your balance or enter a valid amount.");  
        }  
    }  

    public void run()       //Running the ATM menu in a loop until the user decides to exit. 
    {  
        Scanner scan = new Scanner(System.in);  
        int choice;  
        do {  
            displayMenu();  
            choice = scan.nextInt();  
            switch (choice) 
            {  
                case 1:  
                    checkBalance();  
                    break;  
                case 2:  
                    deposit();  
                    break;  
                case 3:  
                    withdraw();  
                    break;  
                case 4:  
                    System.out.println("Thank you for using the ATM. Goodbye!");  
                    break;  
                default:  
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");  
            }  
            System.out.println();  
        } while (choice != 4);  
    }  
}  

public class AtmInterface 
{  
    public static void main(String[] args)
    {  
        // Create a bank account with an initial balance  
        BankAccount account = new BankAccount(1000.0);      //Creates an instance of BankAccount with an example initial balance of $1000.00.
        ATM atm = new ATM(account);  
        atm.run();  
    }  
}