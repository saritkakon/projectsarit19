package primitives;

public class Point3D {
	 final Coordinate x;
	final Coordinate y;
	final Coordinate z;
	public static Point3D ZERO = new Point3D(0, 0, 0);
/**
 * A Point3D constant that represents the beginning of the axes.
 * @param x
 * @param y
 * @param z
 */
	public Point3D(double x, double y, double z) {
		this.x = new Coordinate(x);
		this.y = new Coordinate(y);
		this.z = new Coordinate(z);
	}
	/**
	 * constructor receiving three doubles 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D( Coordinate x, Coordinate y, Coordinate z) {
		this.x = (x);
		this.y = (y);
		this.z = (z);
	}
	/**
	 * constructor receiving three coordinate
	 * @param other
	 * @return
	 */
	public Vector subtract(Point3D other) {
		double x1 = this.x.coord;
		double y1 = this.y.coord;
		double z1 = this.z.coord;
		double x2 = other.x.coord;
		double y2 = other.y.coord;
		double z2 = other.z.coord;

		return new Vector(x1 - x2, y1 - y2, z1 - z2);
	}
/**
 * The function receives a second point in the parameter, returns a vector from the second point to the point on which the operation is performed
 * @param other
 * @return
 */
	public Point3D add(Vector other) {

		return new Point3D(this.x.coord +other.getHead().x.coord ,this.y.coord +other.getHead().y.coord , this.z.coord +other.getHead().z.coord );
	}
	/**
	 * The function adds a vector to a point and returns a new point
	 * @param other
	 * @return
	 */
	public double distanceSquared (Point3D other){
		double x1 = this.x.coord;
		double y1 = this.y.coord;
		double z1 = this.z.coord;

		double x2 = other.x.coord;
		double y2 = other.y.coord;
		double z2 = other.z.coord;
		
		return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) + (z1-z2)*(z1-z2);
	}
	public double distance (Point3D other){
		double distanceSquared = distanceSquared(other);
		return Math.sqrt(distanceSquared);
	}
	/**
	 * A function that receives two points and returns the distance between them
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	public double getX() {
		// TODO Auto-generated method stub
		return this.x.coord;
	}

}
