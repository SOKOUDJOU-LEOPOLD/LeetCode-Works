class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        
        int d = 0;
        int i=0, j=0;
        while(true){
            
            // check if next step is impossible 
            if(i>= n || j >= m || i<0 || j<0 || set.contains(Arrays.asList(i, j))){
                break;
            }
               
            // moving right
            while(d == 0 && j<m && !set.contains(Arrays.asList(i, j))){
                set.add(Arrays.asList(i, j));
                res.add(matrix[i][j]);
                j += dir[d][1];
            }
            j--;
            d = (d+1)%dir.length;
            i++;
            // moving down
            while(d == 1 && i<n && !set.contains(Arrays.asList(i, j))){
                set.add(Arrays.asList(i,j));
                res.add(matrix[i][j]);
                i += dir[d][0];
            }
            i--;
            d = (d+1)%dir.length;
            j--;
            // moving left
            while(d == 2 && j>-1 && !set.contains(Arrays.asList(i, j))){
                set.add(Arrays.asList(i,j));
                res.add(matrix[i][j]);
                j += dir[d][1];                
            }
            j++;
            d = (d+1)%dir.length;
            i--;
            // moving up
            while(d==3 && i>-1 && !set.contains(Arrays.asList(i,j))){
                set.add(Arrays.asList(i,j));
                res.add(matrix[i][j]);
                i += dir[d][0];                
            }
            i++;
            d = (d+1)%dir.length;
            j++;
        }
        
        return res;
        
        
    }
}

/*
directions = [right, down, left, up]
                0      1    2    3


start: (0,0)
while(true){

}







*/