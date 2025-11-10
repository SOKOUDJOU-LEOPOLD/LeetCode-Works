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
        if(head == null){
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        while(p.next != null){
            ListNode pA = p.next;
            p.next = p.next.next;
            ListNode dummyA = dummy.next;
            dummy.next = pA;
            pA.next = dummyA;
        }
        
        return dummy.next;
//         ListNode prev = null;
//         ListNode curr = head;

//         while (curr != null) {
//             ListNode next = curr.next; // Store next node
//             curr.next = prev;          // Reverse current node's pointer
//             prev = curr;               // Move prev and curr one step forward
//             curr = next;
//         }

//         return prev;
    }
}
