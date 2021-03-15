/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Plane;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author saritkakon
 *
 */
public class PlaneTests {

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormalPoint3D() {
		Plane plane = new Plane(new Point3D(0, 2, 4), new Vector(4, 4, 4));
		assertEquals("ERROR: getNormalPoint() returns worng normal", plane.getNormal(new Point3D(0, 2, 4)),
				new Vector(4, 4, 4));

		plane = new Plane(new Point3D(0, 1, 0), new Point3D(0, 0, 1), new Point3D(1, 0, 0));
		assertEquals("ERROR: getNormalPoint() returns worng norma", plane.getNormal(new Point3D(1, 0, 0)),
				new Vector(1, 0, 0));

	}
	/**
	 * Checks whether the resulting vector is the normalized vector we expected to receive
	 */

}
