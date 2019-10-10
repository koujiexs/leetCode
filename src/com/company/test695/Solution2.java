package com.company.test695;

import java.util.HashSet;

public class Solution2 {

    private int row;

    private int col;

    // 岛屿最大面积
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int temp;
                    if ((temp = dfs(grid, i, j)) > res) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        // 标记为已访问
        grid[i][j] = 0;
        int res = 1;
        // 如果不越界并且是岛屿就进入递归
        if (verify(i - 1, j) && grid[i - 1][j] == 1) {
            res += dfs(grid, i - 1, j);
        }
        if (verify(i, j + 1) && grid[i][j + 1] == 1) {
            res += dfs(grid, i, j + 1);
        }
        if (verify(i + 1, j) && grid[i + 1][j] == 1) {
            res += dfs(grid, i + 1, j);
        }
        if (verify(i, j - 1) && grid[i][j - 1] == 1) {
            res += dfs(grid, i, j - 1);
        }
        return res;
    }


    // 检查数组角标是否越界
    private boolean verify(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
