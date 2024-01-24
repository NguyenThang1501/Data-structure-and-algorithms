package hw8_21002174;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise4_BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        q.add(0);
        while (!q.isEmpty()) {
            int u = q.peek();
            q.poll();
            ans.add(u);

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                    visited[v] = true;
                }
            }

        }
        return ans;

    }
}
