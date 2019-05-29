package com.exercise.prep.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable> implements Sorter<T> {

  @Override
  public List<T> sort(List<T> items) {
    int untilIndex = items.size() - 1;
    for (int i = 0; i < untilIndex; i++) {
      for (int j = 0; j < untilIndex - i; j++) {
        T first = items.get(j);
        T second = items.get(j + 1);
        if (first.compareTo(second) > 0) {
          Collections.swap(items, j, j+1);
        }
      }
    }
    return items;
  }

  public static void main(String[] args) {
    Sorter<Integer> sorter = new MergeSorter<>();
    List<Integer> sorted = sorter.sort(Arrays.asList(67, 1, 8, 2, 3, 2, 31, 42, 4, 42, 4));

    for(Integer i : sorted) {
      System.out.println(i);
    }

  }
}
