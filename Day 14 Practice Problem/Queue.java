class Queue {
    private LinkedList<Integer> list = new LinkedList<>();

    // UC 3: Enqueue operation (Append to the end)
    public void enqueue(int data) {
        list.addLast(data);
    }

    // UC 4: Dequeue operation (Remove from the beginning)
    public void dequeue() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Dequeued: " + list.removeFirst());
        }
    }

    public void show() {
        System.out.println("Queue: " + list);
    }
}