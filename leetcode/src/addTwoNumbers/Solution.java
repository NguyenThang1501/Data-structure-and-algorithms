package addTwoNumbers;

class Solution {

    public ListNode addToTail(ListNode headNode, int value) {
        ListNode newNode = new ListNode(value);
        if (headNode == null) {
            return newNode;
        } else {
            //Xac dinh last node
            ListNode lastNode = headNode;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }

            //Gan next cho lastNode = new Node
            lastNode.next = newNode;
        }
        return headNode;
    }

    public int length(ListNode l) {
        ListNode temp = l;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        if (length(l1) < length(l2)) {
            for (int i = 0; i < length(l2) - length(l1); i++) {
                addToTail(l1, 0);
            }
        } else {
            for (int i = 0; i < length(l1) - length(l2); i++) {
                addToTail(l2, 0);
            }
        }
        int nho = 0;

        while (temp1 != null && temp2 != null) {
            int s = temp1.val + temp2.val + nho;
            if (s > 9) {
                nho = s / 10;
                s = s % 10;
            }
            result = addToTail(result, s);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return result;
    }
}
