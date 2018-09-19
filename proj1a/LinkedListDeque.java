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
    private DequeNode pointer;
    private int size;

    public LinkedListDeque() {
        sentinel = new DequeNode(sentinel, null, sentinel);
        pointer  = sentinel;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {

        DequeNode newNode;
        

        if (sentinel.next == null) {
            newNode = new DequeNode(sentinel, item, sentinel);            
            sentinel.next = newNode;
            sentinel.previous = newNode;
            newNode.previous = sentinel;
            newNode.next = sentinel;
            pointer = newNode;           
            size++;            
                   
        } else {
            
            pointer = sentinel.next;         
            newNode = new DequeNode(sentinel, item, pointer);         
            pointer.previous = newNode;            
            sentinel.next = newNode;
            pointer = newNode;            
            size++;
                     
        }
    } //complete

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        DequeNode newNode;
       
        if (sentinel.previous == null) {            
            newNode = new DequeNode(sentinel, item, sentinel);
            sentinel.next = newNode;
            sentinel.previous = newNode;
            newNode.previous = sentinel;
            newNode.next = sentinel;
            pointer = newNode;           
            size++; 
        } else {            
           
           pointer = sentinel.previous;
           newNode = new DequeNode(pointer, item, sentinel);
           pointer.next = newNode;
           sentinel.previous = newNode;
           pointer = newNode;
           size++;           
        
        }        
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    } 

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    } 

    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {

        pointer = sentinel;      
            
        while (pointer.next != sentinel) {            
            pointer = pointer.next;
            System.out.print(pointer.item + " ");
        }
        System.out.println();        
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }       

        DequeNode temp = pointer;

        if (sentinel.next != null) {
            pointer = sentinel.next;
            sentinel.next =  sentinel.next.next;
            sentinel.next.previous = sentinel;
            pointer.previous = null;
            pointer.next = null;
            temp = pointer;
            pointer = sentinel.next;            
            size--;
        }        
        return temp.item;
    }

    /** Removes and returns the item at the back of the deque.
     *  If no such item exists, returns null.
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        DequeNode temp = pointer;                

        if (sentinel.previous != null) {
            pointer = sentinel.previous;
            sentinel.previous = sentinel.previous.previous;
            sentinel.previous.next = sentinel;
            pointer.next = null;
            pointer.previous = null;
            temp = pointer;
            pointer = sentinel.previous;
            size-=1;            
            
        } 

        return temp.item;
    }

    /** Gets the item at the given index where 0 is the front,
     *  1 is the next item, and so forth.  If no such item exists,
     *  returns null.  Must not alter deque!
     */
    public T get(int index) {

        pointer = sentinel;

        if (index < 0 || index >= size || sentinel.next == null) {
            return null;
        }

        for (int i = 0; i <= index; i++) {
            pointer = pointer.next;
        }
        return pointer.item;
    }

    /** Same as get, but uses recursion */
    public T getRecursive(int index) {

        pointer = sentinel;
        int count = index;

        if (index < 0 || index >= size || sentinel.next == null) {
            return null;
        }

        while (count > -1) {                       
            getRecursive(count-=1);            
            pointer = pointer.next;
            return pointer.item;
        }
        
        return pointer.item;
    }

    // public static void main(String[] args) {  
        
    //     LinkedListDeque<Integer> K = new LinkedListDeque<>();
    //     K.addFirst(7);
    //     K.addFirst(3);
    //     K.addFirst(15);
    //     K.addFirst(25);
        
    //     System.out.print(K.get(1));

    //     System.out.println();
    //     System.out.print(K.getRecursive(1) + " <= Recurrsive");
    //     System.out.println();
    // }
}
