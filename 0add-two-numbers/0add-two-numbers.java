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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carier = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carier;
            carier = sum>=10?1:0;
            sum = sum%10;
            // creat node and add node and move pointer
            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carier;
            carier = sum>=10?1:0;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carier;
            carier = sum>=10?1:0;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            p.next = node;
            p = p.next;    
            l2 = l2.next;
        }
        
        // if carier != 0
        if(carier == 1){
            ListNode node = new ListNode(carier);
            p.next = node;
            p = p.next;
        }
        
        return dummy.next;

    }
}

/*
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

 342
+465

*/