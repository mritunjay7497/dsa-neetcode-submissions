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

        if(head == null || head.next == null){
            return head;
        }
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;

        while(temp != null){
            st.push(temp);
            temp = temp.next;
        }

        ListNode revListNodeHead = st.pop();
        temp = revListNodeHead;

        while(!st.isEmpty()){
            temp.next = st.pop();
            temp = temp.next;
        }
        temp.next = null;

        return revListNodeHead;
    }
}
