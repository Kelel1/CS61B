public interface Deque<Item> {

    public void    addFirst(Item x);
    public void    removeFirst(Item x);
    public void    printDeque();
    public Item    addLast(Item x);
    public Item    removeLast();
    public Item    getItem(int i);
    public boolean isEmpty();
    public int     size();


}