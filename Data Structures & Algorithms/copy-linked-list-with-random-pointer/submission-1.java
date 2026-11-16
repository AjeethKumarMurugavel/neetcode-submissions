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
        Node result = new Node(0);
        Node dummy = result;
        while(head != null) {
            if(nodeMap.containsKey(head)) {
                dummy.next = nodeMap.get(head);
            } else {
                dummy.next = new Node(head.val);
                nodeMap.put(head, dummy.next);
            }
            if(head.random == null || nodeMap.containsKey(head.random)) {
                dummy.next.random = nodeMap.get(head.random);
            } else if(head.random != null) {
                dummy.next.random = new Node(head.random.val);
                nodeMap.put(head.random, dummy.next.random);
            }
            head = head.next;
            dummy = dummy.next;
        }
        return result.next;
    }
}
