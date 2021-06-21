class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x > 0 && x % 10 == 0) return false;
        int y = 0;
        while (x > y) {
            y = (y * 10) + x % 10;
            x /= 10;
        }
        return y / 10 == x || y == x;
    }
}