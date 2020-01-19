// --------------------------------------------------------
// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
// --------------------------------------------------------

/**
 *  Stack Interface.
 *  @param <T> the Generic.
 *  @author Abdikarim Abdirahman
 * 
 */
interface Stack<T> {
	
	
	/**
	 *  Pushes a plate in the stack.
	 *   @param value what you are pushing.
	 *  @return true.
	 */
	public boolean push(T value);
	
	/**
	 *  removes a node from the Stack.
	 *  @return p what you pop.
	 */

	public T pop(); //throw NoSuchElementException if nothing to pop
	
	/**
	 *  tells you the size of AttachedList.
	 *  @return internalList.size() returns the size.
	 */
	public int size();
	
	
	/**
	 *  tells you if the stack is empty.
	 *  @return internalList.isEmpty() the method isEmpty() from attachedList.
	 */
	public boolean isEmpty();
	

	/**
	 *  clears the stack.
	 */

	public void clear();
}