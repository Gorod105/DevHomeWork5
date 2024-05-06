package org.example;

import java.util.ArrayList;
import java.util.List;

public class FibonachiNums {
    public static List<Long> fibonacciSubResults = new ArrayList<>();

    static {
        fibonacciSubResults.add(0L);
        fibonacciSubResults.add(1L);
    }
    public static void main(String[] args) {
//        System.out.println(getFibonachiNumIterative(95));
//        System.out.println(getFibonacciNumsRecursive(40));
//        System.out.println(getFibonacciNumsDynamicPrograming(9));
    }

    // Ефективність по часу O(n) по памяті O(1)
    public static Long getFibonachiNumIterative(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        Long result = 0L;
        Long prev = 0L;
        Long curr = 1L;
        for (int i = 2; i < n ; i++) {
            result = prev + curr;
            prev = curr;
            curr = result;
        }
        if (n == 2){
            return curr;
        }

    return result;
    }
    // Ефективність по часу O(n^2) по памяті O(1)
    public static Long getFibonacciNumsRecursive(int n){
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 0L;
        }else if (n == 2) {
            return 1L;
        }
        Long numsPrev = getFibonacciNumsRecursive(n - 2);
        Long numsNext = getFibonacciNumsRecursive(n - 1);
        return numsPrev + numsNext;

    }
    // Ефективність по часу O(n) або O(1) по памяті O(n)
    public static Long getFibonacciNumsDynamicPrograming(int n){
        if (fibonacciSubResults.size() >= n ) {
            return fibonacciSubResults.get(n -1);
        }
        while (fibonacciSubResults.size() <= n) {
            Long lastFibnacciResult = fibonacciSubResults.getLast();
            Long prevFibnacciResult = fibonacciSubResults.get(fibonacciSubResults.size() - 2);
            fibonacciSubResults.add(lastFibnacciResult + prevFibnacciResult);
        }
        return fibonacciSubResults.get(n - 1);

    }
}