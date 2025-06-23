Given the head of a singly linked list, reverse the list, and return the reversed list.

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, temp = null;
        while(curr != null){
            temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        head = prev;
        return head;
    }
}

Time Complexity : O(N)
