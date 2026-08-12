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
    public ListNode removeNthFromEnd(ListNode head, int n) {
// Using slow and fast pointers. 
        // The fast pointer is n steps ahead of the slow pointer. 
        // When the fast reaches the end, 
        // the slow pointer points at the previous element of the target element.
        
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i = 0 ; i < n ; i++) {
            fast = fast.next;
        }
        
        if(fast == null) {
            head = head.next;
            return head;
        }
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
