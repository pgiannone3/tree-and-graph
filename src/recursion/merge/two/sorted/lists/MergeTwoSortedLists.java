package recursion.merge.two.sorted.lists;

import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l4 = new ListNode(4);
        ListNode l2 = new ListNode(2, l4);
        ListNode l1 = new ListNode(1, l2);

        ListNode l4_ = new ListNode(4);
        ListNode l3 = new ListNode(2, l4_);
        ListNode l1_ = new ListNode(1, l3);

        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode result = m.mergeTwoLists(l1, l1_);
    }

    public ListNode mergeTwoLists(ListNode L1, ListNode L2) {
        if(L1 == null) {
            return L2;
        }

        if (L2 == null) {
            return L1;
        }

        if(L2.val > L1.val) {
            L1.next = mergeTwoLists(L1.next, L2);
            return L1;
        } else {
            L2.next = mergeTwoLists(L1, L2.next);
            return L2;
        }
    }
}
