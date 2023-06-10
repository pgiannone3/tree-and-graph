package palindrome.linked.list;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    ListNode head = null;

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l2_2 = new ListNode(2, l2);
        ListNode l1_1 = new ListNode(1, l2_2);

        Solution s = new Solution();
        System.out.println(s.isPalindrome1(l1_1));
        System.out.println(s.isPalindrome(l1_1));
    }

    public boolean isPalindrome(ListNode head) {

        if(head.next == null) {
            return true;
        }

        Deque<Integer> stack = new LinkedList<>();
        ListNode myHead = head;

        while (myHead != null) {
            stack.push(myHead.val);
            myHead = myHead.next;
        }

        while (head != null) {
            var myInt = stack.pop();
            if(myInt != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;

    }

    public boolean isPalindrome1(ListNode head) {
        if(this.head == null) {
            this.head = head;
        }

        if(head == null) {
            return true;
        }

        boolean toRet = isPalindrome1(head.next) && head.val == this.head.val;
        this.head = this.head.next;
        return toRet;
    }

}
