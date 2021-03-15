package geometries;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
public class Tube implements Geometry {
private Ray axicRay;
private double radius;
public Ray getAxicRay() {
	return axicRay;
	/**
	 * 
	 */
}
public double getRadius() {
	return radius;
}
@Override
public String toString() {
	return "Tube [axicRay=" + axicRay + ", radius=" + radius + "]";
}
public Tube(Ray axicRay, double radius) {
	super();
	this.axicRay = axicRay;
	this.radius = radius;
}
@Override
public Vector getNormal(Point3D point) {
	Vector v = axicRay.getDir();
	Point3D P0 = axicRay.getP0();
	double t = v.dotProduct(point.subtract(P0));
	Point3D o = P0.add(v.scale(t));
	Vector result = point.subtract(o).normalize();
	return result;
}
/**
 * A function that calculates the normal according to the formula
 */

}
