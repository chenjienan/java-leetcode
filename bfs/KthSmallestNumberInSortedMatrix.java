package bfs;
import java.util.*;

public class KthSmallestNumberInSortedMatrix {
    
    static class Cell {
        int row;
        int column;
        int value;
    
        Cell(int r, int c, int val) {
            row = r;
            column = c;
            value = val;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        Queue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[rows][cols];
        
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;

        for (int i = 0; i < k - 1; ++i) {
            Cell curCell = minHeap.poll();
            int curRow = curCell.row;
            int curCol = curCell.column;
            int nxtRow = curRow + 1;
            int nxtCol = curCol + 1;
            
            // check [nxtRow][curCol]
            if (nxtRow < rows && !visited[nxtRow][curCol]) {
                minHeap.offer(new Cell(nxtRow, curCol, matrix[nxtRow][curCol]));
                visited[nxtRow][curCol] = true;
            }

            // check [curRow][nxtCol]
            if (nxtCol < cols && !visited[curRow][nxtCol]) {
                minHeap.offer(new Cell(curRow, nxtCol, matrix[curRow][nxtCol]));
                visited[curRow][nxtCol] = true;
            }
        }

        return minHeap.peek().value;
    }

    public static void main(String[] args)
	{
		int[][] matrix = new int[][] {
            {1,2,3,4},
            {11,12,13,14},
            {15,16,17,18},
            {19,20,21,22}
        };

        System.out.println(kthSmallest(matrix, 4));
	}
}





