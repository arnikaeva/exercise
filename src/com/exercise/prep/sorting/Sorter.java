package com.exercise.prep.sorting;

import java.util.List;

public interface Sorter<T extends Comparable> {

  List<T> sort(List<T> items);

}
