
public class Main {

	public static void main(String[] args) {
		double sqr = 10000;
		double eps = Math.pow(10, -6);
		System.out.println("Math.sqrt = " + Math.sqrt(sqr));
		System.out.println("Binarysqrt = " + Uppg2.binarySqrt(sqr, eps));
		
		/*Uppg1a a = new Uppg1a();
		
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
		System.out.println(a.existP("12"));*/
	}
	
}
