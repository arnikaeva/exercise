package com.exercise.prep.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<T extends Comparable> implements Sorter<T> {

  @Override
  public List<T> sort(List<T> items) {
    if (items.size() == 1) {
      return items;
    }

    List<T> left = items.subList(0, items.size() / 2);
    List<T> right = items.subList(items.size() / 2, items.size());

    return merge(
        sort(left),
        sort(right)
    );
  }

  private List<T> merge(List<T> left, List<T> right) {
    List<T> mergedList = new ArrayList<>(left.size() + right.size());
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex < left.size() || rightIndex < right.size()) {
      T nextLeft = getNextElem(leftIndex, left);
      T nextRight = getNextElem(rightIndex, right);

      if (leftIndex == left.size()) {
        mergedList.add(nextRight);
        rightIndex++;
      } else if (rightIndex == right.size()) {
        mergedList.add(nextLeft);
        leftIndex++;
      } else if (isLessThan(nextRight, nextLeft)) {
        mergedList.add(nextRight);
        rightIndex++;
      } else {
        mergedList.add(nextLeft);
        leftIndex++;
      }
    }

    return mergedList;
  }

  private T getNextElem(int index, List<T> elems) {
    if (index < elems.size()) {
      return elems.get(index);
    } else {
      return null;
    }
  }

  private boolean isLessThan(T first, T second) {
    return first.compareTo(second) < 0;
  }

}
