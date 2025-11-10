class Solution { 
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i=0; i<n-2; i++){
            //skip duplicates
            if(i>0 && nums[i] == nums[i-1]) continue;
            
            int left = i+1;
            int right = n-1;
            
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //skip duplicates on the left
                    left++;
                    while(left<n && nums[left-1] == nums[left]){
                        left++;
                    }
                    //skip duplicates on the right
                    right--;
                    while(right>-1 && nums[right]==nums[right+1]){
                        right--;
                    }
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
            }
                
        }
        
        return list;
    }
}


/*

Idea: Traversal + Two Pointer Approach

{-1,0,1}   
  
*/