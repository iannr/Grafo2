package Grafo;

import java.util.ArrayList;
import java.util.Collections;

public class Graph {
    private int V; 
    private ArrayList<Integer>[] adj; 

    @SuppressWarnings("unchecked")
    Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v - 1].add(w);
    }

    void DFS(int vertex, boolean[] visited) {
        visited[vertex - 1] = true;
        System.out.print(vertex + " ");

        ArrayList<Integer> divergentEdges = new ArrayList<>();
        for (int neighbor : adj[vertex - 1]) {
            if (!visited[neighbor - 1]) {
                divergentEdges.add(neighbor);
                DFS(neighbor, visited);
            }
        }

        Collections.sort(divergentEdges);
        System.out.print(" (Divergent Edges: ");
        for (int edge : divergentEdges) {
            System.out.print(edge + " ");
        }
        System.out.print(") ");
    }
}


