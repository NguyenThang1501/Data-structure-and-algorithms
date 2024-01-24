package hw8_21002174;


import java.util.ArrayList;
import java.util.LinkedList;

public class Exercise13_LevelNode {
    public static int findLevel(int N, int[][] edges, int X) {
        int maxVertex = 0;
        for (int[] it : edges) {
            maxVertex = Math.max(maxVertex,
                    Math.max(it[0], it[1]));
        }

        ArrayList<Integer>[] adj
                = new ArrayList[maxVertex + 1];

        for (int i = 0; i <= maxVertex; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        if (X > maxVertex || adj[X].size() == 0)
            return -1;

        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
        int level = 0;

        boolean[] visited = new boolean[maxVertex + 1];

        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int currentNode = q.poll();

                if (currentNode == X)
                    return level;

                for (int it : adj[currentNode]) {
                    if (!visited[it]) {
                        q.offer(it);
                        visited[it] = true;
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges
                = {{0, 1}, {0, 2}, {1, 3}, {2, 4}};
        int X = 3;

        // Function call
        int level = findLevel(V, edges, X);
        System.out.println(level);
    }
}
