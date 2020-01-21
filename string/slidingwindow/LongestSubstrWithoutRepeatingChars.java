package string;

import java.util.HashSet;

public class LongestSubstrWithoutRepeatingChars {
    
    public int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        int globalMax = 0;
        HashSet<Character> seen = new HashSet<>();
        // compute current window
        int left = 0;
        int right = 0;

        while (right < input.length()) {
            if (!seen.contains(input.charAt(right))) {
                seen.add(input.charAt(right));
                globalMax = Math.max(globalMax, right - left + 1);
                right++;
            } else {
                seen.remove(input.charAt(left));
                left++;
            }
        }
        return globalMax;
    }
    public static void main(String[] args) {
        String s = "bcdfbd";
        LongestSubstrWithoutRepeatingChars sol = new LongestSubstrWithoutRepeatingChars();
        System.out.println(sol.longest(s));
    }
}
  