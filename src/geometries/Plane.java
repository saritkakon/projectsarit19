package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane implements Geometry {
	private Point3D q0;
	private Vector normal;

	public Plane(Point3D q0, Vector normal) {
		this.q0 = q0;
		this.normal = normal.normalized();
	}
	/**
	 * constructor receiving normalized vector and point
	 * @param p1
	 * @param p2
	 * @param p3
	 */

	public Plane(Point3D p1, Point3D p2, Point3D p3) {
	        // if p1=p2 or p1=p3 - an exception will be thrown
	        Vector v1 = p1.subtract(p2);
	        Vector v2 = p1.subtract(p3);

	        // if the points are in the same line - X-product will throw an exception
	        normal = v1.crossProduct(v2).normalize();
	        q0 = p1;
	    }
	/**
	 * constructor receiving three points
	 * @return
	 */


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
	@Override
	public List<Point3D> findIntsersections(Ray ray) {
		// -N
        Vector revN = normal.scale(-1);

        // (P0 - Q0)
        Vector P0Q0 = ray.getP0().subtract(this.q0);

        // (N*V)
        double NV = normal.dotProduct(ray.getDir());

        // (P0 - Q0)/(N*V)
        Vector P0Q0_NV = P0Q0.scale(1/NV);

        // t = - N*(P0 - Q0)/(N*V)
        double t = revN.dotProduct(P0Q0_NV);

        if(t > 0)
            // P = P0 + tV
            return List.of(ray.getPoint(t));

        return null;

	}

}
