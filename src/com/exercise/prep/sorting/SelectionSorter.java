package com.exercise.prep.sorting;

import java.util.Collections;
import java.util.List;

public class SelectionSorter<T extends Comparable> implements Sorter<T> {
  @Override
  public List<T> sort(List<T> items) {
    for (int i = 0; i < items.size(); i++) {
      int minimumIndex = i;
      for (int j = i; j < items.size(); j++) {
        if (items.get(j).compareTo(items.get(minimumIndex)) < 0) {
          minimumIndex = j;
        }
      }

      Collections.swap(items, i, minimumIndex);
    }

    return items;
  }
}
