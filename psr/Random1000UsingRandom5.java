package psr;

public class Random1000UsingRandom5 {
  public int random1000() {
    // Write your solution here.
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.
    while(true) {
      int r = RandomFive.random5();
      for (int i = 0; i < 5; i++) {
        r +=  r * 5 + RandomFive.random5();
      }
      // 3125 ignoring from 3001 to 3125 inclusive
      if (r < 3000) {
        return r % 1000;
      }
    }
  }
}

class RandomFive {

  public static int random5(){
    return 0;
  }
}
