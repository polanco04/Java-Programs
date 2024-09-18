// Carlos Polanco
// This program is meant to simulate the Texas Lottery. The user enters 6 
// numbers between 1 and 54 (inclusive) and see if it matches with the
// 6 randomly generated numbers. Numbers cannot be outside the range
// and must be unique, meaning no repeated numbers.

// I wrote this program in VSCode. I did not have to make my class
// public in order to write it. I guess I have a different version of 
// java or a different java extension.

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;

class TXLottery
{
    public static void printHeading()
    {
        System.out.println("Carlos Polanco");
        System.out.print("""
                         This program is meant to simulate the Texas Lottery. The user enters 6 
                         numbers between 1 and 54 (inclusive) and see if it matches with the 
                         6 randomly generated numbers. Numbers cannot be outside the range and 
                         must be unique, meaning no repeated numbers. \n\n""");
    }
  
    public static void randNum(int[] lot)
    {
      Random lotNum = new Random();
      
      // creating a set to store the numbers before storing them in an array.
      // this is to make sure that the numbers being added are unique.
      // add() does not let any duplicates into the set.
      LinkedHashSet<Integer> randNums = new LinkedHashSet<>();

      while(randNums.size() < lot.length)
      {
        int rNum = lotNum.nextInt(1,55);
        randNums.add(rNum);
      }  
      
      Integer randArr[] = randNums.toArray(new Integer[lot.length]);
     
     // copying this way due to randArr being considered an array of objects.
     // could probably use casting as well. 
     for(int i = 0; i < lot.length; i++)
      {
        lot[i] = randArr[i];
      }
      
    }

    public static void playerNums(int[] plot)
    {
       int numbers;
       Scanner nums = new Scanner(System.in);

       // using a set again since it includes the contains() method
       // which checks if a number that was entered is in the list/set.
       LinkedHashSet<Integer> userNums = new LinkedHashSet<>();
       
       System.out.println("Welcome to the Texas Lottery!");
       
       // while loop to ask the user for their numbers until the size
       // of the set gets to 6 (length of the lottery digits array)
       while(userNums.size() < plot.length) 
       {
         System.out.println("Please enter a number between 1 and 54: ");
         numbers = nums.nextInt();
        
        // if the number is already in the set, ask the user again.
        if(userNums.contains(numbers))
        {
          while(numbers < 1 || numbers > 54 || userNums.contains(numbers))
          {
            System.out.println("Please try again. Your number must be unique and in range.");
            numbers = nums.nextInt();
          }
          userNums.add(numbers);
        }
        
        // if the number is out of range, ask the user again.
        else if(numbers < 1 || numbers > 54)
        {
          System.out.println("Please try again. Your number must be between 1 and 54.");
        }

        // if the number is valid, add it to the set.
        else
        {
          userNums.add(numbers);
        }
       }
      
      Integer userArr[] = userNums.toArray(new Integer[plot.length]);
      
      // Same as the for loop in the random array.
      // cant use copyOf or arraycopy due to userArr being an array of objects.
      // could use casting instead and then use copyOf or arraycopy.
      for(int i = 0; i < plot.length; i++)
      {
        plot[i] = userArr[i];
      }
    }

    public static int matchingNums(int[] lot, int[] plot)
    {
       int matching = 0;

       // goes through and checks if there are any matching numbers.
       for(int i = 0; i < plot.length; i++)
       {
          if(lot[i] == plot[i])
          {
            matching++;
          }
       }
       return matching;
    }

    public static void printArrays(int[] arr)
    {
      // loop to print the array.
      for(int i = 0; i < arr.length; i++)
      {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
    public static void main(String [] args)
    {
      // arrays.
      int userNums[] = new int[6];
      int lotteryNums[] = new int[6];

      //function/method calls. 
      printHeading();
      randNum(lotteryNums);
      playerNums(userNums);
      System.out.println("You matched: " + matchingNums(lotteryNums, userNums) + " numbers.");
      printArrays(userNums);
      printArrays(lotteryNums);
    }
}