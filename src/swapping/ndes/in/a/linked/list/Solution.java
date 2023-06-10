package swapping.ndes.in.a.linked.list;

public class Solution {

    public static void main(String[] args) {
        ListNode l2 = new ListNode(2);
        ListNode head = new ListNode(1, l2);


        Solution s = new Solution();
        ListNode result = s.swapNodes(head, 2);
        for(ListNode l = result; l != null; l = l.next) {
            System.out.println(l.val);
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        int maxH = maxH(head, 0);
        ListNode toSwapEnd = findNodeToSwapFromEnd(head, k, 0, maxH);
        ListNode toSwapStart = findNodeToSwapFromStart(head, k, 0);

        return swapNodes(head, k, toSwapEnd, toSwapStart, maxH);
    }

    private int maxH(ListNode head, int h) {
        if (head == null) {
            return h;
        }

        return maxH(head.next, ++h);
    }

    public ListNode findNodeToSwapFromEnd(ListNode head, int k, int actualH, int maxH) {
        if (head == null || head.next == null ) {
            return head;
        }

        else if(head.next.next == null && k == 2) {
            return head;
        }

        ListNode l = findNodeToSwapFromEnd(head.next, k, ++actualH, maxH);

        if((maxH - actualH) == k) {
            return head.next;
        } else {
            return l;
        }
    }

    public ListNode findNodeToSwapFromStart(ListNode head, int k, int actualH) {
        if(head == null || head.next == null) {
            return head;
        }
        else if(head.next.next == null && k == 2) {
            return head.next;
        }

        ListNode l = findNodeToSwapFromStart(head.next, k, ++actualH);

        if( k == actualH) {
            return head;
        } else {
            return l;
        }
    }

    public ListNode swapNodes(ListNode head, int k, ListNode toSwapEnd, ListNode toSwapStart, int maxH) {
        int actualH = 0;

        int[] arr = new int[maxH];

        for (ListNode l = head; l != null; l = l.next) {
            if (actualH + 1 == k) {
                arr[actualH] = toSwapEnd.val;
            } else if (maxH - actualH == k) {
                arr[actualH] = toSwapStart.val;
            }
            else {
                arr[actualH] = l.val;
            }
            actualH = actualH + 1;
        }

        int i = 0;
        ListNode l1 = new ListNode();
        for(ListNode l = l1; i<arr.length; l=l.next) {
            l.next = new ListNode(arr[i]);
            i = i+1;
        }

        return l1.next;
    }

}
