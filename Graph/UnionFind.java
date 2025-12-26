package Graph;

public class UnionFind {

    private int[] parent;
    private int[] rank;

    UnionFind(int[] p, int[] r){
        this.parent = p;
        this.rank = r;
    }

    public int findParent(int x){
        if(parent[x] == x) return x;
        parent[x] = findParent(parent[x]); // path compression
        return parent[x];
    }

    public void union(int x, int y){
        int px = findParent(x);
        int py = findParent(y);

        if(px == py) return;

        if(rank[px] < rank[py]){
            parent[px] = py;
        }
        else if(rank[px] > rank[py]){
            parent[py] = px;
        }
        else{
            parent[py] = px;
            rank[px]++;   
        }
    }
}
