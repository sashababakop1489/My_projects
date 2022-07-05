package com.babakov.task.cities.graph;

public abstract class ShortestWayGraphAlgorithm {
    protected final int INF = Integer.MAX_VALUE / 2; // "Infinity"
    protected int[] dist;
    protected int vNum; // number of vertices
    protected int[][] graph; // adjacency matrix
    protected NodeIndexer nodeIndexer;
    protected boolean isSet = false;

    public ShortestWayGraphAlgorithm setNodeIndexer(NodeIndexer nodeIndexer) {
        this.nodeIndexer = nodeIndexer;
        return this;
    }

    public ShortestWayGraphAlgorithm setVNum(int vNum) {
        this.vNum = vNum;
        return this;
    }

    public ShortestWayGraphAlgorithm setGraph(int[][] matrix) {
        if (vNum == 0) {
            throw new IllegalArgumentException("First setUp number of v");
        }
        if (matrix.length != vNum || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Matrix need to be square and matches number of v");
        }
        this.graph = matrix;
        isSet = true;
        return this;
    }

    public int getDist(int s, int d) {
        run(s);
        return dist[d];
    }

    public int getDist(String s, String d) {
        return getDist(nodeIndexer.getIndex(s) - 1, nodeIndexer.getIndex(d) - 1);
    }

    abstract void run(int st);
}
