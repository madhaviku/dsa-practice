Given the head of a linked list, return the list after sorting it in ascending order.

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
    public ListNode mergeLists(ListNode headA, ListNode headB){
        ListNode merged = new ListNode(0);
        ListNode curr = merged;
        while(headA != null && headB != null){
            if(headA.val < headB.val){
                curr.next = new ListNode(headA.val);
                headA = headA.next;
            }else{
                curr.next = new ListNode(headB.val);
                headB = headB.next;
            }
            curr = curr.next;
        }
        while(headA != null){
           curr.next = new ListNode(headA.val);
           headA = headA.next; 
           curr = curr.next;
        }
        while(headB != null){
           curr.next = new ListNode(headB.val);
           headB = headB.next; 
           curr = curr.next;
        }
        return merged.next;
    }
    private ListNode getMid(ListNode head){
         ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeLists(left, right);
    }
}
