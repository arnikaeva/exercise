package com.exercise.arrays;

public class PalindromePermutation {

  public static void main(String[] args) {
    System.out.println(isPalindromePermutation("rkoteerk"));
    System.out.println(isPalindromePermutation("goddo"));
    System.out.println(isPalindromePermutation("gfhugfyy"));
    System.out.println(isPalindromePermutation(""));
    System.out.println(isPalindromePermutation("a"));
  }

  public static boolean isPalindromePermutation(String s) {
    if (s == null) {
      throw new RuntimeException();
    }

    if (s.length() < 2) {
      return true;
    }

    int expectedWithoutPair = s.length() % 2;
    int actualWithoutPair = 0;

    boolean[] characterChecker = new boolean[128];
    for (int i = 0; i < s.length(); i++) {
      characterChecker[s.charAt(i)] =  !characterChecker[s.charAt(i)];
    }

    for(int i = 0; i < 128; i++) {
      if (characterChecker[i]) {
        actualWithoutPair++;
      }
    }

    return expectedWithoutPair == actualWithoutPair;
  }
}
