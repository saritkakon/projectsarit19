package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Camera {
	public static int NUBER_OF_RAYS = 0;
	public static double RADIUS = 0.01;
	
    private Point3D p;
    private Vector Vup, Vto, Vright;
    private double width;
    private double height;
    private double distance;

    /**
     * constructor
     *
     * @param s
     * @param vup
     * @param vto
     */
    public Camera(Point3D p, Vector vto, Vector vup) {
        super();
        this.p = p;
        Vup = vup.normalize();
        Vto = vto.normalize();
        if (Vup.dotProduct(Vto) != 0)
            throw new IllegalArgumentException("Vup and Vto are not ortogonal");
        Vright = Vto.crossProduct(Vup).normalize();

    }

    /**
     * set
     *
     * @param width
     * @param height
     * @return this
     */
    public Camera setViewPlaneSize(double width, double height) {
        this.height = height;
        this.width = width;
        return this;
    }

    public Camera setDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public List<Ray> constructRayThroughPixel(int nX, int nY, int j, int i) {
        Point3D Pc = p.add(Vto.scale(distance));
        double Ry = height / nY;
        double Rx = width / nX;
        double Xj = (j - ((nX - 1) / 2.0)) * Rx;
        double Yi = -(i - ((nY - 1) / 2.0)) * Ry;

        Point3D Pij = Pc;
        if (!isZero(Xj)) Pij = Pij.add(Vright.scale(Xj));
        if (!isZero(Yi)) Pij = Pij.add(Vup.scale(Yi));

        Vector Vij = Pij.subtract(p).normalize();
        return constructRayCone(new Ray(Vij, p));
    }
    /**
     * The function gets a list of rays, and each time takes the ray and adds to it all the rays coming on the x, y, z axis
     *  and adds to each ray a random number between radius and -radius
     *  and adds it to the list of rays and creates a cone of all rays and returns the cone
     * @param ray
     * @return
     */
    public static List<Ray> constructRayCone(Ray ray) {
        List<Ray> result = new ArrayList<>();
        result.add(ray);
        for (int i = 0; i < NUBER_OF_RAYS; i++) {
            double x = ray.getDir().getHead().getX().getCoord() + ThreadLocalRandom.current().nextDouble(-RADIUS, RADIUS);
            double y = ray.getDir().getHead().getY().getCoord() + ThreadLocalRandom.current().nextDouble(-RADIUS, RADIUS);
            double z = ray.getDir().getHead().getZ().getCoord() + ThreadLocalRandom.current().nextDouble(-RADIUS, RADIUS);
            result.add(new Ray(new Vector(x, y, z), ray.getP0()));
        }
        return result;
    }


}
