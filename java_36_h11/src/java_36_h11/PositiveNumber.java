package java_36_h11;

/**
 * 
 * @author Hazem Falah
 * @author Philipp Luhr
 * @author Nils Neumann
 * 
 *         Represents a class that save numbers given in different forms
 */
public class PositiveNumber {

	private int value = 0;
	final String intMaxValue = "2147483647";

	/**
	 * control if  the number is out of range
	 * @param s
	 * @return true if the number is out of range and false if not
	 * 
	 */
	private boolean isOutOfrangeDecimal(String s) {
		boolean b = false;
		if((s.charAt(0)+"").equals("-"))
		{
			b=true;
		}
		else if (s.length() > intMaxValue.length()) {
			b = true;
		} else if (s.length() == intMaxValue.length()) {
			int i = 0;
			while (!b && i < s.length()) {
				if ((int) s.charAt(i) > (int) intMaxValue.charAt(i)) {
					b = true;
				}
				i++;
			}
		}
		return b;
	}

	/**
	 * set the given number as a String in a decimal form  
	 * @param s the String with the decimal number
	 */
	public void setDecimal(String s) {
		if (isOutOfrangeDecimal(s)) {
			throw new ArithmeticException("number out of Range");
		} else {
			int number = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				if ((int) s.charAt(i) < 48 && (int) s.charAt(i) > 57)
					throw new NumberFormatException("invalid decimal format");
				else {
					number += Math.pow(10, s.length() - 1 - i) * ((int) s.charAt(i) - 48);
				}
			}
			this.value = number;
		}
	}

	/**
	 * set the number given as a String in the hexadecimal form
	 * @param s the String with the number in hexadecimal form 
	 */
	public void setHexadecimal(String s) {
		if (s.length() > 8) {
			throw new ArithmeticException("number out of range");
		} else {
			s = s.toUpperCase();
			int number = 0;
			String hex = "ABCDEF";
			for (int i = s.length() - 1; i >= 0; i--) {
				if ((int) s.charAt(i) < 48 && (int) s.charAt(i) > 57 && hex.indexOf((s.charAt(i) + "")) == -1) {
					throw new NumberFormatException("invalid hexadecimal format");
				} else if (hex.indexOf(s.charAt(i) + "") != -1) {
					number += Math.pow(16, s.length() - 1 - i) * (10 + hex.indexOf(s.charAt(i) + ""));
				} else {
					number += Math.pow(16, s.length() - 1 - i) * ((int) s.charAt(i) - 48);
				}
			}
			this.value = number;
		}
	}

	/**
	 * set the number given as a String in the binary form
	 * @param s the String with the number in binary form
	 */
	public void setBinary(String s) {
		if (s.length() > 32) {

			throw new ArithmeticException("number out of range");
		} else {
			int number = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				if ((s.charAt(i) + "").equals("1") || (s.charAt(i) + "").equals("0"))
					number += Math.pow(2, s.length() - 1 - i) * (((int) s.charAt(i)) % 2);
				else {
					throw new NumberFormatException("invald binary format");
				}
			}
			this.value = number;
		}
	}

	/**
	 * 
	 * @return  the number as a String in the decimal form
	 */
	public String getDecimal() {
		return this.value + "";
	}

	/**
	 * 
	 * @return the number as a string in the binary form
	 */
	public String getBinary() {
		StringBuilder s = new StringBuilder();
		int a = this.value;
		while (a > 0) {
			s.append(a % 2);
			a /= 2;
		}
		s.reverse();
		return s.toString();
	}

	/**
	 * 
	 * @return the number as a string in the hexadecimal form
	 */
	public String getHexadecimal() {
		StringBuilder s = new StringBuilder();
		int a = this.value;
		String hex = "ABCDEF";
		while (a > 0) {
			if (a % 16 < 10) {
				s.append(a % 16);
			} else {
				s.append(hex.charAt((a % 16) - 10));
			}
			a /= 16;
		}
		s.reverse();
		return s.toString();
	}
}
