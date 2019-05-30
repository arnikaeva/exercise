package com.exercise.stacks;

import java.util.Stack;

public class SortStack {

  public Stack<Integer> sort(Stack<Integer> originalStack) {
    Stack<Integer> sortedStack = new Stack<>();

    while (!originalStack.isEmpty()) {
      if (sortedStack.isEmpty()) {
        sortedStack.push(originalStack.pop());
      } else {
        putNextElemIntoSortedStack(originalStack, sortedStack);
      }
    }

    return sortedStack;
  }

  private void putNextElemIntoSortedStack(Stack<Integer> originalStack, Stack<Integer> sortedStack) {
    Integer nextElem = originalStack.pop();
    int movedElements = 0;
    boolean foundPlace = false;

    while (!foundPlace) {
      if (sortedStack.isEmpty()) {
        sortedStack.push(nextElem);
        foundPlace = true;
      } else if (nextElem < sortedStack.peek()) {
        sortedStack.push(nextElem);
        foundPlace = true;
      } else {
        originalStack.push(sortedStack.pop());
        movedElements ++;
      }
    }

    for(int i = 0; i < movedElements; i ++) {
      sortedStack.push(originalStack.pop());
    }
  }

  public static void main(String[] args) {
    SortStack sortStack = new SortStack();

    Stack<Integer> stack = new Stack<>();
    stack.push(10);
    stack.push(3);
    stack.push(1);
    stack.push(2);
    stack.push(-4);
    stack.push(29);
    stack.push(0);
    stack.push(2);


    Stack<Integer> sorted = sortStack.sort(stack);
  }
}
