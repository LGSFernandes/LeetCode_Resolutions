class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}


public class exercise_19 {
    
    public static Solution.ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Solution.ListNode dummy = new Solution.ListNode(0);
        Solution.ListNode current = dummy;
        for (int val : arr) {
            current.next = new Solution.ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
    
    public static void printList(Solution.ListNode head) {
        Solution.ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        Solution.ListNode head = arrayToList(new int[] {1, 2, 3, 4, 5});
        int n = 2;
        
        Solution.ListNode novaHead = solution.removeNthFromEnd(head, n);
        
        printList(novaHead);
    }
}