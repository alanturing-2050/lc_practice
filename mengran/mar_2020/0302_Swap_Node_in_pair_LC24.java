/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
       //create general pattern for this
        if(head == null || head.next == null) return head;
        return reverseWithK(head, 2);
    }

    public ListNode reverseWithK(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if(count == k) {
            cur = reverseWithK(cur, k);
            while(count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
}


/**
Problem: https://leetcode.com/problems/swap-nodes-in-pairs/
Analysis:
create a more generice method to solve this problem
reverse with K group
use recursion and reverse LinkedList
 cur = reservewithK(cur, k);
 while(count-- > 0) {
 do reverse LinkedList
 head = cur;
}
return cur;
TimeComplexity: O(N)
SpaceComplexity: O(1)

tag: #Link list 
**/
