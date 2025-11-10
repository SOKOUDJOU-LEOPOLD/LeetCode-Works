class Solution {
    public int numIslands(char[][] grid) {
        int counter = 0;
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == '1'){
                    markLand(i, j, grid);
                    counter++;
                }
            }
        }
        
        return counter;
        
    }
    
    public void markLand(int x, int y, char[][] grid){
        grid[x][y] = '#';
        
        if(x+1<grid.length && grid[x+1][y] == '1'){
            markLand(x+1, y, grid);
        }
        if(y+1<grid[0].length && grid[x][y+1] == '1'){
            markLand(x, y+1, grid);
        }
        if(x-1>-1 && grid[x-1][y] == '1'){
            markLand(x-1, y, grid);
        }
        if(y-1>-1 && grid[x][y-1] == '1'){
            markLand(x, y-1, grid);
        }
    }
}

/*
[["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]]

*/