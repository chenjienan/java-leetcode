package bit;

public class ReverseIntegerBits {
  public long reverseBits(long n) {
    int int32 = (int) n;
    
    int i = 0;
    int j = 31;
    while (i < j) {
      int32 = swap(int32, i++, j--);
    }

    return (long) int32;
  }

  private int swap(int int32, int i, int j) {
    // variables are for checking only
    // they are 0 or 1
    int leftBit = int32 >> j & 1;   // find i
    int rightBit = int32 >> i & 1;      // find j

    // ensure leftBit and rightBit cannot be
    // 0 or 1 at the same time
    if (leftBit != rightBit) {
      int32 ^= ((1 << i) | (1 << j));
    }
    return int32;
  } 

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(343));
  }
}
