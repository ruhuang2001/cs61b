/**
 * Deque (usually pronounced like “deck”) is an irregular acronym of
 * double-ended queue. Double-ended queues are sequence containers with dynamic
 * sizes that can be expanded or contracted on both ends (either its front or
 * its back).
 */
public class LinkedListDeque<T> {
    public class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T item, LinkedListDeque<T>.Node prev, LinkedListDeque<T>.Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node node;
    private int size;


    public LinkedListDeque() {
        node = new Node((T) new Object(), null, null);
        node.prev = node;
        node.next = node;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, node, node.next);
        newNode.next = node;
        node.prev = newNode;
        size += 1;
    }

    public void addLast(T item) {
        NOde newNode = new Node(item, node.prev, node)
        node.prev.next = newNode;
        node.prev = newNode;
        size += 1;
}

    public boolean isEmpty() {
        return size() == 0;
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
        node.next = node.next.next;
        node.next.prev = node;
        size -= 1;

        return first;
    }

    public T removeLast() {
        if (isEmpty()) { 
            return null;
        }
        
        T last = node.prev.item;
        node.prev = node.prev.prev;
        node.prev.next = node;
        size -= 1;

        return first;
    }

    public T get(int index) {
        if (index >= size) {
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
        if (size < index) {
            return null;
        }

        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(LinkedListDeque<T>.Node node, int i) {
        return (i == 0) ? node.item : getRecursive(node.next, i - 1);
    }
}