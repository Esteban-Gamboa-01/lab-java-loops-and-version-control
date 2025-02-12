package com.ironhack.w1.d2exercises;

import java.util.Arrays;

public class Main {
    public static void main (String [] args){

        int[] matrix01 = {1,5,2,8,10,3};
        int[] matrix02 = {1,-1,-2,8,10,3};
        int[] matrix03 = {};
        int[] matrix04 = {6};
        int[] matrix05 = {1,1,2,8,10,3};

        //Exercise01
        System.out.println(difference(matrix01));
        System.out.println(difference(matrix02));
        System.out.println(difference(matrix03));
        System.out.println(difference(matrix04));

        //Exercise02
        twoSmallest(matrix01);
        twoSmallest(matrix02);
        twoSmallest(matrix04);
        twoSmallest(matrix05);

        //Exercise03
        System.out.println(ecuation(0,1));
        System.out.println(ecuation(2,5));

    }

    /*
    Write a Java method that returns the difference
    between the largest and smallest values in an array
    of integers. The length of the array must be at least 1
    */

    public static int difference (int[] matrix){

        if(matrix.length < 1) {
            System.err.println("Error");
            //When we will learn exceptions, the exercise will seem better.
            return 0;
        }

        int object01 = matrix[0]; //object01 is the largest number
        int object02 = matrix[0]; //object02 is the smallest number
        int dif = 0;

        for (int num : matrix){

            if(num > object01) object01 = num;
            if(num < object02) object02 = num;
        }

        return dif = object01 - object02;
    }

    /*
    Write a Java method that finds the smallest and second-smallest
    elements of a given array and prints them to the console
    */

    public static void twoSmallest (int[] matrix) {
        //Without using the method sortç

        int[] matrix2x1 = new int[2];
        //The first number is the smallest and the second number is the second-smallest number

        switch (matrix.length) {
            case 0 -> {
                System.err.println("Error, the array must have 2 elements");
                System.out.println(Arrays.toString(matrix2x1));
            }
            case 1 -> {
                System.err.println("Error, the array must have 2 elements");
                matrix2x1[0] = matrix[0];
                System.out.println(Arrays.toString(matrix2x1));
            }
            default -> {
                matrix2x1[0] = matrix[1];
                matrix2x1[1] = matrix[0];
                int j = 1;

                /*
                If there are two elements with the same values and they are
                the smallest the counter j ensure that you can select both
                */

                /*
                The first loop starts in the second position [i]. We look for the
                smallest element between the second and the last element.

                The second loop looks for the second-smallest number between the
                first and the last position, but counter j blocks the position of
                smallest element.
                */

                for (int i = 1; i < matrix.length-1; i++){
                    if(matrix[i] < matrix2x1[0]) {
                        matrix2x1[0] = matrix[i];
                        j = i;
                    }
                }

                for (int i = 0; i < matrix.length-1; i++){
                    if(matrix[i] < matrix2x1[1] && i!=j ) {
                        matrix2x1[1] = matrix[i];
                    }
                }

                //If the order is incorrect, change it.
                if(matrix2x1[0]>matrix2x1[1]){
                    j=matrix2x1[0];
                    matrix2x1[0]=matrix2x1[1];
                    matrix2x1[1]=j;
                }

                System.out.println(Arrays.toString(matrix2x1));
            }
        }
    }

    /*
    Write a Java method that calculates the result of the following mathematical
    expression, where x and y are two variables that have been pre-set in your code
    */

    public static double ecuation (double x, double y){
        return Math.pow(x,2.0) + Math.pow(4.0/5.0 * y - x, 2.0);
    }

}
