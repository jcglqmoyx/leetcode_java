public class Solution69 {
    public int mySqrt(int x) {
        long l = 0, r = x;
        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (mid * mid > x) r = mid - 1;
            else l = mid;
        }
        return (int) l;
    }
}
