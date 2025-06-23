Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example :
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        int count = 0; 
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        if(count < k) return head;

        curr = head;
        ListNode temp = null, prev = null;
        count = 0;
        while(count < k){
            temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            count++;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
