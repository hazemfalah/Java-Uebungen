package java_36_h09;


/**
 * 
 * @author Philipp Luhr
 * @author Hazem Falah
 * @author Nils Neumann
 * 
 *   represents a vector and some calculation rules (points are also vectors
 */
public class Vector {

	// Attribute
	private double x;
	private double y;

	/**
	 * generate a Vector
	 * 
	 * @param x
	 * @param y
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @return return the x component
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * @return the y component
	 */
	public double getY() {
		return y;
	}

	/**
	 * return the difference of 2 vectors (if we interpret a point as a vector, then
	 * this method return the vector defined from 2 points)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Vector substractVector(Vector a, Vector b) {
		return new Vector(b.getX() - a.getX(), b.getY() - a.getY());
	}

	/**
	 *  add 2 vectors or 2 points
	 * @param a
	 * @param b
	 * @return
	 */
	public static Vector addVector(Vector a, Vector b) {
		return new Vector(b.getX() + a.getX(), a.getY() + b.getY());
	}


	/**
	 * multiply the Vector with alpha
	 * @return the multiplication of the vector with alpha
	 */
	public Vector vectorHomoticie(double alpha) {
		Vector hom = new Vector(this.x * alpha, this.y * alpha);
		return hom;
	}

	/**
	 * rotate the vector with the angle "angle"
	 * @param angle
	 * @return the vector after the rotation
	 */
	public Vector vecRotation(double angle) {
		double a = this.x * Math.cos(angle) - this.y * Math.sin(angle);
		double b = this.x * Math.sin(angle) + this.y * Math.cos(angle);
		Vector vec = new Vector(a, b);
		return vec;
	}

	/**
	 * return the coordinates of a vector in the mathematics-form
	 */
	public String toString() {
		return String.format("(%.1f/%.1f)", this.x, this.y);
	}

}
