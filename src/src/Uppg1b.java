import java.util.Arrays;

public class Uppg1b {

	private String[] stringArr;
	private int pos;

	public Uppg1b(int size) {
		stringArr = new String[size];
		pos = 0;
	}

	public Uppg1b() {
		stringArr = new String[10];
		pos = 0;
	}

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

	public boolean empty() {
		for (int i = 0; i < stringArr.length; i++) {
			if (stringArr[i] != null) {
				return false;
			}
		}
		return true;
	}

	public String getFirst() {
		return stringArr[0];
	}

	public void removeFirst() {
		if (!empty()) {
			for (int i = 0; i < stringArr.length - 1; i++) {
				stringArr[i] = stringArr[i + 1];
			}
			String tmpArr[] = Arrays.copyOf(stringArr, stringArr.length - 1);
			stringArr = tmpArr;
			pos--;
		}
	}

	public boolean existP(String elem) {
		if (!empty()) {
			for (int i = 0; i < stringArr.length; i++) {
				if (stringArr[i].equals(elem)) {
					return true;
				}
			}
		}
		return false;
	}

	public void setP(int p) {
		if (p < stringArr.length && p >= 0) {
			pos = p;
		}
	}
	
	public boolean hasNext() {
		try {
		if(stringArr[pos] != null) {
			return true;
		}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("P:s position is not inside the list");  //Should not occur
		}
		return false;
	}
	
	public void addAfterP(int index, String elem) {
		setP(index);
		if(hasNext()) {
			stringArr[pos] = elem;
		}
	}
	
	public String getP(int p) {
		setP(p);
		if(hasNext()) {
			return stringArr[pos];
		}
		return null;
	}
	
	public void moveP(int val) {
		
	}

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
