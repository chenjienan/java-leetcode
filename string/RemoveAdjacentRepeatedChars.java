package string;

import java.util.*;

public class RemoveAdjacentRepeatedChars {
    public String deDup1(String input) {
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

    public String deDup4(String input) {
        if (input == null || input.isEmpty() || input.length() == 1) {
            return input;
        }

        char[] charArray = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>(Arrays.asList(charArray[0]));

        int i = 1;
        while (i < charArray.length) {
            if (!stack.isEmpty() && charArray[i] == stack.peekFirst()){
                while(i < charArray.length && charArray[i] == stack.peekFirst()) {
                    i++;
                }
                stack.pollFirst();
            } else {
                stack.offerFirst(charArray[i]);
                i++;
            }
        }

        int stackSize = stack.size();
        for (int j = stackSize - 1; j >= 0; --j) {
            charArray[j] = stack.pollFirst();
        }

        return new String(charArray, 0, stackSize);
    }

    public static void main(String[] args) {
        String s = "aaabbc";
        RemoveAdjacentRepeatedChars solution = new RemoveAdjacentRepeatedChars();
        // System.out.println(solution.deDup1(s));

        s = "abbbaaccz";
        System.out.println(solution.deDup4(s));
    }
}
  