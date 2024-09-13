
import java.util.Scanner;

public class StudentGradeCalculator
 {
    public static void main(String[] args)
     {
        Scanner s = new Scanner(System.in);     //scanner method is used

        // Here we take the (input) number of subject from the user 
        System.out.print("Enter the number of subjects:- ");
        int noOfSubjects = s.nextInt();

        // Creating an array to store the marks of each subject
        int[] marks = new int[noOfSubjects];
        int t_Marks = 0;                

        
        // Taking the input for the number of marks in each subject
        for (int i = 0; i < noOfSubjects; i++)      //for loop to perform number of iteration to take marks
        {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = s.nextInt();
            t_Marks =t_Marks + marks[i]; // Summing up the marks 
        }

      
        // Calculating Average Percentage of Student
        double avgPercentage = (double) t_Marks / noOfSubjects;

        //Calculating the grade of Student
        String grade;
        if (avgPercentage >= 90)        //Using if-else loop for displaying Grades 
        {
            grade = "A";
        } 
        else if (avgPercentage >= 80)
        {
            grade = "B";
        } 
        else if (avgPercentage >= 60) 
        {
            grade = "C";
        }
         else if (avgPercentage >= 35) 
        {
            grade = "D";
        } 
        else 
        {
            grade = "Fail";
        }

        // Displaying output of the following program
        System.out.println("Total Marks: " + t_Marks);
        System.out.println("Average Percentage: " + avgPercentage);
        System.out.println("Grade: " + grade);

        // Closing the scanner
        s.close();
    }
}

