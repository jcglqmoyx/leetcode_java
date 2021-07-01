public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int lowBit = n & -n;
        return n == lowBit;
    }
}