import java.util.*;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int[] answer = new int[spells.length];
        int n = potions.length;

        for (int i = 0; i < spells.length; i++) {

            long required = (success + spells[i] - 1) / spells[i];

            int left = 0;
            int right = n - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (potions[mid] >= required) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // left = first potion that works
            answer[i] = n - left;
        }

        return answer;
    }
}