import java.util.LinkedList;

class Stack {
    private LinkedList<Integer> list = new LinkedList<>();

    // UC 1: Push operation (Adds to the front to keep last element on top)
    public void push(int data) {
        list.addFirst(data); 
    }

    // UC 2: Peak and Pop till empty
    public void peak() {
        if (list.isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element (Peak): " + list.getFirst());
        }
    }

    public void pop() {
        if (list.isEmpty()) {
            System.out.println("Underflow: Stack is empty.");
        } else {
            System.out.println("Popped: " + list.removeFirst());
        }
    }

    public void show() {
        System.out.println("Stack: " + list);
    }
}