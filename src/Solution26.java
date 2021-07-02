public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length, i = 0;
        for (int j = 0; j < n; j++) {
            while (j < n && nums[j] == nums[i]) j++;
            if (j < n) nums[++i] = nums[j];
        }
        return i + 1;
    }
}