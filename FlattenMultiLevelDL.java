class FlattenMultiLevelDL {
  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  };

  public Node flatten(Node head) {
    Node curr = head;
    while (curr != null) {
      if (curr.child != null) {
        Node childNode = curr.child;
        while (childNode.next != null) {
          childNode = childNode.next;
        }
        childNode.next = curr.next;
        if (childNode.next != null) {
          childNode.next.prev = childNode;
        }
        curr.next = curr.child;
        curr.next.prev = curr;
        curr.child = null;
      }
      curr = curr.next;
    }
    return head;
  }
}