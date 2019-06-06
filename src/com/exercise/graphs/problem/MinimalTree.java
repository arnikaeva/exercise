package com.exercise.graphs.problem;

import com.exercise.graphs.BinaryNode;
import com.exercise.graphs.BinaryTree;
import com.exercise.graphs.Node;

public class MinimalTree {

  public static int getMinHeight(int n) {
    int exponent = 0;
    int sum = 1;
    while (sum < n + 1) {
      sum = sum * 2;
      exponent ++;
    }

    return exponent;
  }

  public static BinaryTree createFromArray(int[] elems) {
    int minHeight = getMinHeight(elems.length);
    return null;

  }

  public BinaryNode traverse(int currentIndex, int[] elems, int currentLevel, int levels) {
    if (levels == currentLevel) {
      return new BinaryNode(elems[currentIndex]);
    } else {
      BinaryNode left = traverse(currentIndex, elems, currentLevel + 1, levels);
      currentIndex ++;
      BinaryNode node = new BinaryNode(elems[currentIndex]);
      currentIndex++;
      BinaryNode right = traverse(currentIndex, elems, currentLevel, levels);

      return node;
    }

  }

  public static void main(String[] args) {

  }
}
