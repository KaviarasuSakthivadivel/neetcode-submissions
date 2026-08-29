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
        if(head == null) {
            return null;
        }
        Node current = head;

        while(current != null) {
            Node next = current.next;
            current.next = new Node(current.val);
            current.next.next = next;

            current = next;
        }

        current = head;
        while(current != null) {
            if(current.next != null) {
                current.next.random = current.random != null ? current.random.next : null;
            }
            current = current.next != null ? current.next.next : current.next;
        }

        Node original = head, copy = head.next, copyHead = copy;
        while(original != null && copy != null) {
            original.next = original.next != null ? original.next.next : original.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;

            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
