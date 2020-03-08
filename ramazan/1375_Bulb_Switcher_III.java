class Solution {
    int[] p;
    int count;
    public int numTimesAllBlue(int[] light) {
        int n = light.length;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        count = 0;
        
        boolean[] state = new boolean[n];
    
        int res = 0;
        for (int l = 0; l < n; l++) {
            int pos = light[l] - 1;
            state[pos] = true;
            count++;
            
            if(pos > 0 && state[pos-1]) union(pos, pos-1);
            if(pos < n-1 && state[pos+1]) union(pos, pos+1);
            
            if (state[0] && count == 1) res++;
        }
    
        return res;
    }
    
    void union(int a, int b) {
        int gA = find(a);
        int gB = find(b);
        
        if (gA == gB) return;
        else {
            p[gA] = gB;
            count--;
        }
    }
    
    int find(int a) {
        while (a != p[a]) {
            p[a] = p[p[a]];
            a = p[a];
        }
        
        return a;
    }
}


/**
https://leetcode.com/contest/weekly-contest-179/problems/bulb-switcher-iii/

Straighforward solution once you realize that union-find can be used. Probabl there is a better solution though

Time: O(~n)
Space: O(n)
*/