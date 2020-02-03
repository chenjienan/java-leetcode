package string.recursion;

public class StringAbbreviationMatching {
    public boolean match(String input, String pattern) {
        // input and pattern are not null
        // input and pattern could be empty
        
        // base case
        if (input.isEmpty() && pattern.isEmpty()) {
            return true;
        }
        if (input.isEmpty() && !pattern.isEmpty()) {
            return false;
        }
        if (!input.isEmpty() && pattern.isEmpty()) {
            return false;
        }
        
        
        if (!Character.isDigit(pattern.charAt(0))) {
            if (input.charAt(0) != pattern.charAt(0)) {
                return false;
            }
            return match(input.substring(1), pattern.substring(1));
        }

        int i = 0;
        int skipChar = 0;
        while (i < pattern.length() && Character.isDigit(pattern.charAt(i))) {
            skipChar = skipChar * 10 + pattern.charAt(i) - '0';
            i++;
        }

        if (input.length() < skipChar) {
            return false;
        }        
        return match(input.substring(skipChar), pattern.substring(i));        
    }

    public static void main(String[] sss) {
        StringAbbreviationMatching sol = new StringAbbreviationMatching();
        System.out.print(sol.match("laioffercom", "6fer3"));
    }
}
  