package hw8_21002174;

import java.util.ArrayList;

public class Exercise5_DetectCycleUndirectedGraph {
    public void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis,
                    int parent, boolean foundACycle) {
        if (foundACycle) return;
        vis[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v]) dfs(v, adj, vis, u, foundACycle);
            else if (v != parent) {
                foundACycle = true;
                return;
            }
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean foundAClean = false;
        for (int u = 0; u < V; u++) {
            if (!vis[u])
                dfs(u, adj, vis, -1, foundAClean);
            if (foundAClean) return true;
        }
        return true;
    }
}
