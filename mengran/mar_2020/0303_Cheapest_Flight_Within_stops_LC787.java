class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
       // create graph first and then do bfs using priorityQueue
        Map<Integer,Map<Integer, Integer>> graph = new HashMap();
        for(int i = 0; i < flights.length; i++) {
            Map<Integer, Integer> cur = graph.getOrDefault(flights[i][0], new HashMap());
            cur.put(flights[i][1], flights[i][2]);
            graph.put(flights[i][0], cur);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.offer(new int[]{0, src, K + 1});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int curPos = cur[1];
            int step = cur[2];
            if(curPos == dst) return cost;
            if(step > 0) {
                Map<Integer, Integer> neighbor = graph.get(curPos);
                if(neighbor != null) {
                    for(Map.Entry<Integer, Integer> entry : neighbor.entrySet()) {
                        pq.offer(new int[]{cost + entry.getValue(), entry.getKey(), step - 1});
                    }
                }
            }
        }
        return -1;
    }
}

/**
Problem: https://leetcode.com/problems/cheapest-flights-within-k-stops/
Analysis:
we can use greedy algorithm and best first search
use priorityqueue as BFS and sort for costs
start from step = k and only step > 0 do bfs and reduce step
TimeComplexity: O(v + E)
SpaceComplexity: O(V + E)
tag: #BFS
**/
