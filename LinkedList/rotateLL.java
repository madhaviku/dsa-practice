Given the head of a linked list, rotate the list to the right by k places.

Example 
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int n = 1;
        ListNode tail = head;
        // Count the number of nodes and make it circular
        while(tail.next != null){
            tail = tail.next;
            n++;
        }
        tail.next = head;
        k = k % n;

        ListNode slow = head, fast = head;
        while(fast != tail && k > 0){
            fast = fast.next;
            k--;
        }
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
        }

        head = slow.next;
        slow.next = null;
        return head;
    }
}
