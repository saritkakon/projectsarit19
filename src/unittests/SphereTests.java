/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Sphere;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author saritkakon
 *
 */
public class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		Sphere sphere = new Sphere(new Point3D(1, 1, 1), 5);
		assertEquals("ERROR: getNormalPoint() returns worng normal", sphere.getNormal(new Point3D(1, 0, 0)),
				new Vector(0, -1, -1).normalize());
	}

}
