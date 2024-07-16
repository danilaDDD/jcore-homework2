package ru.gb.examples;

//1)Написать метод, возвращающий количество чётных элементов массива. countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
//2)Написать функцию, возвращающую разницу между самым большим и самым ма- леньким элементами переданного не пустого массива.
//3)Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 9, 1, 4, 1, 2, 0, 0, 9};
        System.out.println("events count: " + countEvents(array));
        System.out.println("different between max and min: " + maxMinDifferent(array));
        System.out.println("existing 2 neighboring zero items: " + neighboringZeroExist(array));
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