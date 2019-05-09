package com.exercise.arrays;

public class RotateMatrix {
  public static void main(String[] args) {

    int[][] matrix = {
        {1,2,3,4},
        {3,2,4,5},
        {9,0,3,2},
        {2,3,6,4}
    };

    int[][] newMatrix = rotate(matrix);

    for (int i = 0; i < newMatrix.length; i++) {
      for (int j = 0; j < newMatrix.length; j++) {
        System.out.print(newMatrix[i][j]);
      }
      System.out.println();
    }
  }

  public static int[][] rotate(int[][] matrix) {
    int[][] newMatrix = new int[matrix.length][matrix.length];

    for (int col = 0, newRow = 0; col < matrix.length; col ++, newRow ++) {
      for (int row = matrix.length - 1, newCol = 0; row >= 0; row --, newCol ++) {
        newMatrix[newRow][newCol] = matrix[row][col];
      }
    }

    return newMatrix;

  }
}
