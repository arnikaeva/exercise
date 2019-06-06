package com.exercise.graphs.problem;

import com.exercise.graphs.BinaryNode;
import com.exercise.graphs.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BstSequences {

  public List<List<Integer>> getAllSequences(BinaryTree tree) {
    return getAllSequences(tree.getRoot());
  }

  private List<List<Integer>> getAllSequences(BinaryNode node) {
    if (node == null) {
      return new ArrayList<>();
    } else {
      return mergeLists(
          node.getValue(),
          getAllSequences(node.getLeft()),
          getAllSequences(node.getRight()));
    }
  }

  private List<List<Integer>> mergeLists(Integer start, List<List<Integer>> left, List<List<Integer>> right) {
    List<List<Integer>> results = new ArrayList<>();

    if (left.isEmpty() && right.isEmpty()) {
      List<Integer> result = new ArrayList<>();
      result.add(start);
      results.add(result);
      return results;

    } else if (left.isEmpty() || right.isEmpty()) {
      List<List<Integer>> values = left.isEmpty() ? right : left;

      values.forEach(list -> {
        List<Integer> result = new ArrayList<>();
        result.add(start);
        result.addAll(list);
        results.add(result);
      });

      return results;
    }

    left.forEach(leftList -> {
      right.forEach(rightList -> {
        LinkedList<Integer> leftCopy = new LinkedList<>();
        leftList.forEach(e -> leftCopy.add(e));

        LinkedList<Integer> rightCopy = new LinkedList<>();
        rightList.forEach(e -> rightCopy.add(e));

        List<Integer> sequence = new ArrayList<>();
        sequence.add(start);

        List<List<Integer>> combinations = mergeValues(sequence, leftCopy, rightCopy);
        results.addAll(combinations);
      });
    });

    return results;
  }

  private List<List<Integer>> mergeValues(List<Integer> sequence, LinkedList<Integer> left, LinkedList<Integer> right) {
    List<List<Integer>> results = new ArrayList<>();

    if (left.isEmpty() || right.isEmpty()) {
      sequence.addAll(left);
      sequence.addAll(right);
      results.add(sequence);
      return results;
    }

    //Combinations using elem from left first
    List<Integer> sequenceCopy = new ArrayList<>(sequence.size());
    LinkedList<Integer> leftCopy = new LinkedList<>();
    LinkedList<Integer> rightCopy = new LinkedList<>();

    left.forEach(e -> leftCopy.add(e));
    right.forEach(e -> rightCopy.add(e));
    sequence.forEach(e -> sequenceCopy.add(e));

    sequenceCopy.add(leftCopy.pollFirst());

    List<List<Integer>> startWithLeft = mergeValues(sequenceCopy, leftCopy, rightCopy);

    //Combinations using elem from right first
    List<Integer> sequenceCopy2 = new ArrayList<>(sequence.size());
    LinkedList<Integer> leftCopy2 = new LinkedList<>();
    LinkedList<Integer> rightCopy2 = new LinkedList<>();

    left.forEach(e -> leftCopy2.add(e));
    right.forEach(e -> rightCopy2.add(e));
    sequence.forEach(e -> sequenceCopy2.add(e));

    sequenceCopy2.add(rightCopy2.pollFirst());
    List<List<Integer>> startWithRight = mergeValues(sequenceCopy2, leftCopy2, rightCopy2);


    results.addAll(startWithLeft);
    results.addAll(startWithRight);

    return results;
  }

}
