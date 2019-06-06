package com.exercise.graphs;

public class BinaryNode {

  private int value;
  private BinaryNode parent;
  private BinaryNode left;
  private BinaryNode right;
  private boolean isVisited;

  public BinaryNode(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public BinaryNode getParent() {
    return parent;
  }

  public void setParent(BinaryNode parent) {
    this.parent = parent;
  }

  public BinaryNode getLeft() {
    return left;
  }

  public void setLeft(BinaryNode left) {
    this.left = left;
  }

  public BinaryNode getRight() {
    return right;
  }

  public void setRight(BinaryNode right) {
    this.right = right;
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }
}
