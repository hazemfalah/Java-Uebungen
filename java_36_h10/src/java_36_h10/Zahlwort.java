package java_36_h10;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 
 * @author Philipp Luhr
 * @author Hazem Falah
 * @author Nils Neumann
 * 
 *         Represents a class that writes numbers between 0 and 9999 in words ( in German language)
 */
public class Zahlwort {

	/**
	 * write a given number 'x' in words
	 * @param x
	 * @return the number 'x' in words
	 */
	public static String getZahlwort(int x) {

		final String[] zahl_0 = { "null", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neuen",
				"zehn", "elf", "zwoelf" };
		final String[] zahl_10 = { "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechzig", "siebzig", "achtzig",
				"neuenzig" };
		String s = "";
		if (x <= 12) { // if x between 1 and 12
			s = zahl_0[x];
			if (x == 1) {
				s = s + "s";
			}
		} else if ((x / 10) < 10) { // if x is between 13 and 99
			if (x % 10 == 0) {
				s = zahl_10[x / 10 - 2];
			} else {
				s = s + zahl_0[x % 10];
				if (x / 10 == 1) {
					if (x % 10 == 6) {
						s = s.substring(0, s.length() - 1);
					}
					s += "zehn";
				} else {
					s += "und" + zahl_10[x / 10 - 2];
				}
			}
		} else if (x / 100 < 10) { // if x between 100 and 999
			s = zahl_0[x / 100] + "hundert";
			if (x % 100 != 0) {
				s = zahl_0[x / 100] + "hundert" + getZahlwort(x % 100);
			}
		} else if (x / 1000 < 10) { // if x between 1000 and 9999
			s = zahl_0[x / 1000] + "tausend";
			if (x % 1000 != 0) {
				s = zahl_0[x / 1000] + "tausend" + getZahlwort(x % 1000);
			}
		}

		else {
			throw new ArithmeticException("expecting a number smaller than 10 000 but recieved " + x);
		}
		return s;
	}

	/**
	 * 
	 * @param start
	 * @param stop
	 * @return a stream with the numbers between start(inclusive) and stop(inclusive) in words
	 */
	public static Stream<String> getZahlStream(int start, int stop) {
		ArrayList<String> list = new ArrayList<>();
		IntStream.rangeClosed(start, stop).forEach((int i) -> list.add(getZahlwort(i)));
		return list.stream();
	}

}
