package string;

public class RightShiftByNChar {

    public String rightShift(String input, int n) {
        if (input.isEmpty() || input.length() == 1 || n == input.length()) {
            return input;
        }

        n = n % input.length();
        char[] charArray = input.toCharArray();
        // reverse whole string
        reverse(charArray, 0, input.length() - 1);
        // reverse first part
        reverse(charArray, 0, n - 1);
        //reverse second part
        reverse(charArray, n, input.length() - 1);

        return new String(charArray);
    }

    private void reverse(char[] charArray, int start, int end) {
        
        int left = start, right = end;
        
        while (left < right) {
            swap(charArray, left, right);
            left++;
            right--;
        }
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "abcde";
        int n = 7;

        RightShiftByNChar sol = new RightShiftByNChar();
        System.out.println(sol.rightShift(s, n));
    }
}
  