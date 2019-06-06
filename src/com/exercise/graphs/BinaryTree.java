package com.exercise.graphs;

public class BinaryTree {

  BinaryNode root;

  public BinaryTree() {
  }

  public BinaryTree(int[] values) {
    for (Integer value : values) {
      insert(value);
    }
  }

  public BinaryNode getRoot() {
    return root;
  }

  public void insert(int[] values) {
    for (Integer value : values) {
      insert(value);
    }
  }

  public void insert(int value) {
    if (root == null) {
      root = new BinaryNode(value);
    } else {
      BinaryNode parent = root;
      BinaryNode node = value < parent.getValue() ? parent.getLeft() : parent.getRight();
      while (node != null) {
        parent = node;
        node = value < parent.getValue() ? parent.getLeft() : parent.getRight();
      }

      node = new BinaryNode(value);
      node.setParent(parent);
      if (value < parent.getValue()) {
        parent.setLeft(node);
      } else {
        parent.setRight(node);
      }
    }
  }

  public BinaryNode find(int value) {
    BinaryNode result = root;

    while (result != null && result.getValue() != value) {
      result = value < result.getValue() ? result.getLeft() : result.getRight();
    }

    return result;
  }

}
