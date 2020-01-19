// --------------------------------------------------------
// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
// --------------------------------------------------------


/**
 *  Queue Interface.
 *  @param <T> the Generic.
 *  @author Abdikarim Abdirahman
 * 
 */

interface Queue<T> {
	/**
	 *  adds a plate in the Queue.
	 *  @param value the plate you are adding.
	 *  @return true.
	 */
	public boolean enqueue(T value);
	

	/**
	 *  removes a plate from the Queue.
	 *  @return p what you remove.
	 */
	public T dequeue(); //throw NoSuchElementException if nothing to dequeue
	
	/**
	 *  tells you the size of AttachedList.
	 *  @return internalList.size() returns the size.
	 */
	public int size();
	
	/**
	 *  tells you if the Queue is empty.
	 *  @return internalList.isEmpty() the method isEmpty() from attachedList.
	 */
	public boolean isEmpty();
	
	/**
	 *  clears the Queue.
	 */

	public void clear();
}