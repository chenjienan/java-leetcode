package psr;
import java.util.*;

public class GeneralizedReservoirSampling {
  private final int k;
  private int counter;
  private List<Integer> sampling;
  private Random rand;
  
  public GeneralizedReservoirSampling(int k) {
    this.k = k;
    counter = 0;
    sampling = new ArrayList<>();
    rand = new Random();
  }
  
  public void read(int value) {
    counter++;
    if (sampling.size() < k) {
      sampling.add(value);
    } else {
      
      int r = rand.nextInt(counter);
      if (r < k) {
        sampling.set(r, value);   // replace one from the sampling
      }
    }
  }
  
  public List<Integer> sample() {
    return sampling;
  }
}
