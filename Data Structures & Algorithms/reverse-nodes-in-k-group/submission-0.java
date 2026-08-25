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
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode start = head;
        ListNode prev = null;
        int count = 0;
        while (head!=null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
            count++;
            if (count == k) {
                count = 0;
                curr.next = prev;
                prev = null;
                curr = start;
                start = head;

            }
        }
        if (count < k) {
               start = prev;
                prev = null;
                while (start !=null) {
                    ListNode temp = start.next;
                    start.next = prev;
                    prev = start;
                    start = temp; 
                }
                curr.next = prev;
        }



        return dummy.next;
    }
}
