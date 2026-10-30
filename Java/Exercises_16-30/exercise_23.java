class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        java.util.PriorityQueue<ListNode> minHeap = new java.util.PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;
            
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}

public class exercise_23 {
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
        
        ListNode l1 = arrayToList(new int[] {1, 4, 5});
        ListNode l2 = arrayToList(new int[] {1, 3, 4});
        ListNode l3 = arrayToList(new int[] {2, 6});
        
        ListNode[] lists = new ListNode[] {l1, l2, l3};
        
        ListNode resultado = solution.mergeKLists(lists);
        
        printList(resultado);
    }
}