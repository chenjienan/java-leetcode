package string.slidingwindow;

public class LongestSubarrayContainsOnes {

    public int longestConsecutiveOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int globalMax = 0;
        int count = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                globalMax = Math.max(globalMax, right - left + 1);
                right++;
            
            // cases for nums[right] == 0
            } else if (count < k) {
                count++;
                globalMax = Math.max(globalMax, right - left + 1);
                right++;
            } else if (nums[left] == 0) {
                count--;
                left++;
            } else {    // 必须退位让贤
                left++;
            }
        }

        return globalMax;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,0,0,1,1,1,0,0,0};
        LongestSubarrayContainsOnes sol = new LongestSubarrayContainsOnes();
        System.out.println(sol.longestConsecutiveOnes(nums, 2));
    }
}
