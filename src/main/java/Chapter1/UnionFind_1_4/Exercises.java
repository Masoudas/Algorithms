import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

class Eight{
    /**
     * This exercise was absolutely amazing. God, I can't believe how subtle errors can be in code.
     * 
     * So, when we check id[i] == id[p], there's no problem. However, when we reach index p, and set
     * id[p] = id[q], the value of id[p] is now id[q]!!!! Hence, the next comparison is not comparing to id[p],
     * but rather id[q]. Goodness me, I can't believe this is possible! Be cautious boy! Always write unit tests.
     */

}

class Nine{
    /**
     *  1
     * 0  3    6
     *   2 7   5
     *        4 9
              8
     * Nope. Because the length of the tree is not at most log9.
     */
}

class Eleven{
    /**
     * We can a class variable that will always keep those visited nodes when doing the find. The issue however is that we may not
     * visit every single node of the smaller component. For example, 1->2 1->3 and we start from 3, we will never
     * visit one. So perhaps the ultimate solution would be to search the entire connection to the parent node! The solution
     * manual has chosen the latter, which is odd.
     */
    class CompressedWeightedQuickUnion{
        int N;
        int sz[];
        int id[];

        CompressedWeightedQuickUnion(int N){
            this.N = N;
            sz = new int[N];
            id = new int[N];

            IntStream.range(1, N).foreach(i->{sz[i] = 1; id[i] = i;});
        }

        void union(int p, int q){
            Stack<Integer> visited_node_p = new Stack<>();  
            Stack<Integer> visited_node_q = new Stack<>();  
            int id_p = _find(p, visited_node_p);
            int id_q = _find(q, visited_node_q);

            if (id_p == id_q) return;

            if (sz[id_p] < sz[id_q]){
                sz[id_q] += sz[id_p];
                id[id_p] = id_q;
                _reassignId(visited_node_p, id_p);
            }else{
                sz[id_p] += sz[id_q];
                id[id_q] = id_p;
                _reassignId(visited_node_p, id_p);
            }

            N--;
        }

        int _find(int p, Stack<Integer> visited_node){
            while(p != id[p]){
                if(visited_node != null) visited_node.add(p);
                p = id[p];
            }

            return p;
        }

        void _reassignId(Stack<Integer> visited_node, int id){
            for (Integer node : visited_node) {
                this.id[node] = id;
            }
        }
    }

}

class Twelve{
    /**
     * So this would be like the previous exercise, except for now, we use the reassign method for both p and q.
     * 
     * Like for example 1->2 3->4. Now we say 1->3, so then 1->3->4 and 1->2. 
     * Now imagine 5->6->7 5->8. Now we say 5 is connected to 1. We get the main branch 1->5->6->7. 
     * 
     */
}

class Fourteen{
    /**
     * It's funny that the first implementation of the weighted quick union that I thought of actually used the
     * tree height rather than tree size.
     * 
     * Of course using strong induction, we know that at each level, the combination of the two trees of size k and i
     * would only add one to tree height, iff the two trees have the same height.
     * 
     * For the implementation, the only difference is that instea of sz, we use height and add one at each union with the
     * same size.
     */
    private class WeightedQuickUnionByHeight {

        int[] leaders;  // Equivalent to id
        int[] ranks;    // height
        int components;

        int maxHeight;

        public WeightedQuickUnionByHeight(int size) {
            leaders = new int[size];
            ranks = new int[size];
            components = size;

            maxHeight = 0;

            //Initialization
            for(int i = 0; i < size; i++) {
                leaders[i] = i;
                ranks[i] = 0;
            }
        }

        public int count() {
            return components;
        }

        public boolean connected(int site1, int site2) {
            return find(site1) == find(site2);
        }

        // O(lg n)
        // No path compression in this exercise
        public int find(int site) {
            while(site != leaders[site]) {
                site = leaders[site];
            }

            return site;
        }

        // O(lg n)
        public void union(int site1, int site2) {
            int leader1 = find(site1);
            int leader2 = find(site2);

            if (leader1 == leader2) {
                return;
            }

            if (ranks[leader1] < ranks[leader2]) {
                leaders[leader1] = leader2;
            } else if (ranks[leader2] < ranks[leader1]) {
                leaders[leader2] = leader1;
            } else {
                leaders[leader1] = leaders[leader2];
                ranks[leader2]++;

                if (ranks[leader2] > maxHeight) {
                    maxHeight = ranks[leader2];
                }
            }

            components--;
        }
    }
}

class Fifteen{
    /**
     * I think I finally figured out what this guy is talking about. The question is what sort of tree shape makes the
     * total number of search the worst among all possible tree shapes?
     * 
     * For example with one and two the answer is trivial. For four nodes, 1 - 2 is the wors case.
     * For 8 nodes, 1 - 3 - 3 is the worst case. This is because if paths were of depth 2, we would have a total
     * of 3 * (2 + 1) + 1 links, whereas with the binary tree we have 2 * (3 + 2 + 1) + 1 paths, which is worse!
     */
}