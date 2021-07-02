public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[l] >= target ? l : l + 1;
    }
}