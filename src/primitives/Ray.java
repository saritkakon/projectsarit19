package primitives;

public class Ray {
    Vector dir;

    Point3D p0;

    public Ray(Vector dir, Point3D p0) {
        super();
        this.dir = dir.normalize();
        this.p0 = p0;
    }

    /**
     * constructor that receiving vector and point
     */

    @Override
    public String toString() {
        return "Ray [dir=" + dir + ", p0=" + p0 + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ray other = (Ray) obj;
        if (dir == null) {
            if (other.dir != null)
                return false;
        } else if (!dir.equals(other.dir))
            return false;
        if (p0 == null) {
            if (other.p0 != null)
                return false;
        } else if (!p0.equals(other.p0))
            return false;
        return true;
    }

    public Vector getDir() {
        return dir;
    }

    public void setDir(Vector dir) {
        this.dir = dir;
    }

    public Point3D getP0() {
        return p0;
    }

    public void setP0(Point3D p0) {
        this.p0 = p0;
    }

	public Point3D getPoint(double t) {
    	return p0.add(dir.scale(t));
	}

}
