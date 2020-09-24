package Chapter1.UnionFind_1_4;

/**
 * One problem that makes the quick union impractical is the fact that we need to find the root, which
 * if the branch is long, would take long. But imagine this. If we a have a branch 1->2 and a node 3,
 * if instead of saying 3->1->2, we say 1->3 and 1->2, then each node would be linked to its parent by
 * one link. Of course we still can have long branches, but still, the cost will come down.
 * 
 * So to remedy this, we keep the size of each tree (how many nodes it has). When we're about to connect
 * to parents, we connect the smaller tree to the larger tree (making the parent of larger tree, the parent of the
 * smaller tree).
 * 
 * Question I: Why not keep track of tree depth rather than size?
 * 
 * (Me: We should note that when a tree has depth N, it has size at least 2^N. To prove this by induction,
 * suppose a tree has depth N-1 and at least 2^(N-1). Then to increase the depth of this tree by one, we need 
 * to add another tree of size at least 2^N-1. Hence, we have at least 2^N elements for a tree of depth N.)
 * 
 * Question: What would be the maximum depth of a tree like this? The answer would be logN. We prove this
 * by strong induction. 
 * 
 * To implement this schema, we define an array containing the depth of each node. Everytime a node is 
 * added, we add one to its depth.
 */
class WeightedQuickUnion implements UI{
    int[] sz;
    int[] id;
    int component;

    WeightedQuickUnion(int N){
        sz = new int[N];
        id = new int[N];
        component = N;
    }

    public boolean connected(int p , int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int id_p = find(p);
        int id_q = find(q);

        if (id_p == id_q) return;

        if (sz[id_p] > sz[id_q]){
            id[id_q] = id_p;
            sz[id_p] += sz[id_p] ;
        }else{
            id[id_p] = id_q;
            sz[id_q] += sz[id_p];
        }

        component--;
    }

    public int find(int p){
        while (id[p] != p) p = id[p];
        return p;
    }

    public int count(){
        return component;
    }
}
