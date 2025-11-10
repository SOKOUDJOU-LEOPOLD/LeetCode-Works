//Insertion sort
// Time: O(n^2)
//Space: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int l = 1;
        int r = nums.length-1;
        
        while(l<=r){
            int i = l-1;
            int tmp = nums[l];
            while(i>-1 && nums[i]>tmp){
                nums[i+1] = nums[i];
                i--;
            }
            nums[i+1] = tmp;
            l++;
        }
    }
}