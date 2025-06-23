Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode a = dummy1;
        ListNode b = dummy2;
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                a.next = new ListNode(curr.val);
                a = a.next;
            }else{
                b.next = new ListNode(curr.val);
                b = b.next;
            }
            curr = curr.next;
        }
        a.next = dummy2.next;
        return dummy1.next;
    }
}
