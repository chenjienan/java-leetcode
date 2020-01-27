package bit;

public class PowerOfTwo {
  public boolean isPowerOfTwo(int input) {
    if (input <= 0) {
      return false;
    }
    
    return (input - 1 & input) == 0;
  }

  public static void main(String[] args) {
    PowerOfTwo sol = new PowerOfTwo();
    System.out.println(sol.isPowerOfTwo(5));
  }
}
