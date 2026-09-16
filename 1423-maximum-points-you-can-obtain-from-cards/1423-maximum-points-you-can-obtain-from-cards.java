class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int rightSum = 0;
        int leftSum = 0;
        
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int maxSum = leftSum;
        int r = cardPoints.length - 1;
        while (k - 1 >= 0) {
            leftSum -= cardPoints[k - 1];
            rightSum += cardPoints[r];
            maxSum = Math.max(maxSum, (leftSum + rightSum));
            k--;
            r--;
        }
        return maxSum;
    }
}