class Node {
    private String payload;
    private Node next;

    Node(String payload) {  //Constructor with just the payload
        this.payload = payload;
        this.next = null;
    }

    Node(String payload, Node next) { //Constructor with payload and next
        this.payload = payload;
        this.next = next;
    }

    //Gets the node linked with current node
    public Node getNext() {
        return this.next;
    }

    //Sets the next node for the current node
    public void setNext(Node next) {
        this.next = next;
    }

    //Returns the payload
    public String getPayload() {
        return this.payload;
    }
}
