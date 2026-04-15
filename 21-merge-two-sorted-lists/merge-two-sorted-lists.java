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
        ArrayList<Integer> ans = new ArrayList<>();
        while (list1 != null){
            ans.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null){
            ans.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(ans);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int val : ans){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
}