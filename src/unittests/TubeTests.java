/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Tube;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author saritkakon
 *
 */
public class TubeTests {

	/**
	 * Test method for {@link geometries.Tube#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		Tube tube = new Tube(new Ray(new Vector(0, 0, 1), new Point3D(1, 1, 1)), 50);
		assertEquals("ERROR: getNormalPoint() returns worng normal", tube.getNormal(new Point3D(1, 0, 0)),
				new Vector(0, -1, 0).normalize());
	}
/**
 * 
 */
}
