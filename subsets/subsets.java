class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // res.add(new ArrayList<>());
        dfs(0, nums, new ArrayList<>());
        return res;
        
    }
    
    public void dfs(int i, int[] nums,ArrayList<Integer> stack){
        if(i == nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }
        
        //skip of add
        dfs(i+1, nums, stack);
        stack.add(nums[i]);
        dfs(i+1, nums, stack);
        stack.remove(stack.size()-1);
    }
}