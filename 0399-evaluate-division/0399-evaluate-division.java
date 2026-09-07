import java.util.*;

class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, List<Pair>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(a, k -> new ArrayList<>())
                 .add(new Pair(b, value));

            graph.computeIfAbsent(b, k -> new ArrayList<>())
                 .add(new Pair(a, 1.0 / value));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                result[i] = dfs(graph, start, end, new HashSet<>());
            }
        }

        return result;
    }

    private double dfs(
            Map<String, List<Pair>> graph,
            String current,
            String target,
            Set<String> visited) {

        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);

        for (Pair edge : graph.get(current)) {

            if (visited.contains(edge.node)) {
                continue;
            }

            double result = dfs(graph, edge.node, target, visited);

            if (result != -1.0) {
                return edge.value * result;
            }
        }

        return -1.0;
    }

    class Pair {
        String node;
        double value;

        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}