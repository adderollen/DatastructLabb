import java.util.*;

public class Uppg2 {
	
	/*
	 * Jävligt oklart vad den här funktionen faktiskt ska göra. 
	 * "BinarySqrt's uppgift är bara att göra rimlighetskontroll av indata och anropa den interna
	 *	rekursiva hjälpfunktionen" står det i Labb-PM.
	 */
	public static double binarySqrt(double sqr, double eps) {
		double result = 0;
		if(sqr < 1){
			throw new NumberFormatException("Sqr must be >= than 1.");
		} else {
			result = doSqrt(1, sqr, sqr, eps); //The root is somewhere between 1 and sqr. (lower / upper limit).
		}
		return result;
	}
	
	
	/**
	 * Help function for binarySqrt 
	 * to actually do the calculations.
	 * @param lowerLimit, upperLimit: the square root is between these two numbers
	 * @param sqr, number to calculate square root from.
	 * @param eps, error margin.
	 * @return the square root of the given sqr.
	 */
	private static double doSqrt(double lowerLimit, double upperLimit, double sqr, double eps){
		double mid = (upperLimit + lowerLimit) / 2; //Value in the middle of lowerLimit and upperLimit. 
		double ret = mid; //Return value
		double result = mid * mid;
		System.out.println("Mid = " + mid);
		System.out.println("Res = " + result);
		if (result < (sqr - eps)) { //if the root is lower than the current mid value.
			System.out.println("Over");
			ret = doSqrt(mid,sqr, sqr, eps);
		} else if (result > (sqr + eps)){
			System.out.println("Under"); //if the root is higher than the current mid value.
			ret = doSqrt(1, mid, sqr, eps);
		} 
		return ret;
	}
	
	
	
	
	private static double help(double sqr, double eps, double low, double high){
				
		
		return sqr;
	}
}
