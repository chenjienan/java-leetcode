package array;
import java.util.*;

class Point {
  public int x;
  public int y;
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class MostPointOnALine {
  public int most(Point[] points) {

    int res = 0;
    
    for (Point p1 : points) {
      
      int same = 1;     // self inclusive
      int sameX = 0;    // on a vertical line
      int localMax = 0;

      // key: slope value: count
      Map<Double, Integer> counter = new HashMap<>();
      for (Point p2 : points) {
        if (p1.equals(p2)) {    // skip same point
          continue;
        }
        if (p2.x == p1.x && p2.y == p1.y) {
          same++;
        }else if (p2.x == p1.x) {
          sameX++;
        }else {
          double slope = (p2.y - p1.y + 0.0) / (p2.x - p1.x);
          
          Integer count = counter.get(slope);
          count = count == null ? 1 : count + 1;
          counter.put(slope, count);

          localMax = Math.max(localMax, count);
        }
      }
      localMax = Math.max(localMax, sameX) + same;
      res = Math.max(res, localMax);
    }
    return res;
  }

  public static void main(String[] args) {
    
    Point[] A = {new Point(1, 1), new Point(3, 5), new Point(1, 2), new Point(2, 3), new Point(0, 1), new Point(1, 1), new Point(5, 9), new Point(9, 10)};
    MostPointOnALine sol = new MostPointOnALine();
    System.out.println(sol.most(A));
  }
}