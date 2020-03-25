/**
https://leetcode.com/problems/sort-list/description/

The optimal solution is based on MergeSort, we need to split list into 2 parts and recursively merge thos parts

Time: O(nlogn)
Space: O(logn) for stack

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        
        int len = findlen(head);
        if (len == 1) return head;
        
        int half = len / 2;
        ListNode curr = head;
        ListNode prev = null;
        while (half > 0) {
            prev = curr;
            curr = curr.next;
            half--;
        }
        
        ListNode second = curr;
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(second);
        
        return merge(l1, l2);
    }
    
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            
            curr = curr.next;
        }
        
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;
        
        return dummy.next;
    }
    
    int findlen(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        
        return len;
    }
}