package com.exercise.prep;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<T> implements Stack<T>{

  List<T> elems;

  public ArrayStack() {
    this.elems = new ArrayList<>();
  }

  @Override
  public T peek() {
    return elems.get(this.elems.size() - 1);
  }

  @Override
  public T pop() {
    int index = this.elems.size() - 1;

    T elem = this.elems.get(index);
    this.elems.remove(index);

    return elem;
  }

  @Override
  public void push(T value) {
    this.elems.add(value);
  }

  @Override
  public boolean isEmpty() {
    return elems.isEmpty();
  }
}
