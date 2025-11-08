// TC: O(n)
// SC: O(n)+O(2) = O(n);

class Solution {
    private int size = 2;
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[this.size];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int compl = target-nums[i];
            if(map.containsKey(compl)){
                res[0] = map.get(compl);
                res[1] = i;
            }else{
                map.put(nums[i], i);
            }
        }
        return res;
        
    }
}




/*
-> create an array of int result to hold the result
-> create a hashmap (value, index) to store the value and index of any element I traverse
-> when I traverse the array nums i check if target-nums[i] is inside the hashmap.
    -> if yes -> I return the two index added inside the result array.
    -> else -> add that inside the map.

-> it is sure that we will have a unique result.

*/