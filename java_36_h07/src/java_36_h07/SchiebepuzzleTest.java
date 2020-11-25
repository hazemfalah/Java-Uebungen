package java_36_h07;

public class SchiebepuzzleTest {

	public static void main(String[] args) {
		Schiebepuzzle puzzle = new Schiebepuzzle();
		// Mischen nicht vergessen, ansonsten hat der Spieler sehr schnell gewonnen
		puzzle.mische();
		// Testen des Loesungsalgorithmus
		// -> zufaellig schieben
		Loesungsalgorithmus alg1 = new SchiebAlg1();
		System.out.println(puzzle);
		alg1.loese(puzzle);
		System.out.println(puzzle);
	}
	
}
