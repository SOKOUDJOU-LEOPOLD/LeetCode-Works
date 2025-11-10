class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int left = 0, right = n-1;
        int maxHL = height[left], maxHR = height[right];
        while(left<right){
            if(height[left] <= height[right]){
                if(maxHL < height[left]){
                    maxHL = height[left];
                }
                total += maxHL-height[left];
                left++;
            }else{
                if(maxHR < height[right]){
                    maxHR = height[right];
                }
                total += maxHR-height[right];
                right--;
            }
            
        }
        
        return total;
        
    }
}