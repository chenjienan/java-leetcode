package psr;

public class Random7UsingRandom5 {
  public int random7() {
    // write your solution here
    // you can use RandomFive.random5() for generating
    // 0 - 4 with equal probability.

    while(true) {
      int r = RandomFive.random5() * 5 + RandomFive.random5();
      // 1/25 each time
      // ignore r = 22 to 25
      if (r < 21) {
        return r % 7;
      }
    }
  }
}
