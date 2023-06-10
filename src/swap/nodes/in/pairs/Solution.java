package swap.nodes.in.pairs;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode head = new ListNode(1, l2);
        ListNode result = s.swapPairs(head);

        for(ListNode l = result; l != null; l = l.next) {
            System.out.println(l.val);
        }

    }

    public ListNode swapPairs(ListNode head) {
        return swapPairs(head, 0);
    }
    public ListNode swapPairs(ListNode head, int height) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode h = swapPairs(head.next, ++height);
        ListNode tmp = new ListNode(h.val, h.next);

        if(height % 2 != 0) {
            head.next.next = head;
            head.next = tmp.next;
            return h;
        } else {
            head.next = h;
            return head;
        }
    }

}
