package com.exercise.prep.recursive;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class Fibonacci {

  static Map<Integer, Integer> cache = new HashMap<>();

  public static int iterative(int n) {
    int[] numbers = new int[n + 1];

    for (int i = 0; i <= n; i ++) {
      if (i == 0 || i == 1) {
        numbers[i] = i;
      } else {
        numbers[i] = numbers[i - 1] + numbers[i-2];
      }
    }

    return numbers[n];
  }

  public static int recursive(int n) {
    if (n == 0 || n == 1) {
      return n;
    } else {
      return recursive(n - 1) + recursive(n - 2);
    }
  }

  public static int recursiveWithMemoization(int n) {
    if (cache.containsKey(n)) {
      return cache.get(n);
    }

    if (n == 0 || n == 1) {
      return n;
    } else {
      cache.put(n, recursive(n - 1) + recursive(n - 2));
      return cache.get(n);
    }
  }

  public static void main(String[] args) {
    System.out.println(recursive(12));
    System.out.println(iterative(1));
    System.out.println(recursiveWithMemoization(40));


  }
}
