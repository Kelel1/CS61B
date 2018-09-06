public class ArrayDeque<T> {

    private T[] items;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    /** Creates a new bigger array(2X), once original array
     * has reached max capacity.
     */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
    }


   /** Adds an item of type T to the front of the deque. 
    * If your pointer is a t postion 0, and you addfirst 
    * the front pointer should loop back around to the end 
    * of the array.
    */
   public void addFirst(T item) {

   }

   /** Adds an item of type T to the back of the deque. */
   public void addLast(T item) {
       if (size == items.length) {
         resize(size*2);
       }
       items[size] = item;
       size++;

   }

   /** Returns true if deque is empty, false otherwise. */
   public boolean isEmpty() {       
       return size == 0;
   }

   /** Returns the number of items in the deque. */
   public int size() {       
        return size;
   }

   /** Prints the items in the deque from first to last, separated by a space. */
   public void printDeque() {
     for (int i = 0; i < items.length; i++) {
       System.out.print(items[i] + " ");
     }

   }

   /** Removes and returns the item at the front of the deque.
    * If no such item exists, returns null.
    */
   public Item removeFirst() {
    return null;
   }

   /** Removes and returns the item at the back of the deque.
    *  If no such item exists, returns null.
    */
   public Item removeLast() {
      return null;
   }

   /** Gets the item at the given index where 0 is the front,
    *  1 is the next item, and so forth.  If no such item exists,
    *  returns null.  Must not alter deque!
    */
   public T get(int index) {
     return items[index];
   }
   
   public static void main(String[] args) {
     
    //  ArrayDeque<String> numbs = new ArrayDeque<String>();
    //  numbs.addLast("Hello Kern!");

    //  System.out.println(numbs.get(0));
   }
}
