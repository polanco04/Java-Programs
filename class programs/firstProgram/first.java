import java.util.Scanner;

class Main {
    // Method to ask the user what their first and last name is.
    // If they are the same, a message is printed stating that they 
    // are the same.
    static void askUsername()
    {
        String fname, lname;
        Scanner name = new Scanner(System.in);

        System.out.println("Please enter your first and last name: ");
        fname = name.next(); // reads in the first name
        lname = name.next(); // reads in the last name

        if(fname.equals(lname))
        {
            // prints if the user's first and last name are the same.
            System.out.println("Your first and last name are the same.");      
        }
    }
    
    // Method to ask the user about their pizza party.
    // It asks the user to enter how many people will be 
    // attending and how many pizzas will they order. 
    // Based on this, it finds how many slices each person will get 
    // and how many will be left over. 
    static void pizzaSlices()
    {
        int pizzas, people, slices;
        Scanner party = new Scanner(System.in);

        System.out.println("How many people are invited to the party?");
        
        // reads in the number of invited people.
        people = party.nextInt(); 

        System.out.println("How many pizzas will you order?");
        
        // reads in the number of pizzas to be ordered.
        pizzas = party.nextInt(); 
        
        // total slices assuming each pizza has 8 slices. 
        slices = pizzas * 8;
   
        // printing and calculating the number of people, pizzas, 
        // slices and left overs. 
        System.out.println("There are " + people + " people in this party");
        
        System.out.println("You ordered " + pizzas + " pizza(s)");
        
        System.out.println("That means everyone will get " + (slices/people)
         + " slice(s) of pizza");
        
        System.out.println("With " + (slices-((slices/people)*people)) 
        + " slice(s) leftover");
    }
    public static void main(String[] args) 
    {   
        int usernum;
        int add = 0;
        Scanner number = new Scanner(System.in);
       
        // just to not deal with big numbers
        do
        {
           System.out.println("Please enter a number less than 10");
           usernum = number.nextInt();
        } while(usernum > 10 || usernum < -10);
       
       // prints the numbers up to the number entered and their square.
       // does not deal with negative numbers or 0, might fix later.
       for(int i = 1; i <= usernum; i++)
       {
           add += i;
           System.out.println(i + " square = " + i*i);
       }
       
        // checks if the number entered is even
        if (usernum % 2 == 0 && usernum != 0)
        {
            System.out.println(usernum + " is an even number");
        }

        // checks if the number entered is odd
        else if(usernum % 2 != 0)
        {
            System.out.println(usernum + " is an odd number");
        }

        // if not even or odd, then it's a 0
        else
        {
            System.out.println(usernum + " is a zero");
        }
       
       // checks if the number is negative
        if(usernum < 0)
        {
            System.out.println(usernum + " is a negative number");
        }

        // if not negative then positive
        else
        {
           System.out.println(usernum + " is a positive number");
        }
       
       // prints the sum of the numbers up to the number entered.
        System.out.println("The sum of numbers up to " + usernum +
         " is = " + add);

        // Function calls
        askUsername();
        pizzaSlices();
    }
}