package java_36_h09;

/**
 * 
 * @author Philipp Luhr
 * @author Hazem Falah
 * @author Nils Neumann
 * 
 *         Represents the coordinates of the points  Koch snowflake
 */
public class KochKurve {

	/**
	 * every graph contains 4 parts, every part is similar to the previous graph. from the first step appears 5 points, which are fix in all next graphs.
	 * in the every graph, we see that between these points we have the previous graph. we become the vertex of the triangle, by the rotation of the middle one-third of the line between the 
	 * 2 start points with an angle of 60 degree  
	 * 
	 * @param ax the x coordinate of the first point
	 * @param ay the y coordinate of the first point
	 * @param bx the x coordinate of the second point
	 * @param by the y coordinate of the second point
	 * @param rek the number of step to do
	 */
	public static void kochKurve(double ax, double ay, double bx, double by, int rek) {
        
		
		Vector a = new Vector(ax, ay);
		Vector e = new Vector(bx, by);
		if (rek == 0) {
			System.out.print(a + " ");
		} else {
			
			//the coordinates of the other 3 fix points 
			Vector b = Vector.addVector(a, Vector.substractVector(a, e).vectorHomoticie(1. / 3));
			Vector d = Vector.addVector(a, Vector.substractVector(a, e).vectorHomoticie(2. / 3));
			Vector c = Vector.addVector(Vector.substractVector(b, d).vecRotation(-Math.PI / 3), b);//Rotation of the vector bd with angle 60 degree
			                                                                                       //to have the same numbers as the example we should do a rotation in the negative direction
			kochKurve(a.getX(), a.getY(), b.getX(), b.getY(), rek - 1);
			kochKurve(b.getX(), b.getY(), c.getX(), c.getY(), rek - 1);
			kochKurve(c.getX(), c.getY(), d.getX(), d.getY(), rek - 1);
			kochKurve(d.getX(), d.getY(), e.getX(), e.getY(), rek - 1);
		}
	}

	public static void main(String[] args) {

		kochKurve(0, 500, 500, 500, 2);
		System.out.print(new Vector(500,500));
	}
}
