public class Solution53 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
        return res;
    }
}