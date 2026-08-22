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
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> mp = new HashMap<>();

        Node newHead = null;
        Node newTail = null;
        while (head != null) {
            Node temp;
            if (!mp.containsKey(head)) {
                temp = new Node(head.val);
                mp.put(head, temp);
            } else {
                temp = mp.get(head);
            }
            if (head.next!= null && !mp.containsKey(head.next)) {
                Node tempNext = new Node (head.next.val);
                temp.next = tempNext;
                mp.put(head.next, tempNext);
            } else if (head.next!=null){
                temp.next = mp.get(head.next);
            }           

            if (head.random!= null && !mp.containsKey(head.random)) {
                Node tempRandom = new Node (head.random.val);
                temp.random = tempRandom;
                mp.put(head.random, tempRandom);
            } else if (head.random!=null){
                temp.random = mp.get(head.random);
            }  

            if (newTail == null) {
                newHead = temp;
                newTail = temp;
            }  else {
                newTail.next = temp;
                newTail = temp;
            }
            head = head.next;

        }
        return newHead;
    }
}
