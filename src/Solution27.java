public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            while (j < nums.length && nums[j] == val) j++;
            if (j < nums.length) nums[i++] = nums[j];
        }
        return i;
    }
}