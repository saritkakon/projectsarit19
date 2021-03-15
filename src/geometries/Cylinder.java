package geometries;

import primitives.Ray;

public class Cylinder extends Tube {
	private double height;
	@Override
	public String toString() {
		return "Cylinder [height=" + height + "]";
	}
	/**
	 *  function that returns the height of the cylinder
	 * @param axicRay
	 * @param radius
	 * @param height
	 */
	public Cylinder(Ray axicRay, double radius, double height) {
		super(axicRay, radius);
		this.height = height;
	}
	public double getHeight() {
		return height;
		/**
		 * function that returns the height of the cylinder
		 */
	}
}
