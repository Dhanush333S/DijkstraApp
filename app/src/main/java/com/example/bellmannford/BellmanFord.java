package com.example.bellmannford;

import java.util.*;

public class BellmanFord {

    static class Edge {
        int source, destination, weight;
        Edge() {
            source = destination = weight = 0;
        }
        Edge(int s, int d, int w) {
            source = s;
            destination = d;
            weight = w;
        }
    }

    static int INF = Integer.MAX_VALUE;
    static int V, E;
    static Edge[] edges;
    static int[] dist;

    static void bellmanFord(int src) {
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].source;
                int v = edges[j].destination;
                int weight = edges[j].weight;

                if (dist[u] != INF && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // check for negative-weight cycles
        for (int i = 0; i < E; i++) {
            int u = edges[i].source;
            int v = edges[i].destination;
            int weight = edges[i].weight;

            if (dist[u] != INF && dist[u] + weight < dist[v])
                System.out.println("Graph contains negative-weight cycle");
        }
    }

}

