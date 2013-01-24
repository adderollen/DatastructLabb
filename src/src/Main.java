
public class Main {

	public static void main(String[] args) {
		Uppg1a a = new Uppg1a();
		
		System.out.println(a.empty());
		System.out.println(a.toString());
		
		for(int i = 0; i < 13; i++) {
			a.addFirst("" + i);
		}
		System.out.println(a.empty());
		System.out.println(a.toString());
		System.out.println(a.existP("12"));
		
		a.removeFirst();
		
		System.out.println(a.toString());
		System.out.println(a.existP("12"));
	}
	
}
