package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry {
	private Point3D center;
	private double radius;

	public Sphere(Point3D center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	/**
	 * A function that calculates the center point of the sphere and the radius of the sphere
	 */

	@Override
	public String toString() {
		return "Sphere [center=" + center + ", radius=" + radius + "]";
	}

	@Override
	public Vector getNormal(Point3D point) {
		return point.subtract(center).normalize();
	}

	public Point3D getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}
}
