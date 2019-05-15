package com.exercise.prep.recursive;

public class StringReverse {
  public static String reverse(String s) {
    if (s.length() <= 1) {
      return s;
    } else {
      return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }
  }

  public static String reverseBuilder(String s, StringBuilder sb) {
    if (s.length() == 0) {
      return sb.toString();
    } else {
      sb.append(s.charAt(s.length() - 1));
      return reverseBuilder(s.substring(0, s.length() - 1), sb);
    }
  }

  public static void main(String[] args) {
    System.out.println(reverse("a"));
    System.out.println(reverseBuilder("almafa", new StringBuilder()));
  }
}
