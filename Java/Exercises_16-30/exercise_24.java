class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            prev = first;
        }
        
        return dummy.next;
    }
}

public class exercise_24 {
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
        
        ListNode head = arrayToList(new int[] {1, 2, 3, 4});
        ListNode result = solution.swapPairs(head);

        ListNode head_2 = arrayToList(new int[] {});
        ListNode result_2 = solution.swapPairs(head_2);

        ListNode head_3 = arrayToList(new int[] {1});
        ListNode result_3 = solution.swapPairs(head_3);

        ListNode head_4 = arrayToList(new int[] {1, 2, 3});
        ListNode result_4 = solution.swapPairs(head_4);
        
        printList(result);
        printList(result_2);
        printList(result_3);
        printList(result_4);
    }
}