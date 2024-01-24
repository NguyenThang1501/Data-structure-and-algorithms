package hw8_21002174;

import java.util.ArrayList;

public class Exercise3_DFS {
    public void DFS(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans) {
        if (vis[i]) return;
        vis[i] = true;

        ans.add(i);
        for (int j : adj.get(i)) {
            if (!vis[j]) DFS(j, adj, vis, ans);
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                DFS(i, adj, vis, ans);
        }
        return ans;
    }
}
