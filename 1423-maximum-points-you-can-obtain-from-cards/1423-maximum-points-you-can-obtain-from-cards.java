class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;

        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }

        int maxSum = lSum;
        int r = cardPoints.length - 1;

        while (k > 0) {
            lSum -= cardPoints[k - 1];
            rSum += cardPoints[r];

            maxSum = Math.max(maxSum, (lSum + rSum));
            k--;
            r--;
        }
        return maxSum;
    }
}