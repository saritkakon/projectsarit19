package primitives;

public class Vector {
	Point3D head;
	


public Vector(Coordinate x, Coordinate y, Coordinate z) {
	super();
	 Point3D p= new Point3D(x, y, z);
	 if(p.equals(Point3D.ZERO))
		throw new IllegalArgumentException("cannot create vector with 0, 0, 0");
	this.head = p;
}
	/**
	 * constructor receiving three coordinates
	 * @param x
	 * @param y
	 * @param z
	 */

public Vector(double x, double y, double z) {
	if(new Point3D(x, y, z).equals(Point3D.ZERO))
		throw new IllegalArgumentException("cannot create vector with 0, 0, 0");
	this.head = new Point3D(x, y, z);
}
/**
 * constructor receiving three doubles
 * @param point
 */

public Vector(Point3D point) {
	this.head = point;
}
/**
 * constructor receiving point
 */
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Vector other = (Vector) obj;
	if (head == null) {
		if (other.head != null)
			return false;
	} else if (!head.equals(other.head))
		return false;
	return true;
}

@Override
public String toString() {
	return "Vector [head=" + head + "]";
}

public Vector subtract(Vector other) {
	return this.head.subtract(other.head);
}
/**
 * A function that receives two vectors and subtracts between them and returns the resulting vector
 * @param other
 * @return
 */

public Vector add(Vector other) {
	return new Vector(this.head.add(other));
}
/**
 * A function that receives two vectors and adds between them and returns the resulting vector
 * @param scalar
 * @return
 */
public Vector scale (double scalar) {
	double x= head.x.coord;
	double y= head.y.coord;
	double z= head.z.coord;
	return new Vector (x*scalar, y*scalar, z*scalar);
}
/**
 * A function that receives a vector and multiplies it by a certain scalar
And returns the resulting new vector
 * @param other
 * @return
 */
public double dotProduct (Vector other) {
	double x1 = this.head.x.coord;
	double y1 = this.head.y.coord;
	double z1 = this.head.z.coord;

	double x2 = other.head.x.coord;
	double y2 = other.head.y.coord;
	double z2 = other.head.z.coord;
	return(x1*x2+y1*y2+z1*z2);
}
/**
 * A function that receives two vectors and makes a scalar product between them and returns a new vector
 * @param other
 * @return
 */
public Vector crossProduct (Vector other) {
	double x1 = this.head.x.coord;
	double y1 = this.head.y.coord;
	double z1 = this.head.z.coord;

	double x2 = other.head.x.coord;
	double y2 = other.head.y.coord;
	double z2 = other.head.z.coord;
	return new Vector (y1*z2-z1*y2,z1*x2-x1*z2,x1*y2-y1*x2);
}
/**
 * The function receives two vectors and returns a new vector perpendicular to the two vectors
 * @return
 */
public double lengthSquared() {
	return dotProduct(this);
}
/**
 * A function that calculates the length of the vector squared and returns it
 * @return
 */
public double length() {
	return Math.sqrt(lengthSquared());
}
/**
 * A function that calculates the length of the vector and returns it
 * @return
 */
public Vector normalize() {
	this.head = scale(1/length()).head;
	return this;
}
/**
 * A function that normalizes the vector and returns the original vector after the normalization operation
 * @return
 */
public Vector normalized() {
	return new Vector(this.head).normalize();
}
/**
 * A function that normalizes the vector and returns a new normalized vector
 * @return
 */

public Point3D getHead() {
	return this.head;
}

}

