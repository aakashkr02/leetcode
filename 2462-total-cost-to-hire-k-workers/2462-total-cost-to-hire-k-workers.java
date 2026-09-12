class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0;
        int right = costs.length - 1;

        // Add initial left candidates
        while (left <= right && leftHeap.size() < candidates) {
            leftHeap.offer(costs[left]);
            left++;
        }

        // Add initial right candidates
        while (left <= right && rightHeap.size() < candidates) {
            rightHeap.offer(costs[right]);
            right--;
        }

        long total = 0;

        for (int i = 0; i < k; i++) {

            int leftCost = leftHeap.isEmpty()
                    ? Integer.MAX_VALUE
                    : leftHeap.peek();

            int rightCost = rightHeap.isEmpty()
                    ? Integer.MAX_VALUE
                    : rightHeap.peek();

            if (leftCost <= rightCost) {

                total += leftHeap.poll();

                if (left <= right) {
                    leftHeap.offer(costs[left]);
                    left++;
                }

            } else {

                total += rightHeap.poll();

                if (left <= right) {
                    rightHeap.offer(costs[right]);
                    right--;
                }
            }
        }

        return total;
    }
}