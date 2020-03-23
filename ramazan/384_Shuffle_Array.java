/**
https://leetcode.com/problems/shuffle-an-array/description/

Design qustion. it's interesting espacially considering that naive approach can be improved using Fisher-Yates Algorithm

Time: O(n)
Space: O(n)
*/

class Solution {
    int[] nums;
    int[] orig;
    Random rnd = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.orig = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = orig.clone();
        
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = rnd.nextInt(n - i) + i;
            swap(nums, i, idx);
        }
        
        return nums;
    }
    
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */