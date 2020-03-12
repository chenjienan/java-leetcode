package bfs;
import java.util.*;


public class SevenPuzzle {
  public int numOfSteps(int[] values) {
    
    Map<Integer, List<Integer>> moves = new HashMap<>();
    moves.put(0, Arrays.asList(1, 4));
    moves.put(1, Arrays.asList(0, 2, 5));
    moves.put(2, Arrays.asList(1, 3, 6));
    moves.put(3, Arrays.asList(2, 7));
    moves.put(4, Arrays.asList(0, 5));
    moves.put(5, Arrays.asList(1, 4, 6));
    moves.put(6, Arrays.asList(2, 5, 7));
    moves.put(7, Arrays.asList(3, 6));

    List<Integer> finalState = Arrays.asList(0,1,2,3,4,5,6,7);
    Queue<List<Integer>> queue = new ArrayDeque<>();
    Set<List<Integer>> boardState = new HashSet<>();

    // init 
    List<Integer> firstState = new ArrayList<>();
    for (int i = 0; i < values.length; i++) {
      firstState.add(values[i]);
    }
    queue.offer(firstState);
    boardState.add(firstState);

    int count = 0;
    while (!queue.isEmpty()) {            

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        // expand
        List<Integer> curState = queue.poll();
        
        // termination condition
        if (curState.equals(finalState)) {
          return count;
        }
        
        // find the idx of 0      
        int zeroPos = curState.indexOf(0);

        // generate
        List<Integer> canMove = moves.get(zeroPos);
        for (int j = 0; j < canMove.size(); j++) {
          List<Integer> newState = new ArrayList<>(curState);
          Collections.swap(newState, zeroPos, canMove.get(j));
          if (!boardState.contains(newState)) {        
            boardState.add(newState);
            queue.offer(newState);
          }
        }
      }      
      count++;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] A = {4,1,2,3,5,0,6,7};
    SevenPuzzle sol = new SevenPuzzle();
    System.out.println(sol.numOfSteps(A));
  }
}
