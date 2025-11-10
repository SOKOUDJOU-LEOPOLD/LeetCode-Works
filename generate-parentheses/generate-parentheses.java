class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        boolean flag = false;
        int open_count = 0;
        int close_count = 0;
        dfs(n, open_count, close_count, "");
        return res;
    }
    
    public void dfs(int n, int open_count, int close_count, String cur){
        if(open_count > n){
            return;
        }
        
        if(n == open_count && open_count == close_count){
            res.add(cur);
            System.out.println(cur);
        }
        
        // if(open_count<=n){
            if(open_count>close_count){  // open or close 
                dfs(n, open_count+1, close_count, cur+"(");
                dfs(n, open_count, close_count+1, cur+ ")") ;          
            }else{ // open
                dfs(n, open_count +1, close_count, cur+"(");
            }
        // }
    
    }
}

/*
                                        ""
                               "("
                          "()"     "(("





*/