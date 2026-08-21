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
        if (list1 == null ) return list2;
        if (list2 == null ) return list1;
        ListNode prev = null;
        ListNode combinedList = null;
        while (list1!=null && list2!=null) {
            if (list1.val<=list2.val) {
                if (prev == null) {
                    combinedList = list1;
                } else {
                    prev.next = list1;
                }
                prev = list1;
                list1 = list1.next;
                prev.next = null;
            } else {
                ListNode temp = list2.next;
                if (prev == null) {
                    combinedList = list2;
                } else {
                    prev.next = list2;
                }
                    prev = list2;
                    list2 = list2.next;
                    prev.next = null;
            }
        }

        if (list1!=null) {
            prev.next = list1;
        }

        if (list2!=null) {
            prev.next = list2;
        }

        return combinedList;

    }
}