import java.util.*;

class SmallestInfiniteSet {

    private int next;
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> set;

    public SmallestInfiniteSet() {
        next = 1;
        minHeap = new PriorityQueue<>();
        set = new HashSet<>();
    }

    public int popSmallest() {

        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            set.remove(smallest);
            return smallest;
        }

        return next++;
    }

    public void addBack(int num) {

        if (num < next && !set.contains(num)) {
            minHeap.offer(num);
            set.add(num);
        }
    }
}