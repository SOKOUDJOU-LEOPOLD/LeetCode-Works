class Solution {
    public int missingNumber(int[] nums) {
        // sort the nums
        Arrays.sort(nums);
        int n = nums.length;
        // traverse nums
        int count = 0;
        for(int i=0;i<n; i++){
            if(count != nums[i]) return count;
            count ++;
        }
        return n;
        
    }
}