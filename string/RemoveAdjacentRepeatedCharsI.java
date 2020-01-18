package string;

public class RemoveAdjacentRepeatedCharsI {
    public String deDup(String input) {
        if (input == null || input.isEmpty() || input.length() == 1){
            return input;
        }

        char[] charArray = input.toCharArray();

        int slow = 1;
        for (int fast = 1; fast < charArray.length; ++fast) {
            if (charArray[fast] != charArray[slow-1]) {
                charArray[slow++] = charArray[fast];
            }
        }

        return new String(charArray, 0, slow);
    }

    public static void main(String[] args) {
        String s = "aaabbc";
        RemoveAdjacentRepeatedCharsI solution = new RemoveAdjacentRepeatedCharsI();
        System.out.println(solution.deDup(s));
    }
}
  