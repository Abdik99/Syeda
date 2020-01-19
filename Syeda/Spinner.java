import java.util.NoSuchElementException;
/**
 *  Sets up the Syeda.
 * 
 *  @author Abdikarim Abdirahman
 * 
 */
public class Spinner {

	/**
	 *  The hands of Syeda.
	 * 
	 *  @author Abdikarim Abdirahman
	 * 
	 */
	private static class Hand {
		/**
		 *  The Plate we are using .
		 */
		Plate clean = null;

		/**
		 *  Catches the plates.
		 *  @param plate the plate you catch.
		 */
		public void catchPlate(Plate plate) {
			if (hasPlate())
			{
				throw new RuntimeException("Catching hand not empty");
			}

			if (plate==null)
			{

				throw new RuntimeException("Can't catch a plate that doesn't exist!");
			}
			else
			{
				clean=plate;
			}
		}

		/**
		 *  Toss the plates.
		 *  @return toss retuns the plate you toss.
		 */

		public Plate tossPlate() {

			Plate toss=clean;
			if (!hasPlate())
			{
				throw new RuntimeException ("Tossing hand was empty");
			}
			else
			{
				clean=null;
			}

			return toss;

		}

		/**
		 *  Checks if you have a plate.
		 *  @return bool.
		 */

		public boolean hasPlate() {
			boolean bool=false;
			if (clean!=null)
			{

				bool=true;
			} 
			return bool;

		}

		/**
		 *  returns the plate string value.
		 *  @return word returns the string value.
		 */

		public String toString() {
			String word=null;
			if (clean==null)
			{
				word= "   ";
			}

			else
			{
				word= clean.toString();
			}

			return word;
		}
	}

	/**
	 *  passes the plate from hand 2 to hand 1.
	 */
	public void passPlate() {


		hands[0].catchPlate(hands[1].tossPlate());

	}

	/**
	 *  puts the plate in the bin.
	 */

	public void putDownPlate() {
		bin.push(hands[0].tossPlate());


	}

	/**
	 *  takes the plate out the bin.
	 */
	public void pickUpPlate() {

		if (bin.isEmpty())
		{
			throw new RuntimeException("Can't pickup a plate that doesn't exist!");
		}

		else
		{
			hands[0].catchPlate(bin.pop());
		}

	}

	/**
	 *  puts the plate in the air.
	 */

	public void spinPlate() {

		boolean bool=air.enqueue(hands[0].clean);
		if (!bool)
		{
			throw new RuntimeException("Too many plates in the air!");

		}

		hands[0].tossPlate();

	}


	/**
	 *  takes the plate out the air.
	 */
	public void catchPlate() {

		if (air.isEmpty())
		{
			throw new RuntimeException("Can't catch a plate that doesn't exist!");
		}

		else
		{
			hands[1].clean=air.dequeue();
		}

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
	 *  main method.
	 *  @param args main method
	 */

	private final Air air = new Air();
	/**
	 *  main method.
	 *  @param args main method
	 */

	private final Bin bin = new Bin();

	/**
	 *  main method.
	 *  @param args main method
	 */

	private final Hand[] hands = new Hand[2];

	//spinners have two hands and starts with a bin full of plates

	/**
	 *  Spinner.
	 *  @param totalPlates total plates.
	 */
	public Spinner(int totalPlates) {
		hands[0] = new Hand();
		hands[1] = new Hand();

		for(int i = totalPlates; i > 0; i--) {
			this.bin.push(new Plate(i));
		}
	}


	//this does the beautiful ascii art :)
	/**
	 *  toString().
	 *  @return sb.toString()
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		String[] personParts = {
			"   "+air.toString()+"\n",
			"\n",
			"    "+hands[0].toString()+"( )"+hands[1].toString()+"\n",
			"     \\__|__/\n",
			"        |\n",
			"        |\n",
			"       / \\\n",
			"      /   \\\n"
		};
		
		String[] stackParts = this.bin.toString().split("[|]");
		
		int total = (this.bin.size() < personParts.length) ? personParts.length : this.bin.size();
		for(int i = total; i >= 0; i--) {
			sb.append((this.bin.size()-1 < i) ? "   " : stackParts[stackParts.length-i-1]);
			if(i < personParts.length) {
				sb.append(personParts[personParts.length-i-1]);
			}
			else {
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
}
