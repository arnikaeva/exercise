package com.exercise.prep;

import java.util.HashSet;
import java.util.Set;

public class ArraySumChecker {

  public static void main(String[] args) {
    int[] arrayFalse = {1,2,3,4};
    int[] arrayTrue = {3,4,2,8};
    int sum = 10;

    System.out.println(bruteForceChecker(arrayFalse, sum));
    System.out.println(bruteForceChecker(arrayTrue, sum));

    System.out.println(optimalChecker(arrayFalse, sum));
    System.out.println(optimalChecker(arrayTrue, sum));

  }

  public static boolean bruteForceChecker(int[] array, int sum) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] + array[j] == sum) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean optimalChecker(int[] array, int sum) {
    Set<Integer> complementValues = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      int value = array[i];
      if (complementValues.contains(value)) {
        return true;
      } else {
        complementValues.add(sum - value);
      }
    }

    return false;
  }
}
