class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] before = new int[n];
        int[] after = new int[n];
        //fill before
        int b = 1;
        before[0] = 1;
        for(int i =1; i<nums.length; i++){
            before[i] = nums[i-1]*before[i-1];
        }
        // fill after
        int a = 1;
        after[n-1] = 1;
        for(int i = n-2; i>-1; i--){
            after[i] = nums[i+1]*after[i+1];
        }
        
        int[] res = new int[n];
        //final 
        for(int i=0; i<n; i++){
            res[i] = before[i]*after[i];
        }
        
        return res;
        
    }
}