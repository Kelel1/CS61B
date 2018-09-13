public class ArrayDeque<T> {

    private T[] items;
		private int size;
		private int nextFirst;
		private int nextLast;

    public ArrayDeque() {
      items = (T[]) new Object[8];
			size = 0;
			nextFirst = 0;
			nextLast = 1;
    }

    /** Creates a new bigger array(2X), once original array
     * has reached max capacity.
     */
    private void resize(int capacity) {
      // T[] a = (T[]) new Object[capacity];
      // System.arraycopy(items, 0, a, 0, size);
    }


   /** Adds an item of type T to the front of the deque. 
    * If your pointer is a t postion 0, and you addfirst 
    * the front pointer should loop back around to the end 
    * of the array.
    */
   public void addFirst(T item) {
		int temp = nextFirst;

		if (nextFirst == 0 && items[nextFirst] == null) {
			items[nextFirst] = item;
			size+=1;
			nextFirst = minusOne(0);
		} else if ((nextFirst != 0) && items[nextFirst] == null) {
			items[nextFirst] = item;
			size+=1;
			nextFirst = minusOne(nextFirst);

		}

		// System.out.println(nextFirst + " <= should not be -1");


		 
   }

   /** Adds an item of type T to the back of the deque. */
   public void addLast(T item) {
     int temp = nextLast;
      //  if (size == items.length) {
      //    resize(size*2);
      //  }
      if(items[nextLast%items.length] == null) {
        items[nextLast%items.length] = item;
        nextLast = plusOne(temp);
        size++;
      } 
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
   public T removeFirst() {
    return null;
   }

   /** Removes and returns the item at the back of the deque.
    *  If no such item exists, returns null.
    */
   public T removeLast() {
      return null;
   }

   /** Gets the item at the given index where 0 is the front,
    *  1 is the next item, and so forth.  If no such item exists,
    *  returns null.  Must not alter deque!
    */
   public T get(int index) {
     return items[index];
	 }
	 
	 /** Computes the index immediately before a given index */
	 private int minusOne(int index) {
		if ((index == 0) ) {
			return items.length - 1;
		} else {
			return index - 1;
		}
		 
	 }

	 /** Computes the index immediately after a given index */
	 private int plusOne(int index) {
		 if ((index == size - 1) && (items[0] == null)) {
			 return 0;			 
		 }

		 return index + 1;
	 }
   
  //  public static void main(String[] args) {
     
  //   ArrayDeque<Integer> numbs = new ArrayDeque<Integer>();
  //   numbs.addLast(5);
  //   numbs.addFirst(10);
  //   numbs.addLast(15);
  //   numbs.addFirst(20);
  //   numbs.addLast(25);
  //   numbs.addFirst(30);
  //   numbs.addLast(35);
  //   numbs.addFirst(40);
  //   numbs.addLast(45);
    
  //   // numbs.addFirst(5);
  //   // numbs.addLast(10);
  //   // numbs.addLast(15);
  //   // numbs.addLast(20);
  //   // numbs.addLast(25);
  //   // numbs.addLast(30);
  //   // // numbs.addFirst(0);
  //   // numbs.addLast(35);
  //   // numbs.addLast(40);
  //   // numbs.addLast(45);
  //   System.out.println(numbs.get(0) + " <= should be null");
  //   System.out.println(numbs.get(1) + " <= should be 10");
  //   System.out.println(numbs.get(2) + " <= should be 15");
  //   // System.out.println(numbs.get(6) + " <= should be 15");
  //   // System.out.println(numbs.get(5) + " <= should be null");
  //   System.out.println();
  //   numbs.printDeque();
  //   System.out.println();
  //   System.out.println(numbs.size() + " <= size");
  //   System.out.println();

  //  }
}
