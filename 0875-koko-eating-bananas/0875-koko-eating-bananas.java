class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Maximum pile = maximum possible speed
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                // Speed is enough, try smaller
                right = mid;
            } else {
                // Speed is too slow
                left = mid + 1;
            }
        }

        return left;
    }
}