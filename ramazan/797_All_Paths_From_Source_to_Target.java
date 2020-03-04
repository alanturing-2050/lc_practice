class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
       
        return res;
    }
    
    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
        if (node == graph.length-1) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int nei : graph[node]) {
            path.add(nei);
            dfs(graph, nei, path, res);
            path.remove(path.size() - 1);
        }
    }
}


/** 
https://leetcode.com/problems/all-paths-from-source-to-target/description/

Problem:
Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Solution is based on recursive DFS

Time: O(2^N*N) ~ O(2^N) since there is no marking visited nodes there are 2^N paths (backtracking) with each with N length; 
Space: O(2^N*N)

*/