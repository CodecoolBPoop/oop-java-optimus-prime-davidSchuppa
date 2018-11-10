package com.codecool;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static LinkedList<Integer> numbers = new LinkedList<>();
    public static ArrayList<Integer> primes = new ArrayList<>();

    public static void makeNumbersList(int range) throws IllegalArgumentException {
        if (range < 0) throw new IllegalArgumentException("Range must be a positive integer");
        else {
            for (int i = 2; i <= range; i++) {
                numbers.add(i);
            }
        }
    }

    public static int numberOfPrimes(int range){
        try {
            makeNumbersList(range);
            for (int i = 2; i <= range; i++) {
                int multiple = i * 2;

                while (multiple <= range) {
                    if (numbers.indexOf(multiple) != -1) {
                        numbers.remove(numbers.indexOf(multiple));
                    }
                    multiple += i;
                }
                if (numbers.indexOf(i) != -1) primes.add(i);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return primes.size();
    }

    public static void main(String[] args) {
        int test = numberOfPrimes(120);
        System.out.println(test);
    }
}
