package hw8_21002174;

import java.util.ArrayList;
import java.util.List;

public class Exercise6_DetectCycleDirectedGraph {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int V;

    public boolean isCyclicUtil(int i, boolean[] vis, boolean[] recStack) {
        if (recStack[i]) return true;
        if (vis[i]) return false;

        vis[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, vis, recStack))
                return true;

        recStack[i] = false;
        return false;
    }

    public boolean isCyclic() {
        boolean[] vis = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, vis, recStack))
                return true;
        }
        return false;
    }
}