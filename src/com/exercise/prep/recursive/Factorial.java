package com.exercise.prep.recursive;

public class Factorial {

  public static int iterative(int n) {
    int result = 1;

    for (int i = n; i > 0; i--) {
      result *= i;
    }

    return result;
  }

  public static int recursive(int n) {
    if (n == 0 || n == 1) {
      return 1;
    } else {
      return n * recursive(n - 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(recursive(6));
    System.out.println(iterative(6));

  }
}
