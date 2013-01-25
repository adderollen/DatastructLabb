import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A class to handle elements in a list.  
 * 
 * @author Andreas Rolen, Robin Hammarang  (Group XX)
 * 
 */
//TODO Javadoc this better!
public class Uppg1 {

	private String[] stringArr;
	private int pos;

	/**
	 * Creates a list of element and set P to the first position.
	 * 
	 * @param size
	 *            The size of the list.
	 */
	public Uppg1(int size) {
		stringArr = new String[size];
		pos = 0;
	}

	/**
	 * Creates a list of element with a size of 10 and set P to the first
	 * position.
	 */
	public Uppg1() {
		stringArr = new String[10];
		pos = 0;
	}

	/**
	 * Adds an element in the first position. Also increase the size of the list
	 * if the list is full.
	 * 
	 * @param elem
	 *            The element that will be added.
	 */
	public void addFirst(String elem) {
		if (empty()) {
			stringArr[0] = elem;
		} else {
			String tmpArr[];
			if (stringArr[stringArr.length - 1] == null) {
				tmpArr = Arrays.copyOf(stringArr, stringArr.length);
			} else {
				tmpArr = Arrays.copyOf(stringArr, stringArr.length + 1);
				pos++;
			}
			for (int i = tmpArr.length - 1; i > 0; i--) {
				tmpArr[i] = tmpArr[i - 1];
			}
			stringArr = tmpArr;
			stringArr[0] = elem;
		}
	}

	/**
	 * Checks if the list is empty.
	 * 
	 * @return True if empty, False if the list contains one element or more.
	 */
	public boolean empty() {
		for (int i = 0; i < stringArr.length; i++) {
			if (stringArr[i] != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the first element in the list, if it exists.
	 * 
	 * @return The first element.
	 */
	public String getFirst() throws NoSuchElementException {
		if (empty()) {														// Should this method return the element at the
			System.out.println("The list is empty, no element to return");	// first position in the list, or the first
			throw new NoSuchElementException();								// element in the list that exists?
		}																	// Does alternative two at the moment.
		int i;
		for (i = 0; i < stringArr.length; i++) {
			if (stringArr[i] != null) {
				break;
			}
		}
		return stringArr[i];
	}

	/**
	 * Removes the first element in the list, if it exists.
	 */
	public void removeFirst() { 
		if (!empty()) {														// Should this method remove the element at the
			for (int i = 0; i < stringArr.length - 1; i++) {				// first position in the list, or the first
				stringArr[i] = stringArr[i + 1];							// element in the list that exists?
			}																// Does alternative one at the moment.
			String tmpArr[] = Arrays.copyOf(stringArr, stringArr.length - 1);
			stringArr = tmpArr;
			if (pos != 0) {
				pos--;
			}
		}
	}

	/**
	 * Helpmethod that checks if a given element exists and return it's index.
	 * 
	 * @param elem
	 *            The element that will be searched for.
	 * @return The index of the searched element if it exists. If it doesn't
	 *         exist the method returns -1.
	 */
	private int exist(String elem) {
		if (!empty()) {
			for (int i = 0; i < stringArr.length; i++) {
				if (stringArr[i].equals(elem)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Checks if a given element exists.
	 * 
	 * @param elem
	 *            The element that will be searched for.
	 * @return If the element exists or not.
	 */
	public boolean existP(String elem) {
		if (exist(elem) >= 0) {
			return true;
		}
		return false;

	}

	/**
	 * Checks if a given element exists. If the element exists, P will be set to
	 * it's position.
	 * 
	 * @param elem
	 *            The element that will be searched for.
	 * @return If the element exists or not.
	 */
	public boolean existPset(String elem) {
		int tmp = exist(elem);
		if (tmp >= 0) {
			setP(tmp);
			return true;
		}
		return false;
	}

	/**
	 * Sets P to a given index.
	 * 
	 * @param p
	 *            The index that P will be set to.
	 */
	public void setP(int p) {
		if (p < stringArr.length && p >= 0) {
			pos = p;
		} else {
			System.out.println("The value is not valid!");
		}
	}

	/**
	 * Checks if there is an element at P:s position.
	 * 
	 * @return If there is an element at P:s position.
	 */
	public boolean hasNext() {
		try {
			if (stringArr[pos] != null) {
				return true;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("P:s position is not inside the list"); // Should not occur
		}
		return false;
	}

	/**
	 * Adds an element at a given index.
	 * 
	 * @param index
	 *            The index where the element will be added.
	 * @param elem
	 *            The element that will be added.
	 */
	public void addAfterP(int index, String elem) {
		setP(index);
		if (hasNext()) {
			stringArr[pos] = elem;
		}
	}

	/**
	 * Gets the element at P:s position.
	 * 
	 * @param p
	 *            The position to get element from.
	 * @return The element at P:s postion.
	 */
	public String getP(int p) {
		setP(p);
		if (hasNext()) {
			return stringArr[pos];
		} else {
			System.out.println("No element to return");
		}
		return null;
	}

	/**
	 * Moves P a given count of steps.
	 * 
	 * @param val
	 *            The value of steps to move P.
	 */
	public void moveP(int val) {
		setP(pos + val);
	}

	/**
	 * Prints the list of elements.
	 */
	@Override
	public String toString() {
		StringBuilder sBuild = new StringBuilder();

		for (int i = 0; i < stringArr.length; i++) {
			sBuild.append(", " + stringArr[i]);
		}

		sBuild.delete(0, 1);
		String s = sBuild.toString();

		return "[ " + s + " ]";
	}
}
