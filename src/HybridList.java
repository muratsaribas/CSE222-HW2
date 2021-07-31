import java.util.Iterator;

public class HybridList<E>{
    private MSLinkedList<MSArrayList<E>> hybridList = new MSLinkedList<>();

    /**
     * No parameter constructor
     */
    public HybridList(){

    }

    /**
     * Returns the number of the elements in this list
     *
     * @return the number of elements in this list
     */
    public int size() {
        return hybridList.size();
    }

    /**
     * Returns true if this list contains no elements
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return hybridList.size() == 0;
    }


    /**
     * Insert an object to the list
     *
     * @param item - the item to be added
     * @return true always
     */
    public boolean add(MSArrayList<E> item) {
        return hybridList.add(item);
    }


    /**
     * Remove an element based on its index
     * @param index - The index of the element to be removed
     * @return true if the element removed from this list
     * otherwise false
     */
    public boolean remove(int index) {
        return hybridList.remove(index);
    }

    /**
     * Returns the element at the specified position in this list
     *
     * @param index - index of the element
     * @return the element at the specified position in this list
     */
    public MSArrayList<E> get(int index) {
        return hybridList.get(index);
    }


    /**
     * Returns an iterator
     *
     * @return iterator
     */
    public Iterator<MSArrayList<E>> iterator() {
        return hybridList.iterator();
    }

    public void print(){
        hybridList.print();
    }
}
