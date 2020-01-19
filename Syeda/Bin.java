import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 *  Makes a Stack from LinkedLists.
 * 
 *  @author Abdikarim Abdirahman
 * 
 */



public class Bin implements Stack<Plate> {
	/**
	 *  The linked list used to make a Stack.
	 */



	public AttachedList<Plate> internalList;



	/**
	 *  default constructor.
	 */
	public Bin() {

		internalList= new AttachedList<Plate>();

	}



	/**
	 *  Pushes a plate in the stack.
	 *   @param value what you are pushing.
	 *  @return true.
	 */
	@Override
	public boolean push(Plate value)
	{
		internalList.add(0,value);
		return true;

	}


	/**
	 *  removes a node from the Stack.
	 *  @return p what you pop.
	 */

	@Override
	public Plate pop() 
	{
		if (size()==0)
		{
			throw new NoSuchElementException("empty");
		}
		return internalList.remove(0);

	}

	/**
	 *  tells you the size of AttachedList.
	 *  @return internalList.size() returns the size.
	 */
	@Override
	public int size()
	{
		return internalList.size();
	}

	/**
	 *  tells you if the stack is empty.
	 *  @return internalList.isEmpty() the method isEmpty() from attachedList.
	 */
	@Override
	public boolean isEmpty()
	{

		return internalList.isEmpty();
	}


	/**
	 *  clears the stack.
	 */

	@Override
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
		boolean first = true;
		for(Plate p : internalList) {
			if(first) { returnString = returnString+p; first = false; }
			else {returnString = returnString+"|"+p; }
		}
		return returnString;
	}
}
