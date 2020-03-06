class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        // use bfs to solve this problem, set red as 0 and blue as 1
        Set<Integer>[][] graph = new HashSet[2][n];
        for(int i = 0; i < n; i++) {
            graph[0][i] = new HashSet();
            graph[1][i] = new HashSet();
        }
        // initiat the graph
        for(int i = 0; i < red_edges.length; i++) {
            graph[0][red_edges[i][0]].add(red_edges[i][1]);
        }
        for(int i = 0; i < blue_edges.length; i++) {
            graph[1][blue_edges[i][0]].add(blue_edges[i][1]);
        }

        int[][] res = new int[n][2];
        for(int i = 1; i < n; i++) {
            res[i][0] = Integer.MAX_VALUE;
            res[i][1] = Integer.MAX_VALUE;
        }
        Queue<int[]> queue = new LinkedList();
        // bfs for node and how it reach to the node
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        // bfs
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int vert = cur[0];
            int color = cur[1];
            for(int next : graph[1 - color][vert]) {
                if(res[next][1 - color] == Integer.MAX_VALUE) {
                    res[next][1 - color] = res[vert][color] + 1;
                    queue.offer(new int[]{next, 1 - color});
                }
            }
        }
        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            int min = Math.min(res[i][0], res[i][1]);
            result[i] = (min == Integer.MAX_VALUE ? -1 : min);
        }
        return result;
    }
}


/**
Problem: https://leetcode.com/problems/shortest-path-with-alternating-colors/
Analysis:
this problem can be solved by BFS, need to use two graph one record the red edge between two nodes another one record the blude red_edges
mark red as 0 and blue as 1 so for next level use 1 - color represent the swap colors
TimeComplexity: O(V + E(red) + E(blue))
SpaceComplexity: O(V + E(red) + E(blue))

tag: #BFS

**/
