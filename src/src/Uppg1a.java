import java.util.Arrays;

public class Uppg1a {

	private String[] stringArr;

	public Uppg1a(int size) {
		stringArr = new String[size];
	}

	public Uppg1a() {
		stringArr = new String[10];
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
			for(int i = 0; i < stringArr.length - 1; i++) {
				stringArr[i] = stringArr[i+1];
			}
			String tmpArr[] = Arrays.copyOf(stringArr, stringArr.length - 1);
			stringArr = tmpArr;
		}
	}
	
	public boolean existP(String elem) {
		if(!empty()) {
			for(int i = 0; i < stringArr.length; i++) {
				if(stringArr[i].equals(elem)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sBuild = new StringBuilder();
		
		for(int i = 0; i < stringArr.length; i++) {
			sBuild.append(", " + stringArr[i]);
		}
		
		sBuild.delete(0, 1);
		String s = sBuild.toString();
		
		return "[ " + s + " ]";
	}
}
