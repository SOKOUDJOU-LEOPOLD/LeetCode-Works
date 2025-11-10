class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int n= nums.length;
        // sort nums
        Arrays.sort(nums);
        
        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j = i+1; j<n-2; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                
                int left = j+1;
                int right = n-1;
                while(left<right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    // System.out.println(sum);
                    if(sum == target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //skip duplicates left
                        left++;
                        while(left<n && nums[left] == nums[left-1]){
                            left++;
                        }
                        // // skip duplicates right
                        right--;
                        while(right>-1 && nums[right] == nums[right+1]){
                            right--;
                        }
                    }
                    else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                    
                }
            }
        }
        
        return list;
    }
}