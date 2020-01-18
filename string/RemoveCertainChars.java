package string;

import java.util.HashSet;
import java.util.Arrays;

public class RemoveCertainChars {
    public String remove(String input, String t) {

        if (t.length() == 0 || input.length() == 0) {
            return input;
        }

        char[] charArray = input.toCharArray();
        HashSet<Character> charSet = new HashSet<>();

        for (int i = 0; i < t.length(); i++) {
            charSet.add(t.charAt(i));
        }

        int slow = 0, fast = 0;

        while (fast < input.length()) {
            if (charSet.contains(charArray[fast])) {
                fast++;
            } else {
                charArray[slow] = charArray[fast];
                slow++;
                fast++;
            }
        }

        return new String(Arrays.copyOfRange(charArray, 0, slow));
    }

    public static void main(String[] args) {
        String s = "acdbcd";
        String t = "db";

        RemoveCertainChars solution = new RemoveCertainChars();
        System.out.println(solution.remove(s, t));
    }
}

// "abcdbcd"
// remove "bd"
// return "acc"

// DS: Set 
// algorithm: 2 pointers
// slow
// fast: look-a-head index

// [0, slow] output
// [slow, fast - 1] dont care
// [fast, A.length-1] to explore
