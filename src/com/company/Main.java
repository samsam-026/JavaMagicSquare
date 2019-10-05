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
}
