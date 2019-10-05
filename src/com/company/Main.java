package com.company;

import java.util.Scanner; // importing Scanner class to use it to get user's input

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // input is the variable used to get data from user(System.in)
        String begin = "y"; // assigning begin variable to y to start the while loop below
        /*
         * the do-while loop runs till the user enters n and if they enter something
         * other than y or n, then the program will display an error message and ask
         * the user to re-enter
         */
        do {
            if (begin.equalsIgnoreCase("y")) { //equalsIgnoreCase is used to check if the variable begin has either Y or y
                int size = 0; //size is assigned 0 to initiate the while loop below
                //the while loop is used to ensure that only numbers above 1 will be entered for the size
                while (size <= 1) {
                    System.out.println("Enter the size of the matrix (Eg:5 or any number): ");
                    //this function validateValues is used to ensure that only an integer and no other data type will be entered
                    size = validateValues("Enter the size of the matrix (Eg:5 or any number):");// once the data is validated for the data type, the data is assigned to the size variable
                    //error messages will be displayed if the user enters negative, 0 and 1 for size.
                    if (size <= 0) {
                        System.err.println("Please enter only numbers greater than 1");
                    } else if (size == 1) {
                        System.err.println("Please enter only numbers above 1");
                    }
                }
                int[][] numbers = getValues(size); // this function is called to make the user enter the number of elements required according to the size entered
                displaySquare(numbers, size); // then the numbers 2d array is passed with size to display the square
                boolean magicSquare = isMagicSquare(numbers, size);

                isLoShu(numbers, magicSquare, size);// calling the lo shu function to check if the square is lo shu or not


            } else {
                System.out.println("The options are only y or n");
            }
            //user is asked if they want to enter another square
            System.out.println("Do you wish to enter a new square(y/n) ");
            begin = input.next();
            // if the user enters anything other than n or N then the above code will be executed again
        } while (!begin.equalsIgnoreCase("n"));
        // displays bye once the user enters n or N for begin variable
        System.out.println("Bye!");
    }
    private static int validateValues(String message) {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            //System.err will print the error message in another colour (red)
            System.err.println("Data entered is not integer");
            System.out.println(message);
            //takes input till a space is entered
            input.next();
        }
        return input.nextInt(); //returns only integer type after validation
    }
    private static int[][] getValues(int size) {
        int[][] numbers = new int[size][size]; // saving memory space for the numbers array of integer type
        //the while block is used to check if the number going to be entered is an integer
        int count = -1; // initialising count also it is used as a counter for the loop
        // the loop runs from -1 to size-1 as once it enters the loop count becomes 0
        int counter = 0;
        while (count < size - 1) {
            int count1 = -1;
            count++;
            while (count1 < size - 1) {
                count1++;
                counter++; // counter is used to help the user keep a track at which number he has entered
                String message = "Enter number " + counter;
                System.out.println(message);
                //the while block is used to check if the number going to be entered is an integer
                int number = validateValues(message);// once the data is validated for the data type, the data is assigned to the number variable
                //if block used to check if the number is less than 1 and if so prints an error message and decreases count1 by 1
                if (number < 1) {
                    System.err.println("Please enter only positive numbers");
                    count1--;
                } else {
                    numbers[count][count1] = number;
                }
            }
        }
        return numbers;// returns the numbers array
    }
}
