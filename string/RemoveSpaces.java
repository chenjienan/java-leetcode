package string;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        
        if (input.isEmpty()) {
            return input;
        }

        char[] charArray = input.toCharArray();
        int slow = 0;
        int fast = 0;

        while (fast < charArray.length) {
            if (charArray[fast] != ' ') {
                charArray[slow++] = charArray[fast];
            } else if (charArray[fast] == ' ' && slow != 0) {   // make sure A[0] won't be overwrite
                if (charArray[slow-1] != ' ') {
                    charArray[slow++] = charArray[fast];        // in this case A[fast] is empty space
                }
            }
            fast++;
        }

        if (slow > 0 && charArray[slow-1] == ' ') {
            slow--;
        }
        return new String(charArray, 0, slow);
    }

    public static void main(String[] args) {
        String s = "   bc   bc   ";
        RemoveSpaces solution = new RemoveSpaces();
        System.out.println(solution.removeSpaces(s));
    }
}
  