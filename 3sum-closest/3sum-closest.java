class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        // sort nums
        Arrays.sort(nums);
        int res;
        double min_diff = Double.POSITIVE_INFINITY;
        int min_sum = 0;
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i-1] == nums[i]) continue;
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == target){
                    return target;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
                
                if(min_diff >= Math.abs(sum-target)){
                    min_diff = Math.abs(sum-target);
                    min_sum = sum;
                }
            }
            
        }
        
        return (int)min_sum;
        
        
    }
}