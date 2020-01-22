package string;

public class CompressString {
    public String compress(String input) {
        if (input.isEmpty()) {
            return input;
        }
        input = input + "#";
        char[] charArray = input.toCharArray();

        int slow = 0, count = 0;
        int fastStart = 0;
        int newLen = 0;

        for (int fastEnd = 0; fastEnd < charArray.length; ++fastEnd) {
            if (charArray[fastEnd] != charArray[fastStart]) {                
                charArray[slow++] = charArray[fastStart];
                if (count == 1) {
                    newLen += 2;    // 1 char 1 digit
                }
                else {              
                    newLen++;       // 1 char
                    String countStr = String.valueOf(count);
                    for (int i = 0; i < countStr.length(); ++i){
                        charArray[slow++] = countStr.charAt(i);
                        newLen++;   // digit >= 1 
                    }
                }
                fastStart = fastEnd;
                count = 1;          // reset counter
            } else {
                count++;
            }
        }
        
        char[] newArray = new char[newLen];
        int fast = slow - 1;        // last idx of the old array
        slow = newArray.length - 1; // last idx of the new array
        
        while (fast >= 0) {
            if (Character.isDigit(charArray[fast])) {
                while (fast >= 0 && Character.isDigit(charArray[fast])) {
                    newArray[slow--] = charArray[fast--];
                }
            } else {
                newArray[slow--] = '1';
            }
            newArray[slow--] = charArray[fast--];
        }

        return new String(newArray);
    }

    public static void main(String[] args) {
        String s = "abcccccccccc";
        CompressString sol = new CompressString();
        System.out.println(sol.compress(s));

    }
}
  