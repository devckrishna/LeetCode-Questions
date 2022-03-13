public class LCA3 {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  }

  public Node lowestCommonAncestor(Node p, Node q) {
    Node first = p;
    Node second = q;
    while (first != second) {
      first = first == null ? q : first.parent;
      second = second == null ? p : second.parent;
    }

    return first;
  }
}
