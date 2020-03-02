class RLEIterator {
    int[] arr;
    int index;
    public RLEIterator(int[] A) {
        arr = A;
        index = 0;
    }

    public int next(int n) {
        while(index < arr.length - 1) {
            if(n > arr[index]) {
                n -= arr[index];
                index += 2;
            }
            else {
                arr[index] -= n;
                return arr[index + 1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */

 /**
 Problem: https://leetcode.com/problems/rle-iterator/
Analysis:
use a index to track the current iterate
if n > arr[index] => index += 2 move index to the next one
else modify the current index count
Time Complexity=> O(n)
Space Complexity => O(n)

tag: #array
 **/
