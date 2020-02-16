package tools;

public class ArrayPrinter{
  public static <T> void printArray(T[] array) {
    for (T element : array) {
      System.out.printf("%s ", element);
    }
  }

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.printf("%s ", matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }
}