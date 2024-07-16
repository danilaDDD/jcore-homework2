package ru.gb.examples;

// counting sort
//1)Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
//2)Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.
//3)Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 9, 1, 4, 1, 2, 0, 0, 9};
        System.out.println("sorted array: " + Arrays.toString(countingSort(array)));
        System.out.println("events count: " + countEvents(array));
        System.out.println("different between max and min: " + maxMinDifferent(array));
        System.out.println("existing 2 neighboring zero items: " + neighboringZeroExist(array));
    }

    private static int[] countingSort(int[] array){
        if(array.length <= 1)
            return Arrays.copyOf(array, array.length);

        int min = array[0], max = array[0];
        for (int e: array) {
            if(e < min)
                min = e;
            if(e > max)
                max = e;
        }

        // calc counters
        int uniqueNumbers = max + 1 - min;
        int[] countersArray = new int[uniqueNumbers];
        for(int e: array){
            int counterIndex = e - min;
            countersArray[counterIndex] += 1;
        }

        int[] sortedArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < countersArray.length; i++) {
            int number = min + i;
            int counter = countersArray[number];
            for (int j = 0; j < counter; j++) {
                sortedArray[index ++] = number;
            }
        }


        return sortedArray;
    }

    private static boolean neighboringZeroExist(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {                    
            if(array[i] == 0 && array[i + 1] == 0)
                return true;

        }
        return false;
    }

    private static int maxMinDifferent(int[] array) {
        int min = array[0], max = array[0];
        for(int number: array){
            if(number < min)
                min = number;

            if(number > max)
                max = number;
        }

        return max - min;
    }

    private static int countEvents(int[] array) {
        int count = 0;
        for(int number: array)
            if(number % 2 == 0)
                count++;

        return count;
    }
}