class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i]) > n/3){
                set.add(nums[i]);
            }
            
        }
        
        // for(int i: set){
        //     res.add(i);
        // }
        res.addAll(set);
        return res;
        
    }
}