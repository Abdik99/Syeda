import java.util.NoSuchElementException;


/**
 *  Makes a Queue from LinkedLists.
 * 
 *  @author Abdikarim Abdirahman
 * 
 */

public class Air implements Queue<Plate> {

	/**
	 *  The max Max capacity of the Queue.
	 */
	public static final int MAX_CAPACITY = 13;

	/**
	 *  The linked list used to make a Queue.
	 */
	public AttachedList<Plate> internalList;



	/**
	 *  default constructor.
	 */

	public Air() 
	{
		internalList= new AttachedList<Plate>();

	}


	/**
	 *  adds a plate in the Queue.
	 *  @param value the plate you are adding.
	 *  @return true.
	 */


	public boolean enqueue(Plate value)
	{

		if (size()<MAX_CAPACITY)
		{
			internalList.add(value);
			return true;
		}

		else
		{
			return false;
		}



	}

	/**
	 *  removes a plate from the Queue.
	 *  @return p what you remove.
	 */

	public Plate dequeue() 
	{

		if (size()==0)
		{
			throw new NoSuchElementException("No Such Element");
		}



		return internalList.remove(0);

	}

	/**
	 *  tells you the size of AttachedList.
	 *  @return internalList.size() returns the size.
	 */

	public int size()
	{
		return internalList.size();
	}

	/**
	 *  tells you if the Queue is empty.
	 *  @return internalList.isEmpty() the method isEmpty() from attachedList.
	 */

	public boolean isEmpty()
	{
		return internalList.isEmpty();
	}

	/**
	 *  clears the Queue.
	 */

	public void clear()
	{

		internalList.clear();
	}


	// --------------------------------------------------------
	// testing code goes here... edit this as much as you want!
	// --------------------------------------------------------
	/**
	 *  main method.
	 *  @param args main method
	 */
	public static void main(String[] args) {

	}

	// --------------------------------------------------------
	// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
	// --------------------------------------------------------

	/**
	 *  toString.
	 *  @return super.toString()
	 */

	public String toString() {
		String returnString = "";
		for(Plate p : internalList) {
			returnString = p+returnString;
		}
		return returnString;
	}
}
