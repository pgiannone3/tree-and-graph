package remove.linked.list.elements;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        var solution = new Solution();
        ListNode l6 = new ListNode(6);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l6_1 = new ListNode(6, l3);
        ListNode l2 = new ListNode(2, l6_1);
        ListNode l1 = new ListNode(1, l2);

        solution.removeElements(l1, 5);

        System.out.println(l1);
    }

    public ListNode removeElements(ListNode head, int val) {

        if(head == null)  {
            return null;
        }

        var headVal = head.val;
        if(headVal == val) {
            head = removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
        }
        return head;
    }
}
