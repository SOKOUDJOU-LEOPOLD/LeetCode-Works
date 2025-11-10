class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, candidates, target, new ArrayList<>());
        return res;
    }
    
    public void dfs(int start, int[] candidates, int target, ArrayList<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            ArrayList<Integer> copy = new ArrayList<>(path);
            res.add(copy);
            return;
        }
        
        for(int i=start; i<candidates.length;i++){
            path.add(candidates[i]);
            dfs(i, candidates, target - candidates[i], path);
            path.remove(path.size()-1);
        }
    }
}