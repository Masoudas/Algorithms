package Chapter1.UnionFind_1_4;

/**
 * One interesting variation that we can do to WeightedQuickUnion is that we add another loop
 * to the find method, so that everytime we try and find the parent, we just set the parent id
 * of all nodes visited to the parent directly. That way, each node will be directly below the
 * parent (e.g, 1->2 1->3->4 becomes 1->2 1->3 1->4). But this variation has no practical improvement
 * over WeightedQuickUnion, studies have found.
 */