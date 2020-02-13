package dfs;

import java.util.*;

public class WordSearch {
  public boolean isWord(final char[][] board, final String word) {
    
    final boolean[] res = new boolean[1];

    int rows = board.length;
    int cols = board[0].length;
    Set<Cell> visited = new HashSet<>();
    char[] charArr = word.toCharArray();

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        Cell cell = new Cell(r, c);
        if (!res[0] && !visited.contains(cell)) {
          DFS(board, charArr, 0, cell, visited, res);
        }
      }
    }
    return res[0];
  }

  static class Cell{
    int row;
    int col;

    public Cell(int r, int c) {
      row = r;
      col = c;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof Cell)) {
        return false;
      }
      Cell cell = (Cell) obj;
      return cell.row == this.row && cell.col == this.col;
    }

    @Override
    public int hashCode() {
      return row * 31 * col;
    }
  }

  private void DFS(char[][] board, char[] charArr, int index, Cell curCell, Set<Cell> visited, boolean[] res) {
    if (res[0]) {
      return;   // found the word in board
    } 

    if (curCell.row < 0 
      || curCell.row >= board.length 
      || curCell.col < 0 
      || curCell.col >= board[0].length
      || visited.contains(curCell)){   // check boundary && isVisisted
        return;
    }  

    if (board[curCell.row][curCell.col] != charArr[index]) {
      return;   // not match
    }

    if (index == charArr.length - 1) {
      res[0] = true;
      return;
    }

    visited.add(curCell);
    DFS(board, charArr, index + 1, new Cell(curCell.row - 1, curCell.col), visited, res);
    DFS(board, charArr, index + 1, new Cell(curCell.row, curCell.col + 1), visited, res);
    DFS(board, charArr, index + 1, new Cell(curCell.row + 1, curCell.col), visited, res);
    DFS(board, charArr, index + 1, new Cell(curCell.row, curCell.col - 1), visited, res);
  }

  public static void main(String[] args) {
    char[][] m = {
      {'A', 'B', 'C', 'E'},
      {'S', 'F', 'C', 'S'},
      {'A', 'D', 'E', 'E'}
    };

    WordSearch sol = new WordSearch();
    System.out.println(sol.isWord(m, "ABCB"));
  }
}
