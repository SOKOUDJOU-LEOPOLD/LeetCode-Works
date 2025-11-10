class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;    // row
        int k = mat1[0].length;
        int n = mat2[0].length;   // col
        
        int[][] res = new int[m][n];
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                
                res[i][j] = 0;
                for(int t =0; t<k; t++){
                    res[i][j] += mat1[i][t]*mat2[t][j]; 
                }
            }
        }
        
        return res;
        
    }
}