package hw8_21002174;

import java.util.ArrayList;

public class Exercise1_AdjacencyList {
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i< V; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            graph.add(temp);
        }
        for (int i = 0; i< V; i++){
            graph.get(i).add(i);
        }
        for (int i =0; i<V;i++){
            for (int j = 0; j<adj.get(i).size();j++){
                graph.get(i).add(adj.get(i).get(j));
            }
        }
        return graph;
    }

}
