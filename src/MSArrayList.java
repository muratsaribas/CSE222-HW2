import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author murat
 */


public class MSArrayList < E > implements MSList<E>{
    // Data Fields
    /** The default initial capacity */
    private static final int INITIAL_CAPACITY = 10;

    /** The underlying data array */
    private E[] theData;

    /** The current size */
    private int size = 0;

    /** The current capacity */
    private int capacity = 0;

    /** Construct an empty KWArrayList with the default
     initial capacity
     */
    public MSArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[])new Object[capacity];
    }

    /**
     * Adds a reference to anEntry at the end of the ArrayList.
     * @param anEntry - The anEntry to be inserted
     * @return - Return always true
     */
    public boolean add(E anEntry) {
        if (size == capacity) {
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * Add an item at the specified index
     * @param index - The index at which the object is to be inserted
     * @param anEntry - The object to be inserted
     * @throws ArrayIndexOutOfBoundsException if the index is less than
     * zero or greater than size
     */
    public void add(int index, E anEntry){
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        if (size == capacity)
            reallocate();
        for (int i = size; i > index; i--)
            theData[i] = theData[i-1];
        theData[index] = anEntry;
        size++;
    }

    /** Get a value in the array based on its index.
     @param index - The index of the item desired
     @return The contents of the array at that index
     @throws ArrayIndexOutOfBoundsException - if the index
     is negative or if it is greater than or equal to the
     current size
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /** Set the value in the array based on its index.
     @param index - The index of the item desired
     @param newValue - The new value to store at this position
     @return The old value at this position
     @throws ArrayIndexOutOfBoundsException - if the index
     is negative or if it is greater than or equal to the
     current size
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    /** Remove an entry based on its index
     @param index - The index of the entry to be removed
     @return The value removed
     @throws ArrayIndexOutOfBoundsException - if the index
     is negative or if it is greater than or equal to the
     current size
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for (int i = index + 1; i < size; i++) {
            theData[i - 1] = theData[i];
        }
        size--;
        return returnValue;
    }

    /**
     * Removes the specified element from this list. Return always true
     * @param anEntry - Element to be removed from this list, if present
     * @return true
     */
    public boolean remove(E anEntry){
        int index = indexOf(anEntry);
        if (index != -1)
            remove(index);
        return true;
    }

    /** Allocate a new array to hold the directory
     */
    private void reallocate() {
        capacity = 2 * capacity;
        E[] newData = (E[])new Object[capacity];
        System.arraycopy(theData, 0, newData, 0, size);
        theData = newData;
    }

    /** Get the current size of the array
     @return The current size of the array
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Returns the index of the specified element in this list
     * or -1 if this list doesn't contain element
     * @param anEntry - Target object
     * @return index of the target object or -1 if there is no such index
     */
    public int indexOf(E anEntry){
        if (anEntry == null)
            return -1;
        else {
            for (int i = 0; i < size; i++)
                if (anEntry.equals(theData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * Returns true if this list contains the specified element
     * @param anEntry - Target object
     * @return true if this list contains the specified element
     */
    public boolean contains(E anEntry){
        return indexOf(anEntry) >= 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }


    private class Iter implements Iterator<E>{

        private int current = 0;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current < size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theData[current++];
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.
         * <p>
         * The behavior of an iterator is unspecified if the underlying collection
         * is modified while the iteration is in progress in any way other than by
         * calling this method, unless an overriding class has specified a
         * concurrent modification policy.
         * <p>
         * The behavior of an iterator is unspecified if this method is called
         * after a call to the {@link #forEachRemaining forEachRemaining} method.
         *
         */
        @Override
        public void remove() {
            MSArrayList.this.remove(--current);
        }
    }

    public void print(){
        if (!isEmpty())
            for (int i=0; i<size;i++)
                System.out.println(theData[i]);
    }




}