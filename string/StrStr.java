package string;

public class StrStr {
    
    // needs to handle
    // 1 handle arbitray charset
    // 2 use module on a large number
    public int strstr(String large, String small) {

        if (small.length() == 0) {
            return 0;
        }
        if (large.length() < small.length()) {
            return -1;
        }
        
        int largePrime = 101;       
        int prime = 31;
        int seed = 1; // what is this? start from 1?

        // compute hash for "small"
        int targetHash = small.charAt(0) % largePrime;
        for (int i = 1; i < small.length(); ++i) {
            seed = moduleHash(seed, 0, prime, largePrime);
            targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
        }

        // check the first window at index 0 for "large"
        int hash = 0;
        for (int i = 0; i < small.length(); ++i) {      // O(m)
            hash = moduleHash(hash, large.charAt(i), prime, largePrime);
        }
        if (hash == targetHash && equals(large, 0, small)) {
            return 0;
        }

        // all the rest items in "large" (reuse the hash before)
        for (int i = 1; i <= large.length() - small.length(); ++i) {    // O(n - m)
            // make sure the number is non-negative
            hash = nonNegative(hash - seed * large.charAt(i-1) % largePrime, largePrime);       // remove previous (i - 1)
            hash = moduleHash(hash, large.charAt(i + small.length() - 1), prime, largePrime);   // add next (i + size(small) - 1)
            
            // same hash doesn't mean the same string
            if (hash == targetHash && equals(large, i, small)) {  // O(m)
                return i;
            }
        }

        return -1;
    }

    private boolean equals(String large, int start, String small) {
        for (int i = 0; i < small.length(); ++i) {
            if (large.charAt(i + start) != small.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private int moduleHash(int hash, int addition, int prime, int largePrime) {
        return (hash * prime % largePrime + addition) % largePrime;
    }

    private int nonNegative(int hash, int largePrime) {
        if (hash < 0) {
            hash += largePrime;
        }
        return hash;
    }

    
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "def";

        StrStr solution = new StrStr();
        System.out.println(solution.strstr(s1, s2));
    }
}
