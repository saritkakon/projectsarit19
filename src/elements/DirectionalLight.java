package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource{
private Vector direction;

public DirectionalLight(Color intensity, Vector direction) {
	super(intensity);
	this.direction = direction;
}
/**
 * return the color at some point
 */
@Override
public Color getIntensity(Point3D p) {
	return getIntensity();
}
/**
 * return the direction light at some point
 */
@Override
public Vector getL(Point3D p) {
	return direction;
}
}