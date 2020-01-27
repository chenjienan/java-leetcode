package bit;


public class HexRepresentation {
  public String hex(int number) {

    String prefix = "0x";

    if (number == 0) {
      return prefix + "0";
    }

    // create the mapping for hex char
    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    
    StringBuilder sb = new StringBuilder(prefix);
    // need to shift the int to get the most significant bits
    boolean isLeading = true;
    for (int i = 28; i >= 0; i -= 4) {
      int idx = (number >> i) & 0xF;
      char digit = map[idx];

      if (digit != '0' || !isLeading) {
        sb.append(digit);
        isLeading = false;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    HexRepresentation sol = new HexRepresentation();
    System.out.println(sol.hex(15));
  }
}
