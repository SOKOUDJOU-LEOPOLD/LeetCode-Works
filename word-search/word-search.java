class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    HashSet<String> seen = new HashSet<>();
    char[][] bd;
    public boolean exist(char[][] board, String word) {
        bd = board;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                seen.add(i+"-"+j);
                if(bd[i][j] == word.charAt(0) && dfs(i,j,word, 0)){
                    return true;
                }
                seen.remove(i+"-"+j);
            }
        }
        return false;
        
    }
    
    public boolean dfs(int i, int j, String word, int index){
        if(index == word.length()-1){
            return true;
        }
        
        for(int k = 0; k < dir.length; k++){
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            if(x>-1 && y>-1 && x<bd.length && y<bd[0].length && bd[x][y] == word.charAt(index+1)){
                if(!seen.contains(x+"-"+y)){
                    seen.add(x+"-"+y);
                    if(dfs(x, y, word, index+1)){
                        return true;
                    }
                    seen.remove(x+"-"+y);
                }

            }
        }
        
        return false;
    }
}