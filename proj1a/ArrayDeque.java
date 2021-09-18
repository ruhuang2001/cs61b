public class ArrayDeque<T> {
    private T[] deque;
    private int capacity = 8;
    private int left;
    private int right;

    public ArrayDeque() {
        deque = (T[]) new Object[capacity];
        left = right = 0;
    }

    public boolean isEmpty() {
        return left == right;
    }

    private boolean isFull() {
        return size() == capacity - 1;
    }

    private boolean isLowRate() {
        return capacity >= 16 && size() < capacity / 4;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];

        int size = size();
        if (left < right) {
            for (int i = left, j = 0; i < right && j < size; i++, j++) {
                newArray[j] = deque[i];
            }
        } else if (left > right) {
            int j = 0;
            for (int i = left; j < capacity - left; i++, j++) {
                newArray[j] = deque[i];
            }
            for (int i = 0; j < size; i++, j++) {
                newArray[j] = deque[i];
            }
        }
        left = 0;
        right = size;
        deque = newArray;
        capacity = newSize;

    }

    public void addFirst(T item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }

        left = (left - 1 + capacity) % capacity;
        deque[left] = item;
    }

    public void addLast(T item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }

        deque[right] = item;
        right = (right + 1 + capacity) % capacity;
    }

    public int size() {
        return (right - left + capacity) % capacity;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T item = deque[left];
        left = (left + 1) % capacity;

        /**short length */
        if (isLowRate()) {
            resize((int) (capacity * 0.5));
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        right = (right - 1 + capacity) % capacity;
        T item = deque[right];
       
        /**short length */
        if (isLowRate()) {
            resize((int) (capacity * 0.5));
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size() || isEmpty()) {
            return null;
        }
        if (left < right) {
            return deque[index + left]; // left is similar to a array's 0 index.
        } else if (left > right) {
            if (index + left < capacity) {
                return deque[index + left];
            } else {
                return deque[(index + left) % capacity];
            }
        }
        return null;
    }

    public void printDeque() {
        if (left < right) {
            for (int i = left; i < right; i++) {
                System.out.print(deque[i] + " ");
            }
        } else if (left > right) {
            for (int i = left; i < capacity; i++) {
                System.out.print(deque[i] + " ");
            }

            for (int i = 0; i < right; i++) {
                System.out.print(deque[i] + " ");
            }
        }
    }
}
