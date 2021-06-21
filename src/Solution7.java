class Solution7 {
    public int reverse(int x) {
        if (x == 0) return 0;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (isNegative) res = -res;
        return res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE ? 0 : (int) res;
    }
}