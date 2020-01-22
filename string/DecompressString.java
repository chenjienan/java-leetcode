package string;

public class DecompressString {
    
    public String decompress(String input) {

        if (input.isEmpty()) {
            return input;
        }

        // get new length
        int newLen = 0;        
        for (int i = 0; i < input.length(); ++i) {
            if (Character.isDigit(input.charAt(i))) {
                newLen += input.charAt(i) - '0';
            }
        }

        char[] newArray = new char[newLen];

        // copy to new array
        int slow = 0;
        int fastChar = 0, fastDigit = 1;

        while (fastDigit < input.length()) {
            char curChar = input.charAt(fastChar);
            int curDigit = input.charAt(fastDigit) - '0';
            if (curDigit != 0) {
                for (int j = 0; j < curDigit; ++j) {
                    newArray[slow++] = curChar;
                }
            }
            fastChar += 2;
            fastDigit += 2;
        }

        return new String(newArray);
    }

    public static void main(String[] args) {
        String s = "x2y0i0z3";
        DecompressString sol = new DecompressString();
        System.out.println(sol.decompress(s));
    }
}
  