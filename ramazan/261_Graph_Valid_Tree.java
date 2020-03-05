class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> seen = new HashSet<>();
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int[] edge : edges) {            
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            if (seen.contains(curr)) return false;
            seen.add(curr);
            
            for (int adj : map.get(curr)) {
                q.add(adj);
                map.get(adj).remove(curr);
            }
        }
        
        return seen.size() == n;
    }
}

/**
https://leetcode.com/problems/graph-valid-tree/description/

DFS solution. The only major trick is to remove previous node from the set of adjacent nodes.
There is also union find solution that seems to perform slightly better

Time: O(n)
Space: O(n)

*/