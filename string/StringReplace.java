package string;

public class StringReplace {

    public String replace(String input, String source, String target) {
        if (input.isEmpty() || source.length() > input.length()) {
            return input;
        }

        int sourceSize = source.length(), targetSize = target.length();
        
        char[] charArray = input.toCharArray();
        char[] sourceArray = source.toCharArray();

        if (sourceSize < targetSize) {
            // expand the charArray
            char[] newArray = expandCharArray(charArray, sourceArray, target);
            int slow = newArray.length - 1;
            int fast = charArray.length - 1;

            while (fast >= 0) {
                if (checkWindowReversed(newArray, sourceArray, fast)) {
                    for (int i = 0; i < targetSize; ++i) {
                        newArray[slow] = target.charAt(targetSize - 1 - i);
                        slow--;
                    }
                    fast -= sourceSize;
                } else {
                    newArray[slow] = newArray[fast];
                    slow--;
                    fast--;
                }
            }
            return new String(newArray);
        }

        int slow = 0, fast = 0;
        while (fast < charArray.length){
            if (checkWindow(charArray, sourceArray, fast)) {
                for (int i = 0; i < targetSize; ++i) {
                    charArray[slow] = target.charAt(i);
                    slow++;
                }
                fast += sourceSize;
            } else {
                charArray[slow] = charArray[fast];
                slow++;
                fast++;
            }
        }

        return new String(charArray, 0, slow);
    }    

    private boolean checkWindow(char[] charArray, char[] source, int startIdx) {
        for (int i = 0; i < source.length; ++i) {
            if (startIdx + i >= charArray.length || charArray[startIdx + i] != source[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWindowReversed(char[] charArray, char[] source, int endIdx) {
        for (int i = 0; i < source.length; ++i) {
            if (endIdx - i < 0 || charArray[endIdx - i] != source[source.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private char[] expandCharArray(char[] oldArray, char[] source, String target) {
        int count = 0;
        int unit = target.length() - source.length;
        
        // check occurance of "source"
        for (int i = 0; i < oldArray.length; ++i) {
            if (checkWindow(oldArray, source, i)) {
                count++;
            }
        }
        
        char[] newArray = new char[oldArray.length + count * unit];
        // copy elements
        for (int j = 0; j < oldArray.length; ++j) {
            newArray[j] = oldArray[j];
        }
        return newArray;
    }

    public static void main(String[] args) {
        String input = "studend", s = "den", t = "xxxx";
        StringReplace sol = new StringReplace();
        System.out.println(sol.replace(input, s, t));
    }
}
  