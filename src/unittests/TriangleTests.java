/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author saritkakon
 *
 */
public class TriangleTests {

	/**
	 * Test method for {@link geometries.Polygon#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		Point3D p1 = new Point3D(1, 0, 0);
		Point3D p2 = new Point3D(0, 1, 0);
		Point3D p3 = new Point3D(0, 0, 1);
		Triangle triangle = new Triangle(p1, p2, p3);
		assertEquals("ERROR: getNormalPoint() returns worng normal", triangle.getNormal(p1), new Vector(0, 0, 1));
	}

}
