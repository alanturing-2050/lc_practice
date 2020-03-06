class Vector2D {
    int[][] v;
    int i = 0, j = 0;
    // Queue<Integer> q = new LinkedList<>();

    public Vector2D(int[][] v) {
        this.v = v;
    }
    
    public int next() {
        return hasNext() ? v[i][j++] : -1;
    }
    
    public boolean hasNext() {
        while ( i < v.length && j == v[i].length) {
            i++;
            j = 0;
        }
        
        return i < v.length;
    }
}

/**
https://leetcode.com/problems/flatten-2d-vector/description/
Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.

There is easier to implement solution but the time and space complexity are higher in worst case.

Time: O(1)
Space: O(1)
*/