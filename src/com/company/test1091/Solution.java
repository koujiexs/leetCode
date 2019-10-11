package com.company.test1091;

import java.util.Queue;

import java.util.LinkedList;

public class Solution {
    private int[][]dirs={{-1,0},{-1,1},{0,1},{1,1},
            {1,0},{1,-1},{0,-1},{-1,-1}};
    private int R,C;
    public int shortestPathBinaryMatrix(int[][] grid) {
        R=grid.length;
        C=grid[0].length;
        boolean[][] visited=new boolean[R][C];
        int[][] dis=new int[R][C];
        if(grid[0][0]==1)
            return -1;
        if (R==1&&C==1)
            return 1;
        //BFS
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited[0][0]=true;
        dis[0][0]=1;
        while (!queue.isEmpty()){
            int cur=queue.remove();
            int curX=cur/C,curY=cur%C;
            for (int d = 0; d < 8; d++) {
                int nextX=curX+dirs[d][0];
                int nextY=curY+dirs[d][1];
                if (inArea(nextX,nextY)&&!visited[nextX][nextY]&&grid[nextX][nextY]==0){
                    queue.add(nextX*C+nextY);
                    visited[nextX][nextY]=true;
                    dis[nextX][nextY]=dis[curX][curY]+1;
                    if (nextX==R-1&&nextY==C-1)
                        return dis[nextX][nextY];
                }
            }
        }
        return -1;
    }
    private boolean inArea(int x,int y){
        return x>=0&&x<R&&y>=0&&y<C;
    }
}
