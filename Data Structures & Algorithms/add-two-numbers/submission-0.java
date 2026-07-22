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
                ListNode dummyNode = new ListNode(-1,null);

        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode current = dummyNode;
        int carry = 0;
        int sum = 0;

        while(t1 != null || t2 != null){

            if(t1 != null && t2 != null){
                sum = t1.val + t2.val + carry;
                t1 = t1.next;
                t2 = t2.next;
            }else if(t1 == null){
                sum = t2.val + carry;
                t2 = t2.next;
            }else{
                sum = t1.val + carry;
                t1 = t1.next;
            }

            ListNode sumNode = new ListNode(sum%10, null);
            current.next = sumNode;
            current = current.next;

            carry = sum / 10;
        }
        if(carry > 0){
            current.next = new ListNode(carry,null);
        }
        return dummyNode.next;
    }
}
