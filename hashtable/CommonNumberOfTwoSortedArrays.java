package hashtable;

import java.util.*;

public class CommonNumberOfTwoSortedArrays {

    // contains duplicates
    public List<Integer> common(int[] A, int[] B) {
      
        if (A.length > B.length) {  // make sure A is the array with less elements
            int[] tmp = A;
            A = B;
            B = tmp;
        }

        int i = 0;  // pointer for A
        int j = 0;  // pointer for B
        List<Integer> res = new ArrayList<>();

        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                res.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    // no duplicates
    public List<Integer> common2(int[] A, int[] B) {
      
        if (A.length > B.length) {  // make sure A is the array with less elements
            int[] tmp = A;
            A = B;
            B = tmp;
        }

        int i = 0;  // pointer for A
        int j = 0;  // pointer for B
        List<Integer> res = new ArrayList<>();

        while (i < A.length) {
            while (i + 1 < A.length && A[i] == A[i+1]) {
                i++;
            }

            while (j + 1 < B.length && B[j] == B[j+1]) {
                j++;
            }

            if (A[i] == B[j]) {
                res.add(A[i]);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3};
        int[] arr2 = new int[] {2};
        CommonNumberOfTwoSortedArrays solution = new CommonNumberOfTwoSortedArrays();
        System.out.print(solution.common(arr1, arr2));
    }
  }
  