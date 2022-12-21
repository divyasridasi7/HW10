import java.util.NoSuchElementException;
import java.util.ListIterator;

public class MyTwoWayLinkedList<Item> implements Iterable<Item> {
    private int m;        //Size of the list
    private final Node<Double> prev;
    private final Node<Double> next;

    public MyTwoWayLinkedList() {
        next = new Node<>();
        prev  = new Node<>();
        prev.next = next;
        next.previous = prev;
    }
    private class Node<Double> {
        private Item s;
        private Node<Double> next;
        private Node<Double> previous;
    }

    // method to add the item to the list
    public void add(Item s) {
        Node<Double> last = next.previous;
        Node<Double> x = new Node<Double>();
        x.s = s;
        x.next = next;
        x.previous = last;
        next.previous = x;
        last.next = x;
        m++;
    }

    public ListIterator<Item> iterator()  { return new TwoWayLinkedListIterator(); }

    // assume no calls to DoublyLinkedList.add() during iteration
    private class TwoWayLinkedListIterator implements ListIterator<Item> {
        private Node<Double> present = prev.next;  //Node<Double> that is returned by next()
        private Node<Double> lastAccess = null;      // Last Node<Double> to be returned by prev() or next()
        // reset to null upon intervening remove() or add()
        private int index = 0;

        public boolean hasNext()      { return index < m; }
        public boolean hasPrevious()  { return index > 0; }
        public int previousIndex()    { return index - 1; }
        public int nextIndex()        { return index;     }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccess = present;
            Item item = present.s;
            present = present.next;
            index++;
            return item;
        }

        public Item previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            present = present.previous;
            index--;
            lastAccess = present;
            return present.s;
        }

        /* replace the item of the element that was last accessed by next() or previous()
        Condition: no calls to remove() or add() after last call to next() or previous() */
        public void set(Item item) {
            if (lastAccess == null) throw new IllegalStateException();
            lastAccess.s = item;
        }

        /* remove ele that was last accessed by next() or previous()
        Condition: no calls to remove() or add() after last call to next() or previous() */
        public void remove() {
            if (lastAccess == null) throw new IllegalStateException();
            Node<Double> a = lastAccess.previous;
            Node<Double> b = lastAccess.next;
            a.next = b;
            b.previous = a;
            m--;
            if (present == lastAccess)
                present = b;
            else
                index--;
            lastAccess = null;
        }

        // add ele to the list
        public void add(Item item) {
            Node<Double> x = present.previous;
            Node<Double> y = new Node<Double>();
            Node<Double> z = present;
            y.s = item;
            x.next = y;
            y.next = z;
            z.previous = y;
            y.previous = x;
            m++;
            index++;
            lastAccess = null;
        }
    }

    public String toString() {
        StringBuilder g = new StringBuilder();
        for (Item item : this)
        {
            g.append(item + " ");
        }
        return g.toString();
    }
}

