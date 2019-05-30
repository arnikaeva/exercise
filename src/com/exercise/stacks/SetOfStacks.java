package com.exercise.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks<T> {
  private List<Stack<T>> stacks;
  private int currentStackIndex;
  private int stackCapacity;

  public SetOfStacks(int stackCapacity) {
    this.stackCapacity = stackCapacity;
    this.currentStackIndex = 0;
    this.stacks = new ArrayList<>();
    this.stacks.add(new Stack<T>());
  }

  public T pop() {
    Stack<T> currentStack = this.stacks.get(this.currentStackIndex);

    while (currentStack.isEmpty() && this.currentStackIndex > 0) {
      this.currentStackIndex --;
      currentStack = this.stacks.get(this.currentStackIndex);
    }

    T result = currentStack.pop();

    if (currentStack.size() == 0 && this.currentStackIndex != 0) {
      this.currentStackIndex --;
    }

    return result;
  }

  public void push(T elem) {
    Stack<T> currentStack = this.stacks.get(currentStackIndex);

    currentStack.push(elem);

    if (currentStack.size() == stackCapacity) {
      this.currentStackIndex ++;
      this.stacks.add(new Stack<>());
    }
  }

  public T popAt(int stackIndex) {
    Stack<T> stackAtIndex = this.stacks.get(stackIndex);
    if (stackAtIndex != null && !stackAtIndex.isEmpty()) {
      return stackAtIndex.pop();
    } else {
      throw new RuntimeException();
    }
  }

  public static void main(String[] args) {
    SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);

    setOfStacks.push(1);
    setOfStacks.push(4);
    setOfStacks.push(3);
    setOfStacks.push(2);
    setOfStacks.push(1);
    setOfStacks.push(5);

    setOfStacks.popAt(0);
    setOfStacks.popAt(0);

    setOfStacks.pop();
    setOfStacks.pop();
    setOfStacks.pop();
    setOfStacks.pop();

    setOfStacks.push(3);

  }
}
