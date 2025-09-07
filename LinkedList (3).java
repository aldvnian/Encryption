import java.util.ArrayList;

public class LinkedList {
    private Node head;

    LinkedList(Node head) {
        this.head = head;
    }

    //Input: Node newItem
    //Purpose: Inserting newItem at the front of the list and connecting it with the others
    //Output: newItem at the front as well as connected with the other nodes
    public void insert(Node newItem) {
        Node temp = this.head;
        this.head = newItem;
        this.head.setNext(temp);
    }

    //Input: None
    //Purpose: To return all the nodes in the list
    //Output: ArrayList<String> all - this contains all the values of nodes in the list
    public ArrayList<String> getAll() {
        ArrayList<String> all = new ArrayList<String>();
        all.add(this.head.getPayload());
        Node current = this.head;
        while (current.getNext() != null) {
            current = current.getNext();
            all.add(current.getPayload());
        }
        return all;
    }
}
