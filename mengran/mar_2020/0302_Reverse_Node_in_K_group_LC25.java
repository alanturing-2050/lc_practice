/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if(count == k) {
            cur = reverseKGroup(cur, k);
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
Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
Analysis: similar with problem 24
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
tag: #Linked List
**/
