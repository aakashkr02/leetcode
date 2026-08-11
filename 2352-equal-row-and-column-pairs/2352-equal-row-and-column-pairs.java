import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {

        int n = grid.length;

        Map<List<Integer>, Integer> map = new HashMap<>();

        // Store rows
        for (int[] row : grid) {

            List<Integer> list = new ArrayList<>();

            for (int num : row) {
                list.add(num);
            }

            map.put(list, map.getOrDefault(list, 0) + 1);
        }

        int count = 0;

        // Check columns
        for (int j = 0; j < n; j++) {

            List<Integer> column = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                column.add(grid[i][j]);
            }

            count += map.getOrDefault(column, 0);
        }

        return count;
    }
}