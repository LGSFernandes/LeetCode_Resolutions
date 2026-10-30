class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        
        while (true) {
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tempNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tempNode;
            }
            
            ListNode temporaryNode = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temporaryNode;
        }
        
        return dummy.next;
    }
    
    private ListNode getKthNode(ListNode current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }
}

public class exercise_25 {
    public static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
    
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode head = arrayToList(new int[] {1, 2, 3, 4, 5});
        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);

        ListNode head_2 = arrayToList(new int[] {1, 2, 3, 4, 5});
        int k_2 = 3;
        ListNode result_2 = solution.reverseKGroup(head_2, k_2);
        
        printList(result);
        printList(result_2);
    }
}