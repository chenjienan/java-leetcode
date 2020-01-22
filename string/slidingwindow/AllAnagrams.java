package string.slidingwindow;

import java.util.*;

public class AllAnagrams {

    public List<Integer> allAnagrams(String anagram, String l) {

        List<Integer> res = new ArrayList<>();
        if (l.length() == 0 || l.length() < anagram.length()) {
            return res;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < anagram.length(); ++i) {
            char key = anagram.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int matched = 0;

        for (int right = 0; right < l.length(); right++) {
            char rightChar = l.charAt(right);

            // add right
            if (map.get(rightChar) != null) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) { // from 1 to 0
                    matched++;
                }
            }

            int prevLeft = right - anagram.length();
            // remove prev left
            if (prevLeft >= 0) { // left shows
                char prevLeftChar = l.charAt(prevLeft);
                if (map.get(prevLeftChar) != null) {
                    map.put(prevLeftChar, map.get(prevLeftChar) + 1);
                    if (map.get(prevLeftChar) == 1) { // from 0 to 1
                        matched--;
                    }
                }
            }

            if (matched == map.size()) {
                res.add(prevLeft + 1); // add left index
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String l = "abcbac";
        String s = "ab";

        AllAnagrams sol = new AllAnagrams();
        System.out.println(sol.allAnagrams(s, l));

    }

}

