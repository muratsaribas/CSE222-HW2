import java.util.Iterator;

public interface MSList<E>{
    /**
     * Returns the number of the elements in this list
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns true if this list contains no elements
     * @return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns true if this list contains the specified element
     * @param item - Target element
     * @return true if this list contains the target element
     */
    boolean contains(E item);

    /**
     * Insert an object to the list
     * @param item - the item to be added
     * @return true always
     */
    boolean add(E item);

    /**
     * Removes the specified element from this list if it is present
     * @param item - the item to be removed
     * @return true if this list contained the specified element
     */
    boolean remove(E item);

    /**
     * Returns the element at the specified position in this list
     * @param index - index of the element
     * @return the element at the specified position in this list
     */
    E get(int index);

    /**
     * Replaces the element at the specified position in this list
     * with the specified element
     * @param index - index of the element
     * @param item - the item to be replaced
     * @return the element previously at the specified position
     */
    E set(int index, E item);

    /**
     * Returns the index of the specified element in this list
     * or -1 if this list doesn't contain the element
     * @param item target item
     * @return the index of the specified element in this list
     * or -1 if this list doesn't contain the element
     */
    int indexOf(E item);

    /**
     * Returns an iterator
     * @return iterator
     */
    Iterator<E> iterator();
}
