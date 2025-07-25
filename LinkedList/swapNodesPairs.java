Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example:

Input: head = [1,2,3,4]
Output: [2,1,4,3]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)  return head;
 
        ListNode slow = head, fast = head.next;

        while(fast != null){
            int temp = slow.val;
            slow.val = fast.val;
            fast.val = temp;
            if(fast.next == null) break;
            slow = fast.next;
            fast = slow.next;
        }
        return head;
    }
}
