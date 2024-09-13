// Number Guessing Game
import java.util.Random;   //Importing the Random Class
import java.util.Scanner;  //Importing the Scanner Class

public class NumberGuessingGame {  
    public static void main(String[] args) 
    {  
        Scanner scan = new Scanner(System.in);  //Here we use scan method  
        Random r = new Random();   //Here we use random method
        
        System.out.println("@@\t**Welcome to the Number Guessing0 Game!**\t@@");  
        
        while (true) 
        {  
            // 1:-To Generate a random number within the specified range  
            int numbToGuess = r.nextInt(100) + 1; // Here we specify range to get input from user from 1-100  
            int attempt = 0;  // initially we set attempt as 0
            int maximumattempt = 10; // Here we set maximum number of attempts(10)
            int scores = 0; // initially we set the score as 0 

            System.out.println("\nI have chosen a number between 1 and 100. You have " + maximumattempt + " attempts to guess it.");  


            // 2:- Ask the user to enter the guess   
            while (attempt < maximumattempt) 
            {  
                System.out.print("Enter your guess: ");  // print statement 
                int guess = scan.nextInt();                //scan statement to scan the number enter by the user
                attempt++; // Increment  

                // 3:- To Compare the user's guess with the generated number by the program  
                if (guess < numbToGuess)
                {  
                    System.out.println("Too low!!! Try again."); //if guess is low  
                } else if (guess > numbToGuess) 
                {  
                    System.out.println("Too high!!!! Try again.");  //if guess is high
                } else 
                {  
                    System.out.println("##\t**Congratulations! You have guessed the Right number**\t##"+numbToGuess+" in "+attempt+" attempts.");  
                    break; // break statement to exit the loop after guessing the right number
                }  
            }  

            // 4:-If the user did not guess the Right number within the maximum attempts  
            if (attempt == maximumattempt) 
            {  
                System.out.println("Sorry! You Loose the Number Game. The number was " + numbToGuess + ".");  
            }  

            // 5:- Adding the options for playing multiple round of game   
            System.out.print("Do you want to play Number Game again? (yes/no):- ");  
            String playAgain = scan.next().toLowerCase();  
            if (!playAgain.equals("yes")) 
            {  
                break; // Exiting the main loop if the user doesn't want to play the game again
            }  
            
            // 6:- Displaying the score  
            scores = maximumattempt - attempt; // Calculating number of attempt by the user  
            System.out.println("Your score for this round: " + scores + " points.");  //Displaying the Score of the user
        }  

        System.out.println("Thank you for playing!");  
        scan.close(); // Closing the scanner method
    }  
}