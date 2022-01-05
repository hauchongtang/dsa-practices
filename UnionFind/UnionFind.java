import java.util.Arrays;

class Edge {
    int src, dest;
}

class UnionFind {
    int V, E;
    Edge edge[];
    int[] parent;

    UnionFind(int v, int e) {
        this.V = v;
        this.E = e;
        this.edge = addEdges(E);
    }

    public static Edge[] addEdges(int n) {
        Edge[] e = new Edge[n];
        for (int i = 0; i < n; i++) {
            e[i] = new Edge();
        }
        return e;
    }

    int find(int[] parent, int i) {
        if (parent[i] < 0) {
            return i;
        }
        return find(parent, parent[i]);
    }

    void union(int x, int y) {
        int temp = this.parent[x];
        this.parent[y] = x;
        if (temp < 0) {
            if (temp == -1) this.parent[x] = -2;
            else this.parent[x] -= 2;
        }
    }

    int isCycle(UnionFind graph) {
        this.parent = new int[graph.V];
        
        for (int i = 0; i < parent.length; i++) {
            this.parent[i] = -1;
        }

        for (int i = 0; i < graph.E; i++) {
            Edge e = graph.edge[i];
            int s = this.find(this.parent, e.src);
            int d = this.find(this.parent, e.dest);
            System.out.println(s + " " + d);
            if (s == d) return 1;
            else union(s, d);
        }
        return 0;
    }

    public static void main(String[] args) {
        int V = 8, E = 9;
        UnionFind graph = new UnionFind(V,E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[1].src = 2;
        graph.edge[1].dest = 3;
        graph.edge[2].src = 4;
        graph.edge[2].dest = 5;
        graph.edge[3].src = 6;
        graph.edge[3].dest = 7;
        graph.edge[4].src = 1;
        graph.edge[4].dest = 3;
        graph.edge[5].src = 1;
        graph.edge[5].dest = 4;
        graph.edge[6].src = 0;
        graph.edge[6].dest = 2;
        graph.edge[7].src = 5;
        graph.edge[7].dest = 7;
        graph.edge[8].src = 4;
        graph.edge[8].dest = 6;

        System.out.println(graph.isCycle(graph)==1);
        System.out.println(Arrays.toString(graph.parent));
    }
}
