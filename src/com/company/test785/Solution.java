package com.company.test785;

import java.util.LinkedList;

public class Solution {
    private boolean[] visited;
    private int[] colors;
    private int[][] graph;

    public boolean isBipartite(int[][] graph) {

        this.graph = graph;

        int V = graph.length;
        visited = new boolean[V];
        colors = new int[V];

        for(int v = 0; v < V; v ++)
            if(!visited[v])
                if(!dfs(v, 0)) return false;
        return true;
    }

    private boolean dfs(int v, int color){

        visited[v] = true;
        colors[v] = color;
        for(int w: graph[v])
            if(!visited[w]){
                if(!dfs(w, 1 - color)) return false;
            }
            else if(colors[v] == colors[w])
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] a={{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        boolean bipartite = new Solution().isBipartite(a);
        System.out.println(bipartite);
    }
}
