class Solution {
    List<List<Integer>> res = new ArrayList<>();
    HashSet<Integer> seen = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        
        dfs(nums, new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums, ArrayList<Integer> stack){
        if(stack.size() == nums.length){
            res.add(new ArrayList(stack));
            return;
        }
        
        for(int j =0; j< nums.length; j++){
            if(!seen.contains(j)){
                stack.add(nums[j]);
                seen.add(j);
                dfs(nums, stack);
                stack.remove(stack.size()-1);
                seen.remove(j);
            }
        }
        

    }
}