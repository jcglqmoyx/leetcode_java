public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int[] hash = new int[nums.length];
        for (int num : nums) hash[num - 1]++;
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hash[i] == 0) a = i + 1;
            if (hash[i] == 2) b = i + 1;
        }
        return new int[]{b, a};
    }
}