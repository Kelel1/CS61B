public interface Deque<Item> {

    public void    addFirst(Item x);
    public Item    removeFirst();
    public void    printDeque();
    public void    addLast(Item x);
    public Item    removeLast();
    public Item    getItem(int i);
    public boolean isEmpty();
    public int     size();


}