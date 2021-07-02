public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1]++;
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = carry + digits[i];
            digits[i] = sum % 10;
            if (sum < 9) return digits;
            carry = sum / 10;
        }
        if (carry > 0) {
            int[] res = new int[n + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, n + 1 - 1);
            return res;
        }
        return digits;
    }
}