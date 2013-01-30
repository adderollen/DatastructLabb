/**
 * A class to handle elements in a list.
 * 
 * @author Andreas Rolen, Robin Hammarang (Group 35)
 * 
 */
// TODO Javadoc this better!
public class Uppg1 {

	private String[] stringArr;
	private int pos;
	private int size;
	private int capacity;
	private static final int INITIAL_CAPACITY = 10;

	/**
	 * Creates a list of element and set P to the first position.
	 * 
	 * @param capacity
	 *            The size of the list.
	 */
	public Uppg1(int capacity) {
		stringArr = new String[capacity];
		this.capacity = capacity;
		pos = 0;
	}

	/**
	 * Creates a list of element with a size of 10 and set P to the first
	 * position.
	 */
	public Uppg1() {
		this(INITIAL_CAPACITY);
	}

	/**
	 * Adds an element in the first position.
	 * 
	 * @param elem
	 *            The element that will be added.
	 */
	public void addFirst(String elem) {
		if (empty()) {
			stringArr[0] = elem;
		} else {
			if (size == capacity) {
				reallocate();
			}
			String tmpArr[] = new String[capacity];
			tmpArr[0] = elem;
			for (int i = 0; i < size; i++) {
				tmpArr[i + 1] = stringArr[i];
			}
			stringArr = tmpArr;

		}
		size++;
	}

	private void reallocate() {
		capacity = 2 * capacity;
		String[] tmpArr = new String[capacity];
		for (int i = 0; i < size; i++) {
			tmpArr[i] = stringArr[i];
		}
		stringArr = tmpArr;
	}

	/**
	 * Checks if the list is empty.
	 * 
	 * @return True if empty, False if the list contains one element or more.
	 */
	public boolean empty() {
		return (size == 0);
	}

	/**
	 * Gets the first element in the list.
	 * 
	 * @return The first element.
	 */
	public String getFirst() {
		return stringArr[0];
	}

	/**
	 * Removes the first element in the list, if it exists.
	 */
	public void removeFirst() {
		if (!empty()) {
			for (int i = 0; i < stringArr.length - 1; i++) {
				stringArr[i] = stringArr[i + 1];
			}
			size--;
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
			for (int i = 0; i < size; i++) {
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
		if (p <= size) {
			pos = p;
		} else {
			throw new IndexOutOfBoundsException("Not a valid position");
		}
	}

	/**
	 * Checks if there is an element at P:s position.
	 * 
	 * @return If there is an element at P:s position.
	 */
	public boolean hasNext() {
		return (pos <= size);
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
		if (size == capacity) {
			reallocate();
		}
		String[] tmpArr = new String[capacity];
		tmpArr[index] = elem;
		for (int i = index; i < size; i++) {
			tmpArr[i + 1] = stringArr[i];
		}
		size++;
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
		return stringArr[p];
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

		for (int i = 0; i < size; i++) {
			sBuild.append(", " + stringArr[i]);
		}

		sBuild.delete(0, 1);
		String s = sBuild.toString();

		return "[ " + s + " ]";
	}
}
