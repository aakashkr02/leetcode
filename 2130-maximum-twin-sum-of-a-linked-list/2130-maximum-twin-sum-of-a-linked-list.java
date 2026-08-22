class Solution {
    public int pairSum(ListNode head) {

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        ListNode current = slow;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Calculate maximum twin sum
        int maxSum = 0;
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            int sum = first.val + second.val;
            maxSum = Math.max(maxSum, sum);

            first = first.next;
            second = second.next;
        }

        return maxSum;
    }
}