class Solution {
    Random rand;
    int[] preSum;
    public Solution(int[] w) {
        this.rand = new Random();
        for(int i=1; i<w.length; ++i)
            w[i] += w[i-1];
        this.preSum = w;
    }

    public int pickIndex() {
        int len = preSum.length;
        int idx = rand.nextInt(preSum[len - 1]) + 1;
        int left = 0;
        int right = len - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(preSum[mid] == idx) return mid;
            else if(preSum[mid] >= idx) {
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

 /**
Problem: https://leetcode.com/problems/random-pick-with-weight/
Analysis:
calculate the accumulate sum and use binary search to find the sum which is less or equals to the random result
Use accumulated freq array to get idx.
w[] = {2,5,3,4} => wsum[] = {2,7,10,14}
then get random val random.nextInt(14)+1, idx is in range [1,14]
idx in [1,2] return 0
idx in [3,7] return 1
idx in [8,10] return 2
idx in [11,14] return 3

notice because you want to find the left most so once do binary search mid = left + (right - left) / 2 => left always < mid and right always > mid
left = mid + 1 => always increase left
TimeComplexity: O(log(n))
SpaceComplexity: O(n)
tag: #Binary Search

 **/
