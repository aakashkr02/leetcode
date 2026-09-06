import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] road : connections) {
            int from = road[0];
            int to = road[1];

            // Original direction: needs reversal
            graph[from].add(new int[]{to, 1});

            // Opposite direction: no reversal needed
            graph[to].add(new int[]{from, 0});
        }

        return dfs(0, -1, graph);
    }

    private int dfs(int city, int parent, List<int[]>[] graph) {

        int count = 0;

        for (int[] edge : graph[city]) {
            int nextCity = edge[0];
            int needsReverse = edge[1];

            if (nextCity == parent) {
                continue;
            }

            count += needsReverse;
            count += dfs(nextCity, city, graph);
        }

        return count;
    }
}