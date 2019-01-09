public class ArrayDeque<T> {

    private T[] items;
		private int size;
		private int nextFirst;
		// private int nextLast;

    public ArrayDeque() {
      items = (T[]) new Object[8];
			size = 0;
			nextFirst = 0;
		
    }

    /** Creates a new bigger array(2X), once original array
     * has reached max capacity.
     */
    private void resize(int capacity, int startPosition) {
      T[] a = (T[]) new Object[capacity];
      System.arraycopy(items, (0) % items.length, a, startPosition, size);
      nextFirst = 0;
      items = a;

    }


   /** Adds an item of type T to the front of the deque.
    * If your pointer is a t postion 0, and you addfirst
    * the front pointer should loop back around to the end
    * of the array.
    */
   public void addFirst(T item) {

    if (size == items.length) {
      resize(size*2, 0);

    }

    /* My incorrerect implementation
      items[nextFirst] = item;
      nextFirst = minusOne(nextFirst);
      size++;
      Correct implementation below from Data Structures
    * and Algorithms in Java (6th ed.) Goodrich et al.
    */    
    nextFirst = (nextFirst - 1 + items.length) % items.length;
    items[nextFirst] = item;     
    size++;   
   }

   /** Adds an item of type T to the back of the deque. */
   public void addLast(T item) {

  //  if (items[nextLast] == null) {
  //    items[nextLast % (items.length)] = item;
  //    nextLast = plusOne(nextLast);
  //    size++;
  //  }

  int last = (nextFirst + size) % items.length;
  if (size == items.length) {
    resize(size*2, last+1);
    // nextFirst = 0;
  }

      // int newLast = (nextLast + size) % items.length;
      items[last] = item;
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
   public T removeFirst() {
    if (size == 0) {
      return null;
    }
//  *** Debug this part below ***

   if (size <= (0.25*items.length)) {

      //  resize(items.length / 2, 0);

      T[] a = (T[]) new Object[items.length / 2];
      
      System.arraycopy(items, nextFirst% items.length, a, 0, size);      
      nextFirst = 0;
      items = a;
   }
//       ********************* 11.9.2018 - 1.3.2019    
   
    T toReturn = items[nextFirst % items.length];
    items[nextFirst % items.length] = null;    
    
    nextFirst+=1;
    size-=1;
    

    return toReturn;
   }

   /** Removes and returns the item at the back of the deque.
    *  If no such item exists, returns null.
    */
   public T removeLast() {

    if (size <= (0.25*items.length)) {
   

      T[] a = (T[]) new Object[items.length / 2];
      System.arraycopy(items, nextFirst, a, 0, size);
      nextFirst = 0;
      items = a;
  }
    int last = (nextFirst + size-1) % items.length;
    if (size == 0) {
      return null;
    }
      // System.out.println(last + " <= fLast");
      T toReturn = items[last];
      items[last] = null;
      size-=1;
      // System.out.println(last + " <= Last");
   
      return toReturn;
   }

   /** Gets the item at the given index where 0 is the front,
    *  1 is the next item, and so forth.  If no such item exists,
    *  returns null.  Must not alter deque!
    */
   public T get(int index) {
     if (index < 0 || index > items.length - 1 || items[index] == null) {
       return null;
     }
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

//     ArrayDeque<Integer> numbs = new ArrayDeque<Integer>();
//     numbs.addFirst(1);
//     numbs.addFirst(2);
//     numbs.addFirst(3);
//     numbs.addFirst(4);
//     numbs.addFirst(5);
//     numbs.addFirst(6);
//     // numbs.addLast(13);
//     // numbs.addFirst(-1);
//     // numbs.addLast(14);
//     // numbs.addLast(2);
//     // numbs.addLast(3);
//     // numbs.addLast(4);
   
   
//     // numbs.addLast(7);
//     // numbs.addLast(8);

//   numbs.removeLast();
//   numbs.removeLast();
//   numbs.removeLast();
//   numbs.removeLast();
//   numbs.removeLast();
//   numbs.removeLast();


//   // numbs.removeFirst();
//   // numbs.removeFirst();
//   // numbs.removeFirst();
//   // numbs.removeFirst();
//   // numbs.removeFirst();
//   // numbs.removeFirst();

    
//     // numbs.removeFirst();
//     // numbs.removeFirst();
//     // numbs.removeFirst();
//     // numbs.removeFirst();
//     // numbs.removeFirst();
//     // numbs.removeFirst();
//     // numbs.removeFirst();
//     // numbs.removeFirst();
//     // 
// //    System.out.println();
//     // System.out.println(numbs.removeFirst() + "<= First 7");
//     // System.out.println(numbs.removeFirst() + "<= First 6");
//     // System.out.println(numbs.removeFirst() + "<= First 4");
//     // System.out.println(numbs.removeFirst() + "<= First 3");
//     // System.out.println(numbs.removeFirst() + "<= First 2");
//     // System.out.println(numbs.removeFirst() + "<= First 1");
//     // System.out.println(numbs.removeFirst() + "<= First 0");
//     System.out.println();
//     numbs.printDeque();
//     System.out.println();
//     // System.out.println(numbs.get(0));
//     // System.out.println(numbs.get(5));

//    }
}
