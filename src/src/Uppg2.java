import java.util.*;

public class Uppg2 {
	
	/*
	 * J�vligt oklart vad den h�r funktionen faktiskt ska g�ra. 
	 * "BinarySqrt's uppgift �r bara att g�ra rimlighetskontroll av indata och anropa den interna
	 *	rekursiva hj�lpfunktionen" st�r det i Labb-PM.
	 */
	public static double binarySqrt(double sqr, double eps) {
		double result = 0;
		if(sqr < 1){
			throw new NumberFormatException("Sqr must be >= than 1.");
		} else {
			result = help(sqr, eps, 1, sqr); //The root is somewhere between 1 and sqr. (lower / upper limit).
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
	private static double help(double sqr, double eps, double low, double high){
		double mid = (high + low) / 2; //Value in the middle of lowerLimit and upperLimit. 
		double result = mid * mid;
		if((Math.abs(result-sqr)) < eps){
			return mid;
		} else {
			if (result < sqr){
				low = mid;
			} else {
				high = mid;
			}
			return help(sqr, eps, low, high);
		}
	}
}
