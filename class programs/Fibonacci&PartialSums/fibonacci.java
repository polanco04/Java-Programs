// Carlos Polanco
// In class program using arrays. Fibonacci and Partial Sums.  

import java.util.Scanner;
import java.util.Arrays;

class PartialFibonacci {
   
    public static void printArray(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
   
    public static void fibonacci()
    {
        int fSize = 0;
        Scanner nums = new Scanner(System.in);
       
        System.out.println("Enter a Number greater than 2: ");
        fSize = nums.nextInt();
           
        while(fSize < 2)
        {
            System.out.println("Your number must be greater than 2. Try again:  ");
            fSize = nums.nextInt();
        }    
       
        System.out.println();
       
        int fibArr[] = new int[fSize];
        fibArr[0] = 0;
        fibArr[1] = 1;
       
        for(int i = 2; i < fibArr.length; i++)
        {
            fibArr[i] = fibArr[i-2] + fibArr[i-1];
        }
         printArray(fibArr);
         System.out.println();
    }
   
    public static void modArray(int  arr[])
    {
        for(int i = 1; i < arr.length; i++)
        {
            arr[i] = arr[i] + arr[i-1];
        }
    }
   
    public static void main(String[] args) {
       
        int fSize = 0;
        int arr[] = new int [5];
        Scanner nums = new Scanner(System.in);
       
        fibonacci();

        for(int i = 0; i < arr.length; i++)
        {
            System.out.println("Enter a Number between 1 and 10: ");
            arr[i] = nums.nextInt();
            while(arr[i] < 1 || arr[i] > 10)
            {
                System.out.println("Your number must be between 1 and 10. Try again:  ");
                arr[i] = nums.nextInt();
            }
        }
       
        System.out.println();
       
        int cArr[] = Arrays.copyOf(arr, arr.length);
       
        modArray(cArr);
        printArray(arr);
        printArray(cArr);
       
    }
}
