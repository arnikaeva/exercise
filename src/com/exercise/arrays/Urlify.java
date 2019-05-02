package com.exercise.arrays;

public class Urlify {

  public static void main(String[] args) {
    System.out.println(urlify("He ll a    ", 7));
  }

  public static String urlify(String raw, int length) {

    if (raw == null || raw.length() < length) {
      throw new RuntimeException();
    }

    if (raw.length() == length) {
      return raw;
    }

    char[] validChars = new char[raw.length()];
    int validIndex = 0;

    for(int i = 0; i < length; i++) {
      if (raw.charAt(i) == ' ') {
        validChars[validIndex++] = '%';
        validChars[validIndex++] = '2';
        validChars[validIndex++] = '0';
      } else {
        validChars[validIndex++] = raw.charAt(i);
      }
    }

    return new String(validChars);
  }
}
