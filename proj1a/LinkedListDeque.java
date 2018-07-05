public class LinkedListDeque<T> {

    private class DequeNode {
        public DequeNode previous;
        public T item;
        public DequeNode next;


        public DequeNode(DequeNode p, T i, DequeNode n) {
            previous = p;
             item = i;
            next = n;

        }
    }

    /** The first item (if it exists) is at sentinel.next or
     *  sentinel.previous
     */
    private DequeNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new DequeNode(null, null, null);
        size = 0;
    }

    public LinkedListDeque(T var) {
        sentinel = new DequeNode(null, null, null);
        sentinel.next = new DequeNode(sentinel, var, null);
        size = 1;
    }



    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        if(sentinel.next == null) {
            size += 1;
            sentinel.next = new DequeNode(sentinel, item, null);
        }

        sentinel = sentinel.next;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {

    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return true;

    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;

    }

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {

    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        return null;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.
     */
    public T removeLast() {
        return null;
    }

    /** Gets the item at the given indexm where 0 is the front,
     *  1 is the next item, and so forth.  If no such item exists,
     *  returns null.  Must not alter deque!
     */
    public T get(int index) {
        return null;
    }

    public static void main(String[] args) {

        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(5);
        L.addFirst(10);
        L.addFirst(15);
        System.out.println("size: " + L.size());




    }
}