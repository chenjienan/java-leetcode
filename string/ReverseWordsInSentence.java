package string;

public class ReverseWordsInSentence {

    public String reverseWords(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] charArray = input.toCharArray();

        // reverse the whole string
        reverse(charArray, 0, input.length() - 1);

        int left = 0;
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == ' ') {
                reverse(charArray, left, i-1);
                left = i+1;
            }
        }

        reverse(charArray, left, charArray.length - 1);

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
        String s = "an apple";

        ReverseWordsInSentence solution = new ReverseWordsInSentence();
        System.out.println(solution.reverseWords(s));
    }
}
  