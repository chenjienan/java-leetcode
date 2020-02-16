package psr;
import java.util.*;


public class NineFivePercentile {
  public int percentile95(List<Integer> lengths) {
    
    int[] histogram = new int[4096];
    for (Integer len : lengths) {
      histogram[len]++;
    }

    int sum = 0;
    int res = 0;
    for (int i = 0; i < 4096; i++) {
      sum += histogram[i];
      if (sum >= 0.95 * lengths.size()) {
        res = i;
        break;
      }
    }
    return res;
  }
}