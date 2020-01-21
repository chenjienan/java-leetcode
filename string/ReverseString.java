package string;

public class ReverseString {

    public String reverse(String input) {
        if (input.isEmpty() || input.length() == 1) {
            return input;
        }

        char[] charArray = input.toCharArray();
        int left = 0, right = charArray.length - 1;
        
        while (left < right) {
            swap(charArray, left, right);
            left++;
            right--;
        }

        return new String(charArray);
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    public static void main(String[] args) {
        
    }
}
  