import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkRows(board) && checkColumns(board) && checkBlocks(board);
    }

    private boolean checkRows(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int row = 0; row < n; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < m; col++) {
                char c = matrix[row][col];
                if (c == '.') continue;
                if (set.contains(c)) return false;
                set.add(c);
            }
        }
        return true;
    }

    private boolean checkColumns(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int col = 0; col < m; col++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < n; row++) {
                char c = matrix[row][col];
                if (c == '.') continue;
                if (set.contains(c)) return false;
                set.add(c);
            }
        }
        return true;
    }

    private boolean checkBlocks(char[][] matrix) {
        int n = matrix.length / 3;
        int m = matrix[0].length / 3;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Set<Character> set = new HashSet<>();
                for (int row = i * 3; row < i * 3 + 3; row++) {
                    for (int col = j * 3; col < j * 3 + 3; col++) {
                        char c = matrix[row][col];
                        if (c == '.') continue;
                        if (set.contains(c)) return false;
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }
}
