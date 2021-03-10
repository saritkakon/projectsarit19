package primitives;

public class Ray {
Vector dir;

Point3D p0;

public Ray(Vector dir, Point3D p0) {
	super();
	this.dir = dir.normalize();
	this.p0 = p0;
}

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
}
