class LinkedList {
    Node head;


    // Add at beginning
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    class LinkedList {
    Node head;

    // Add at beginning
    public void add(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public void append(int data) {
    Node newNode = new Node(data);

    if (head == null) {
        head = newNode;
        return;
    }

    Node temp = head;
    while (temp.next != null) {
        temp = temp.next;
    }

    temp.next = newNode;
}

public void insertAfter(int prevData, int data) {
    Node temp = head;

    while (temp != null && temp.data != prevData) {
        temp = temp.next;
    }

    if (temp != null) {
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }
}

public void pop() {
    if (head != null) {
        head = head.next;
    }
}

public Node search(int key) {
    Node temp = head;

    while (temp != null) {
        if (temp.data == key) {
            return temp;
        }
        temp = temp.next;
    }

    return null;
}

public void insertAfterNode(Node node, int data) {
    if (node != null) {
        Node newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    }
}

public void delete(int key) {
    if (head == null) return;

    if (head.data == key) {
        head = head.next;
        return;
    }

    Node temp = head;
    while (temp.next != null && temp.next.data != key) {
        temp = temp.next;
    }

    if (temp.next != null) {
        temp.next = temp.next.next;
    }
}

public int size() {
    int count = 0;
    Node temp = head;

    while (temp != null) {
        count++;
        temp = temp.next;
    }

    return count;
}

}

