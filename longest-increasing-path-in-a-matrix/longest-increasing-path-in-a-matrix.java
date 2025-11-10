class Solution {
    HashMap<String, Integer> memo = new HashMap<>(); 
    int[][] direc = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        
        int res = 0;
        for(int i =0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                res = Math.max(res, find(i, j, matrix));
            }
        }
        return res;
    }
    
    public int find(int i, int j, int[][] matrix){
        // check in memo
        if(memo.containsKey(i+"-"+j)){
            return memo.get(i+"-"+j);
        }
        
        int max = 1;
        for(int k=0; k<direc.length; k++){
            int x = i + direc[k][0];
            int y = j + direc[k][1];
            if(x>-1 && y > -1 && x<matrix.length && y<matrix[0].length && matrix[x][y] > matrix[i][j]){
                max = Math.max(max,find(x, y, matrix)+1);
            }
        }
        
        memo.put(i+"-"+j, max);
        return max;
        
    }
}