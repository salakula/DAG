package src;
import java.util.*;

public class Solution {
    private Map<Vertex, List<Edge>> graph;
    private Map<Vertex, Long> distance;

    public Solution() {
        this.graph = new HashMap<>();
        this.distance = new HashMap<>();
    }

    public void addEdge(Vertex from, Vertex to) {
        if (!graph.containsKey(from)) {
            graph.put(from, new ArrayList<>());
        }
        graph.get(from).add(new Edge(from, to));
        if (!graph.containsKey(to)) {
            graph.put(to, new ArrayList<>());
        }
    }

    public long longestPath(Vertex start) {
        for (Vertex vertex : graph.keySet()) {
            distance.put(vertex, Long.MIN_VALUE);
        }

        if (!graph.containsKey(start)) {
            return 0;
        }

        distance.put(start, 0L);

        List<Vertex> topologicalOrder = topologicalSort();

        for (Vertex vertex : topologicalOrder) {
            if (distance.get(vertex) != Long.MIN_VALUE) {
                List<Edge> edges = graph.get(vertex);
                for (Edge edge : edges) {
                    long newDistance = distance.get(vertex) + 1;
                    distance.put(edge.to, Math.max(distance.get(edge.to), newDistance));
                }
            }
        }

        long maxDistance = Long.MIN_VALUE;
        for (long dist : distance.values()) {
            maxDistance = Math.max(maxDistance, dist);
        }

        return maxDistance == Long.MIN_VALUE ? 0 : maxDistance;
    }

    private List<Vertex> topologicalSort() {
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();
        List<Vertex> result = new ArrayList<>();

        for (Vertex vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                topologicalSortUtil(vertex, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void topologicalSortUtil(Vertex vertex, Set<Vertex> visited, Stack<Vertex> stack) {
        visited.add(vertex);

        List<Edge> edges = graph.getOrDefault(vertex, Collections.emptyList());
        for (Edge edge : edges) {
            if (!visited.contains(edge.to)) {
                topologicalSortUtil(edge.to, visited, stack);
            }
        }

        stack.push(vertex);
    }

    public static void main(String[] args) {
        Solution dag = new Solution();

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        dag.addEdge(v1, v2);
        dag.addEdge(v1, v3);
        dag.addEdge(v2, v4);
        dag.addEdge(v3, v4);

        System.out.println("Longest path from v1: " + dag.longestPath(v1));
        System.out.println("Longest path from v2: " + dag.longestPath(v4));
    }

}
