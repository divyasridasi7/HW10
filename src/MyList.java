import java.util.Collection;

public interface MyList<E> extends java.util.Collection<E> {

    // Add new ele at the particular index in the list
    public void add(int i, E f);

    public E get(int i);

    //Return the index of the first match ele in the list.

    public int indexOf(Object f);


    //Return the index of the last matching element in the list

    public int lastIndexOf(E f);

    //Remove the ele at the specified position in this list
    public E remove(int i);


    // Replace the ele at the specified position in this list
    public E set(int i, E f);

    @Override
    // Add a new element at the end of this list
    public default boolean add(E f) {
        add(size(), f);
        return true;
    }

    @Override
    // Return true if this list contains no elements
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    /** Remove the first occurrence of the element f
     *  from this list. Shift any subsequent ele to the left.
     *  Return true if the ele is removed. */
    public default boolean remove(Object f) {
        if (indexOf(f) >= 0) {
            remove(indexOf(f));
            return true;
        } else
            return false;
    }

    @Override
    public default boolean containsAll(Collection<?> l) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean addAll(Collection<? extends E> l) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean removeAll(Collection<?> l) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean retainAll(Collection<?> l) {
        // Left as an exercise
        return true;
    }

    @Override
    public default Object[] toArray() {
        // Left as an exercise
        return null;
    }

    @Override
    public default <C> C[] toArray(C[] array) {
        // Left as an exercise
        return null;
    }
}
