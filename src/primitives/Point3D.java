package primitives;

public class Point3D {
	 private final Coordinate x;
	private final Coordinate y;
	private final Coordinate z;
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
		double x1 = this.getX().coord;
		double y1 = this.getY().coord;
		double z1 = this.getZ().coord;
		double x2 = other.getX().coord;
		double y2 = other.getY().coord;
		double z2 = other.getZ().coord;

		return new Vector(x1 - x2, y1 - y2, z1 - z2);
	}
/**
 * The function receives a second point in the parameter, returns a vector from the second point to the point on which the operation is performed
 * @param other
 * @return
 */
	public Point3D add(Vector other) {

		return new Point3D(this.getX().coord +other.getHead().getX().coord ,this.getY().coord +other.getHead().getY().coord , this.getZ().coord +other.getHead().getZ().coord );
	}
	/**
	 * The function adds a vector to a point and returns a new point
	 * @param other
	 * @return
	 */
	public double distanceSquared (Point3D other){
		double x1 = this.getX().coord;
		double y1 = this.getY().coord;
		double z1 = this.getZ().coord;

		double x2 = other.getX().coord;
		double y2 = other.getY().coord;
		double z2 = other.getZ().coord;
		
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
		if (getX() == null) {
			if (other.getX() != null)
				return false;
		} else if (!getX().equals(other.getX()))
			return false;
		if (getY() == null) {
			if (other.getY() != null)
				return false;
		} else if (!getY().equals(other.getY()))
			return false;
		if (getZ() == null) {
			if (other.getZ() != null)
				return false;
		} else if (!getZ().equals(other.getZ()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point3D [x=" + getX() + ", y=" + getY() + ", z=" + getZ() + "]";
	}
	public Coordinate getX() {
		// TODO Auto-generated method stub
		return x;
	}
	public Coordinate getY() {
		return y;
	}
	public Coordinate getZ() {
		return z;
	}

}
