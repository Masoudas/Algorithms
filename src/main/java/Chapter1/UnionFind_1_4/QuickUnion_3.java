package Chapter1.UnionFind_1_4;

import java.util.stream.IntStream;

/**
 * One thing that we did in the previous algorithm which was unnecessay, was that we gave all the 
 * components the same name, and because of this, we had to iterate all over the ids. Hence, our search
 * is linear.
 * 
 * Here's how we can change it. We know that an equivalence can always be associated to one element (for
 * example, in module 3, 0 is equivalent to 3, 6, ...). Now, let's assume that we have such element, which
 * we call a parent node. The goal is to find this parent node for two sites, and then make only one of them
 * the representative (thus making the other child of it).
 * 
 * For example:
 * 1- If two nodes are connected to another (say a and b), now we make a>b, and call the component a (or 
 * the equivalence class a).
 * 2- If there's a branch (a->b->c->d) and an isolated site e, we either say (a->e, a->b->c->d) or
 * e->a->b->c->d. In either case, we now see that both of them have the same equivalence class representator.
 * 3- If in 2, d was a branch by itself, then again we just swap the equivalence class representative,
 * and we have for example a->e->f->g and a->b->c->d or vice versa.
 * 
 * The point here is that each connected path now has only a single parent site. This can be proven by induction
 * as well. Assume that in the previous step we have one, adding a new branch does the same.
 *
 * Note that in a branch a->b->c->d, the parent of b is a, the parent of c is b and so forth here. 
 * This happens when d was connected to c first. Then b was connected to c, then a to b.
 * Note that in each step, we're just swapping the parent, and not going over the entire branch
 * (something that we did with quick find). 
 * 
 * So, we refer to the id entry of each site as link. We refer to sites as nodes.
 * 
 * In the find method, we follow each site to another site, until we reach a root, which is an element linked to itself.
 * This would be the component name, naturally (because we want to return the equivalence value, not the
 * link of each node).
 * The algorithm is called quick union, because making connections is very quick here. We're just swapping
 * the parent node (although we have to find the parent, which is quite long, so the naming is not that pleasant!)
 * 
 * Question: What is the cost of find? Worst case is all nodes connected 1->2->3... .
 * In this case, at each node, one we read the id, another time we set it (a conservative estimation).
 * Hence, it would be 2 * (N-1) for the first N-1 and + 1 for last node. Hence, 2*N - 1.
 * 
 * Question is: what is the cost of union? We
 */

class QuickUnion implements UI{
    int[] id;
    int component;

    QuickUnion(int N){
        IntStream.range(0, N).foreach(i -> id[i] = i);
        component = N;
    }

    @Override
    public void union(int p, int q) {
        int id_p = find(p);
        int id_q = find(q);

        if (id_p == id_q) return;   // This is critical, because equal parents means equal branch.

        id[id_p] = id_q;
        component--;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (id[p] != p) p = id[p];

        return p;
    }

    @Override
    public int count() {
        return component;
    }
    
}

