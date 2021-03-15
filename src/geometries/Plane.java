package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry {
	private Point3D q0;
	private Vector normal;

	public Plane(Point3D q0, Vector normal) {
		this.q0 = q0;
		this.normal = normal.normalized();
	}

	public Plane(Point3D p1, Point3D p2, Point3D p3) {
	        // if p1=p2 or p1=p3 - an exception will be thrown
	        Vector v1 = p1.subtract(p2);
	        Vector v2 = p1.subtract(p3);

	        // if the points are in the same line - X-product will throw an exception
	        normal = v1.crossProduct(v2).normalize();
	        q0 = p1;
	    }


	public Point3D getQ0() {
		return q0;
	}

	public Vector getNormal() {
		return normal;
	}

	@Override
	public String toString() {
		return "Plane [q0=" + q0 + ", normal=" + normal + "]";
	}
	
	@Override
	public Vector getNormal(Point3D point) {
		return normal;
	}

}
