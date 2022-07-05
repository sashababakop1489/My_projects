package com.babakov.task.cities.graph;

import java.util.Arrays;

public class Dijkstra extends ShortestWayGraphAlgorithm {

    private int[][] cache;

    //The algorithm itself
    void run(int st) {
        if (Arrays.stream(cache[st]).sum() > 0) {
            dist = cache[st];
            return;
        }
        dist = new int[vNum]; //array of distances (by default all value values are INT_MAX aka infinity)
        int in = 0, u; //Any technical variables
        boolean[] pos = new boolean[vNum]; //Array where I mark visited vertices, by default they are not
        for (int i = 0; i < vNum; i++)//Filling arrays with default values
        {
            dist[i] = INF;
            pos[i] = false;
        }
        dist[st] = 0;//distance to starting vertex 0
        for (int count = 0; count < vNum - 1; count++) {
            int min = INF;//the initial value of the minimum is infinity
            for (int i = 0; i < vNum; i++)
                if (!pos[i] && dist[i] <= min) {
                    min = dist[i];
                    in = i;
                }
            u = in;
            pos[u] = true;
            for (int i = 0; i < vNum; i++)
                if ((!pos[i]) && (graph[u][i] != 0) && (dist[u] != INF) && (dist[u] + graph[u][i] < dist[i]))
                    dist[i] = dist[u] + graph[u][i];//Calculate new distances for each active vertex
        }
        cache[st] = dist;
    }

    @Override
    public Dijkstra setVNum(int vNum) {
        this.vNum = vNum;
        this.cache = new int[vNum][vNum];
        for (int i = 0; i < vNum; i++) {
            Arrays.fill(cache[i], 0);
        }
        return this;
    }
}
