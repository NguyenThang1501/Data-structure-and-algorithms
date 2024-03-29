package hw8_21002174;

import java.util.LinkedList;

public class Exercise15_EulerCircuit {
    private int V;
    private LinkedList<Integer> adj[];

    Exercise15_EulerCircuit(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    boolean isConnected(){
        boolean[] visited = new boolean[V];
        int i;
        for (i = 0; i<V; i++){
            if (adj[i].size() != 0) break;
        }
        if (i == V) return true;
        DFSUtil(i, visited);

        for (i =0; i<V; i++){
            if (!visited[i] && adj[i].size() > 0 ) return false;
        }
        return true;
    }

    int isEulerian()
    {
        if (!isConnected())
            return 0;

        int odd = 0;
        for (int i = 0; i < V; i++)
            if (adj[i].size()%2!=0)
                odd++;
        if (odd > 2)
            return 0;
        if (odd == 2) return 1;
        else return 2;
    }

    void test()
    {
        int res = isEulerian();
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else
            System.out.println("graph has a Euler cycle");
    }

    // Driver method
    public static void main(String args[])
    {
        Exercise15_EulerCircuit g1 = new Exercise15_EulerCircuit(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.test();

        Exercise15_EulerCircuit g2 = new Exercise15_EulerCircuit(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        g2.addEdge(4, 0);
        g2.test();

        Exercise15_EulerCircuit g3 = new Exercise15_EulerCircuit(5);
        g3.addEdge(1, 0);
        g3.addEdge(0, 2);
        g3.addEdge(2, 1);
        g3.addEdge(0, 3);
        g3.addEdge(3, 4);
        g3.addEdge(1, 3);
        g3.test();

        Exercise15_EulerCircuit g4 = new Exercise15_EulerCircuit(3);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(2, 0);
        g4.test();

        Exercise15_EulerCircuit g5 = new Exercise15_EulerCircuit(3);
        g5.test();
    }

}
