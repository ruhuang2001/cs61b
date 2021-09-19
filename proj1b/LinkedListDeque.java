/**
 * Deque (usually pronounced like “deck”) is an irregular acronym of
 * double-ended queue. Double-ended queues are sequence containers with dynamic
 * sizes that can be expanded or contracted on both ends (either its front or
 * its back).
 */
public class LinkedListDeque<Item> implements Deque<Item> {
    private class Node {
        private Item item;
        private Node prev;
        private Node next;

        public Node(Item item, Node prev, Node next) {
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

    @Override
    public void addFirst(Item item) {
        Node newNode = new Node(item, node, node.next);
        newNode.next.prev = newNode;
        node.next = newNode;
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        Node newNode = new Node(item, node.prev, node);
        node.prev.next = newNode;
        node.prev = newNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return node.next == node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node newNode = node.next;
        while (newNode != node) {
            System.out.print(node.item + " ");
            newNode = newNode.next;
        }
    }

    @Override
    public Item removeFirst() {
        if (isEmpty()) { 
            return null;
        }
        
        Item first = node.next.item;
        node.next.next.prev = node;
        node.next = node.next.next;
        size -= 1;

        return first;
    }

    @Override
    public Item removeLast() {
        if (isEmpty()) { 
            return null;
        }
        
        Item last = node.prev.item;
        node.prev.prev.next = node;
        node.prev = node.prev.prev;
        size -= 1;

        return last;
    }

    @Override
    public Item get(int index) {
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

    public Item getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }

        return getRecursive(node.next, index);
    }

    private Item getRecursive(Node indexnode, int i) {
        if (i == 0) {
            return indexnode.item;
        }
        return getRecursive(indexnode.next, i - 1);
    }
}
