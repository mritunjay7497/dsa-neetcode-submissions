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
        ArrayList<Integer> item = new ArrayList<>();

        if(list1 == null && list2 == null){
            return list1;
        }

        if(list1 == null) return list2;

        if(list2 == null) return list1;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode sortedList = new ListNode();;

        while(temp1 != null){
            item.add(temp1.val);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            item.add(temp2.val);
            temp2 = temp2.next;
        }

        item.stream().forEach(System.out::println);

        // sort the item array
        Integer[] sorted = item.stream()
                            .sorted()
                            .toArray(Integer[]::new);

        sortedList.val = sorted[0];
        ListNode temp3 = sortedList;

        for(int i = 1; i<sorted.length; i++){
            temp3.next = new ListNode(sorted[i],null);
            temp3 = temp3.next;
        }
        return sortedList;
    }
}