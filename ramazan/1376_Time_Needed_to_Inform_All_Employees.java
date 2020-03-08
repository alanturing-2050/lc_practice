class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            map.get(manager[i]).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(headID);
        
        int max = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            
            for (int adj : map.get(curr)) {
                q.add(adj);
                informTime[adj] += informTime[curr];
                max = Math.max(max, informTime[adj]);
            }
        }
        
        return max;
    }
}

/**
https://leetcode.com/contest/weekly-contest-179/problems/time-needed-to-inform-all-employees/

One of the solutions is to use BFS and increment "informTime" values and record max

Time: O(n)
Space: O(n)
*/