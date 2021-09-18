/**
 * Deque (usually pronounced like “deck”) is an irregular acronym of
 * double-ended queue. Double-ended queues are sequence containers with dynamic
 * sizes that can be expanded or contracted on both ends (either its front or
 * its back).
 */
public class LinkedListDeque<T> {
    private class Node {

        private T item;
        private Node prev;
        private Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node node;
    private int size;


    public LinkedListDeque() {
        node = new Node(null, null, null);
        node.prev = node;
        node.next = node;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, node, node.next);
        newNode.next.prev = newNode;
        node.next = newNode;
        size += 1;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, node.prev, node);
        node.prev.next = newNode;
        node.prev = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return node.next == node;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node newNode = node.next;
        while (newNode != node) {
            System.out.print(node.item + " ");
            newNode = newNode.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) { 
            return null;
        }
        
        T first = node.next.item;
        node.next.next.prev = node;
        node.next = node.next.next;
        size -= 1;

        return first;
    }

    public T removeLast() {
        if (isEmpty()) { 
            return null;
        }
        
        T last = node.prev.item;
        node.prev.prev.next = node;
        node.prev = node.prev.prev;
        size -= 1;

        return last;
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }

        Node res = node.next;
        while (index > 0) {
            res = res.next;
            index -= 1;
        }

        return res.item;
    }

    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }

        return getRecursive(node.next, index);
    }

    private T getRecursive(Node indexnode, int i) {
        if (i == 0) {
            return indexnode.item;
        }
        return getRecursive(indexnode.next, i - 1);
    }
}
