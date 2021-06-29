public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m + n;
        m--;
        n--;
        for (int i = l - 1; i >= 0; i--) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) nums1[i] = nums1[m--];
                else nums1[i] = nums2[n--];
            } else if (m >= 0) nums1[i] = nums1[m--];
            else nums1[i] = nums2[n--];
        }
    }
}