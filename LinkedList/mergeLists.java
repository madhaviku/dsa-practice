You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                 curr.next = new ListNode(list2.val);
                 list2 = list2.next;
            }
            curr = curr.next;
        }

        while(list1 != null){
            curr.next = new ListNode(list1.val);
            curr = curr.next;
            list1 = list1.next;
        }
        while(list2 != null){
            curr.next = new ListNode(list2.val);
            curr = curr.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}

Time Complexity : O(M+N) -> length of both lists
