package java_36_h05;

/**
 * 
 * @author Hazem Falah
 * @author Philipp Luhr 
 * @author Nils Neumann 
 *
 */
public class DasSpiel {
	public static void main(String[] args) {
		// Neues Objekt vom Typ GefangenenDilemma mit 2 Spielern
		GefangenenDilemma gd = new GefangenenDilemma(new Random(), new PerKind());
		// 100 mal spielen
		gd.spiele(100);

	    gd = new GefangenenDilemma(new Gradual(), new PerKind());
		gd.spiele(100);

		gd = new GefangenenDilemma(new TitForTat(), new PerKind());
		gd.spiele(100);

		gd = new GefangenenDilemma(new Spite(), new PerKind());
		gd.spiele(100);
	}
}
