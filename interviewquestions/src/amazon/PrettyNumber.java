package amazon;

import java.text.DecimalFormat;

/**
 * This class has method to convert numbers to pretty format.
 * 
 * @author Watsh Rajneesh
 * 
 */
public class PrettyNumber {
	private static final double ONE_GB = 1.0 * 1000 * 1000 * 1000;
	private static final double ONE_MB = 1.0 * 1000 * 1000;
	private static final double ONE_KB = 1.0 * 1000;

	/**
	 * A method which converts an Integer representing a number of bytes (less
	 * than or equal to 1 Gigabyte) into an easy to read format.
	 * 
	 * Assumption: Number is positive only.
	 * 
	 * Time complexity: Best case if input is 1GB, worst case if it is less than 1K.
	 * O(1) in both cases.
	 * 
	 * 
	 * @param inputNumber
	 * @return
	 */
	public static String convertToPrettyNumber(int inputNumber) {
		DecimalFormat decimalFormat = null;
		String prettyNumber = null;

		double divByOneGB = inputNumber / ONE_GB;
		if (divByOneGB < 1) {
			double divByOneMB = inputNumber / ONE_MB;
			if (divByOneMB < 1) {
				double divByOneKB = inputNumber / ONE_KB;
				if (divByOneKB < 1) {
					decimalFormat = new DecimalFormat("###B");
					prettyNumber = decimalFormat.format(inputNumber);
				} else {
					if (divByOneKB < 10) {
						decimalFormat = new DecimalFormat("###.##K");
					} else {
						decimalFormat = new DecimalFormat("###.#K");
					}
					prettyNumber = decimalFormat.format(inputNumber / ONE_KB);
				}
			} else {
				if (divByOneMB < 10) {
					decimalFormat = new DecimalFormat("###.##M");
				} else {
					decimalFormat = new DecimalFormat("###.#M");
				}
				prettyNumber = decimalFormat.format(inputNumber / ONE_MB);
			}
		} else {
			if (divByOneGB < 10) {
				decimalFormat = new DecimalFormat("###.##G");
			} else {
				decimalFormat = new DecimalFormat("###.#G");
			}
			prettyNumber = decimalFormat.format(inputNumber / ONE_GB);
		}
		System.out.println(inputNumber + " --> " + prettyNumber);
		return prettyNumber;
	}
}
