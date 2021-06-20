class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        int res = 0;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (arr[mid] > arr[mid - 1]) {
                res = mid;
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}