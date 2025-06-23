You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6


Solution:

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
    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<Integer> ll = new LinkedList<>();
        for(ListNode list : lists){
            while(list != null){
                ll.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        Collections.sort(ll);
        for(int node : ll){
            curr.next = new ListNode(node);
            curr = curr.next;
        }
        return dummy.next;
    }
}
