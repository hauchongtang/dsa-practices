public class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        this.parent = new int[edges.length+1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge: edges) {
            if (!union(edge[0], edge[1])) return edge;
        }
        return new int[]{-1,-1};
    }

    public boolean union(int x, int y) {
       int p1 = find(x);
       int p2 = find(y);
       if (p1 == p2) return false;
       this.parent[p1] = p2;
       return true;
    }

    public int find(int x) {
        if (x == this.parent[x]) return x;
        return find(this.parent[parent[x]]);
    }
}
