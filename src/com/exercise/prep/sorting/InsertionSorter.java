package com.exercise.prep.sorting;

import java.util.ArrayList;
import java.util.List;

public class InsertionSorter<T extends Comparable> implements Sorter<T> {
  @Override
  public List<T> sort(List<T> items) {
    List<T> sorted = new ArrayList<>();
    for(int i = 0; i < items.size(); i++) {
      if (i == 0) {
        sorted.add(items.get(i));
      } else {
        int properIndex = findProperIndex(items.get(i), sorted);
        sorted.add(properIndex, items.get(i));
      }
    }

    return sorted;
  }

  private boolean isLessThan(T first, T second) {
    return first.compareTo(second) < 0;
  }

  private int findProperIndex(T item, List<T> sortedList) {
    int properIndex = sortedList.size();
    boolean found = false;
    while (!found && properIndex != 0) {
      if (isLessThan(sortedList.get(properIndex - 1), item)) {
        found = true;
      } else {
        properIndex --;
      }
    }

    return properIndex;
  }
}
