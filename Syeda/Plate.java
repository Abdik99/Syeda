// --------------------------------------------------------
// DO NOT EDIT ANYTHING BELOW THIS LINE (except to add JavaDocs)
// --------------------------------------------------------
/**
 *  Plate Class.
 *  @author Abdikarim Abdirahman
 * 
 */
public class Plate {
	
	/**
	 * number variable. 
	 */
	private int number;
	
	
	/**
	 *  constructor.
	 *  @param number takes in a number.
	 */
	public Plate(int number) {
		this.number = number;
	}
	
	
	
	/**
	 *  to String.
	 *  @return "("+((char)(this.number+96))+")".
	 */
	
	public String toString() {
		return "("+((char)(this.number+96))+")";
	}
	
	
	/**
	 *  getNumber.
	 *  @return this.number.
	 */
	public int getNumber() {
		return this.number;
	}
}
