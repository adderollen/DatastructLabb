/**
 * Tests Uppgift 1 and 2.  
 * @author Robin Hammaräng
 * @author Andreas Rolén
 * @group 35
 */
public class Main {

	public static void main(String[] args) {
		
		//Three various test for Uppg2. 
		//1 and 2 are normal calculations
		//3 is with a high eps.
		double sqr = 16; 
		double eps = Math.pow(10, -6);
		System.out.println("Math.sqrt = " + Math.sqrt(sqr));
		System.out.println("Binarysqrt = " + Uppg2.binarySqrt(sqr, eps));		
		
		double sqr2 = 45.61;
		double eps2 = Math.pow(10, -6);
		System.out.println("Math.sqrt = " + Math.sqrt(sqr2));
		System.out.println("Binarysqrt = " + Uppg2.binarySqrt(sqr2, eps2));		
		
		double sqr3 = 9784;
		double eps3 = 1000;
		System.out.println("Math.sqrt = " + Math.sqrt(sqr3));
		System.out.println("Binarysqrt = " + Uppg2.binarySqrt(sqr3, eps3));
		
		//Try calculating the root of a negative sqr.
		try{ 
			Uppg2.binarySqrt(-1, 10000);
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		//Try using a negative eps. 
		try{
			Uppg2.binarySqrt(1, -1);
		} catch (NumberFormatException e){
			e.printStackTrace();
		}
		
		//Various tests for Uppg1.
		Uppg1 a = new Uppg1();
		
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
