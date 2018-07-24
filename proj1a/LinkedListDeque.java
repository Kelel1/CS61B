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
        

        if(sentinel.next == null) {
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
       
        if(sentinel.previous == null) {            
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
        if(size == 0) {
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
            
        while(pointer.next != sentinel) {            
            pointer = pointer.next;
            System.out.print(pointer.item + " ");
        }
        System.out.println();        
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        DequeNode temp = pointer;

        if(sentinel.next != null) {
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
        DequeNode temp = pointer;

        if(sentinel.previous != null) {
            pointer = sentinel.previous;
            sentinel.previous = sentinel.previous.previous;
            sentinel.previous.next = sentinel;
            pointer.next = null;
            pointer.previous = null;
            temp = pointer;
            pointer = sentinel.previous;
            size--;
            
        }
        return temp.item;
    }

    /** Gets the item at the given index where 0 is the front,
     *  1 is the next item, and so forth.  If no such item exists,
     *  returns null.  Must not alter deque!
     */
    public T get(int index) {
        if(index < size &&  index > -1) {

            if(index == 0) {
                return sentinel.item;
            } else if(index > 0) {
                for(int i = 0; i < index - 1; i++) {
                    sentinel = sentinel.previous;
                }
                return sentinel.previous.item;
            }

        }
        return null;
    }

    public static void main(String[] args) {

        LinkedListDeque<Integer> L = new LinkedListDeque<>();
//       L.addLast(5);
          L.addLast(10);
          L.addLast(15);
         L.addLast(25);
       L.addFirst(30);
         L.addFirst(35);
         L.addFirst(58);
       //  L.addFirst(22);
      //   System.out.println(L.removeLast());
    //     System.out.println(L.isEmpty());
        // L.addFirst(86);
    //     L.addFirst(84);
    //     L.addFirst(53);
    //    L.addFirst(66);
         System.out.println("size: " + L.size());
      //  System.out.println(L.get(0));
//        System.out.println(L.get(3));
      // System.out.println(L.get(2));
         L.printDeque();




    }
}