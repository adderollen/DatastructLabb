/**
 * A class that calculates the square root of a given number. 
 * @author Robin Hammaräng
 * @author Andreas Rolén
 * @group 35
 */

public class Uppg2 {

	/**
	 * binarySqrt returns the square root of the given sqr with precision eps.
	 * @param sqr >= 1
	 * @throws NumberFormatException if sqr < 1
	 * @param eps > 0
	 * @throws NumberFormatException if eps < 0
	 * @return Root
	 */
	public static double binarySqrt(double sqr, double eps) {
		if(sqr < 1){
			throw new NumberFormatException("sqr must be >= than 1.");
		} else if( eps <= 0){
			throw new NumberFormatException("eps must be > than 0.");
		} else {
			return help(sqr, eps, 1, sqr); 
		}
	}
	
	
	/**
	 * Help function for binarySqrt to actually do the calculations.
	 * @param lowerLimit, upperLimit: the square root is between these two numbers
	 * @param sqr, number to calculate square root from.
	 * @param eps, error margin.
	 * @return the square root of the given sqr.
	 */
	private static double help(double sqr, double eps, double low, double high){
		double mid = (high + low) / 2; //Value in the middle of low and high. 
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
