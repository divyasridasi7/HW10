public class MyLinkedList<E> implements MyList<E> {
    protected Node<E> hd, tl;
    protected int len = 0; // Number of elements in the list

    public MyLinkedList() {
    }

    /** Creating a list from an array of objs */
    public MyLinkedList(E[] obj) {
        for (int i = 0; i < obj.length; i++)
            add(obj[i]);
    }

    /** Return the head ele in the list */
    public E getFirst() {
        if (len == 0) {
            return null;
        }
        else {
            return hd.ele;
        }
    }

    public E getLast() {
        if (len == 0) {
            return null;
        }
        else {
            return tl.ele;
        }
    }

    /** Adding  ele to the beginning of the list */
    public void addFirst(E f) {
        Node<E> newNd = new Node<>(f); // Create a new node
        newNd.next = hd; // link the new node with the head
        hd = newNd; // head points to the new node
        len++; // Increase list size

        if (tl == null) // the new node is the only node in list
            tl = hd;
    }

    /** Adding  ele at the end of the list */
    public void addLast(E f) {
        Node<E> newNd = new Node<>(f); // Creating a new for element f

        if (tl == null) {
            hd = tl = newNd; // The new node is the only node in list
        }
        else {
            tl.next = newNd;
            tl = newNd;
        }

        len++;
    }

    @Override /** Adding a new element at the specified index
     * in this list. The index of the head ele is 0 */
    public void add(int index, E f) {
        if (index == 0) {
            addFirst(f);
        }
        else if (index >= len) {
            addLast(f);
        }
        else {
            Node<E> present = hd;
            for (int i = 1; i < index; i++) {
                present = present.next;
            }
            Node<E> temp = present.next;
            present.next = new Node<>(f);
            (present.next).next = temp;
            len++;
        }
    }

    /** Remove the head node and
     *  return the obj that is contained in the removed node. */
    public E removeFirst() {
        if (len == 0) {
            return null;
        }
        else {
            E temp = hd.ele;
            hd = hd.next;
            len--;
            if (hd == null) {
                tl = null;
            }
            return temp;
        }
    }

    /** Remove the last node and
     * return the object that is contained in the removed node. */
    public E removeLast() {
        if (len == 0) {
            return null;
        }
        else if (len == 1) {
            E temp = hd.ele;
            hd = tl = null;
            len = 0;
            return temp;
        }
        else {
            Node<E> present = hd;

            for (int i = 0; i < len - 2; i++) {
                present = present.next;
            }

            E temp = tl.ele;
            tl = present;
            tl.next = null;
            len--;
            return temp;
        }
    }

    @Override /** Remove the element at the specified position in this
     *  list. Return the element that was removed from the list. */
    public E remove(int ind) {
        if (ind < 0 || ind >= len) {
            return null;
        }
        else if (ind == 0) {
            return removeFirst();
        }
        else if (ind == len - 1) {
            return removeLast();
        }
        else {
            Node<E> previous = hd;

            for (int i = 1; i < ind; i++) {
                previous = previous.next;
            }

            Node<E> present = previous.next;
            previous.next = present.next;
            len--;
            return present.ele;
        }
    }

    @Override /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder re = new StringBuilder("[");

        Node<E> present = hd;
        for (int i = 0; i < len; i++) {
            re.append(present.ele);
            present = present.next;
            if (present != null) {
                re.append(", "); // Separate two elements with a comma
            }
            else {
                re.append("]"); // Insert the closing ] in the string
            }
        }

        return re.toString();
    }

    @Override
    public void clear() {
        len = 0;
        hd = tl = null;
    }

    @Override /** Return true if this list contains the element e */
    public boolean contains(Object f) {
        // Left as an exercise
        return true;
    }

    @Override /** Return the element at the specified index */
    public E get(int ind) {
        // Left as an exercise
        return null;
    }

    @Override /** Return the index of the first matching ele in
     *  this list. */
    public int indexOf(Object f) {
        // Left as an exercise
        return 0;
    }

    @Override /** Return the index of the last matching ele in
     *  this list. */
    public int lastIndexOf(E f) {
        // Left as an exercise
        return 0;
    }

    @Override /** Replacing the element at the specified position
     *  in this list with the specified element. */
    public E set(int ind, E f) {
        // Left as an exercise
        return null;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator
            implements java.util.Iterator<E> {
        private Node<E> present = hd; // present index

        @Override
        public boolean hasNext() {
            return (present != null);
        }

        @Override
        public E next() {
            E f = present.ele;
            present = present.next;
            return f;
        }

        @Override
        public void remove() {
            // Left as an exercise
        }
    }

    protected static class Node<E> {
        E ele;
        Node<E> next;

        public Node(E element) {
            this.ele = element;
        }
    }

    @Override /** Return the number of elements in this list */
    public int size() {
        return len;
    }
}