// Kadane's Algorithm  -> SubArray Sum

class Solution{
    public int maxSubArray(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int num:nums){
            curSum = Math.max(num, curSum+num);
            maxSum = Math.max(maxSum, curSum);

        }
        return maxSum;
    }
}


// TLE
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum = Integer.MIN_VALUE;

//         for (int i = 0; i < nums.length; i++) {
//             int currentSum = 0;
//             for (int j = i; j < nums.length; j++) {
//                 currentSum += nums[j];
//                 maxSum = Math.max(maxSum, currentSum);
//             }
//         }

//         return maxSum;
//     }
// }