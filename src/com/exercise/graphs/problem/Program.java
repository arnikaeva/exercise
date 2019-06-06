package com.exercise.graphs.problem;

import com.exercise.graphs.BinaryNode;
import com.exercise.graphs.BinaryTree;

import java.util.List;

public class Program {
  public static void main(String[] args) {
    int[] values = {5,2,10,1,7};//,3,11,4};
    BinaryTree binaryTree = new BinaryTree(values);

    //BinaryNode nodeA = binaryTree.find(1);
    //BinaryNode nodeB = binaryTree.find(4);

    //FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor();
    //BinaryNode node = firstCommonAncestor.find(nodeA, nodeB);

    //System.out.println(node.getValue());


    BstSequences bstSequences = new BstSequences();

    List<List<Integer>> allSequences = bstSequences.getAllSequences(binaryTree);

    allSequences.forEach(list -> {
      list.forEach(elem -> {
        System.out.print(elem + "-");
      });
      System.out.println();
    });

  }

}
