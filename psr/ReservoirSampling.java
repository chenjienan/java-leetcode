package psr;

import java.util.*;

public class ReservoirSampling {
  private int counter;
  private Integer sampleItem;
  private Random rand;

  public ReservoirSampling() {
    counter = 0;
    sampleItem = null;
    rand = new Random();
  }
  
  public void read(int value) { 
    counter++;   
    if (rand.nextInt(counter) == 0) {
      sampleItem = value;
    }
  }
  
  public Integer sample() {
    return sampleItem;
  }
}