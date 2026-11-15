/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> nodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }
        if(nodeMap.containsKey(head)) {
            return nodeMap.get(head);
        }
        Node copy = new Node(head.val);
        nodeMap.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        return copy;
    }
}
