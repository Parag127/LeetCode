class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;

        int[] merge = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                merge[k] = nums1[i];
                i++;
            } else {
                merge[k] = nums2[j];
                j++;
            }
            k++;
        }

        if (i < nums1.length) {
            while (i < nums1.length) {
                merge[k] = nums1[i];
                i++;
                k++;
            }
        } else {
            while (j < nums2.length) {
                merge[k] = nums2[j];
                k++;
                j++;
            }
        }
        int n = merge.length;
        if (n % 2 == 0) {
            ans = ((double)(merge[n / 2]) + (double)(merge[(n / 2) - 1])) / 2;
        } else {
            ans = (double)(merge[n / 2]);
        }
        return ans;
    }
}