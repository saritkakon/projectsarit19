/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

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
		Point3D p1 = new Point3D(4, 3, 0);
		Point3D p2 = new Point3D(2, 1, 0);
		Point3D p3 = new Point3D(1, 2, 0);
		Triangle triangle = new Triangle(p1, p2, p3);
		assertEquals("ERROR: getNormalPoint() returns worng normal", triangle.getNormal(p1), new Vector(0, 0, -1));
	}
	/**
	 * Checks whether the resulting vector is the normalized vector we expected to receive
	 */
	
	/**
	 * Test method for {@link geometries.Triangle#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections() {
		Triangle triangle = new Triangle(new Point3D(0, 3, 0), new Point3D(0, 0, 0), new Point3D(3, 0, 0));
/**
 * Checks that the point of intersection with the triangle is the point we expected to get
 */
		// ============ Equivalence Partitions Tests ==============

		// TC01: Ray's line Inside polygon/triangle
		Ray ray = new Ray(new Vector(0, 0, 1), new Point3D(1, 1, -1));
		List<Point3D> result = triangle.findIntsersections(ray);
		Point3D p1 = new Point3D(1, 1, 0);
		assertEquals("Wrong number of points", 1, result.size());
		assertEquals("Ray crosses triangle", List.of(p1), result);

		ray = new Ray(new Vector(0, 0, 1), new Point3D(0.9, 0.5, -1));
		result = triangle.findIntsersections(ray);
		p1 = new Point3D(0.9, 0.5, 0);
		assertEquals("Wrong number of points", 1, result.size());
		assertEquals("Ray crosses triangle", List.of(p1), result);

		// TC02: Ray's line Outside against edge
		ray = new Ray(new Vector(0, 0, 1), new Point3D(-1, 2, -1));
		assertNull("Ray's line outside against edge", triangle.findIntsersections(ray));

		// TC03: Ray's line Outside against vertex
		ray = new Ray(new Vector(0, 0, 1), new Point3D(-1, -2, -1));
		assertNull("Ray's line outside against vertex", triangle.findIntsersections(ray));


		// =============== Boundary Values Tests ==================

		// TC04: Ray's line On edge
		ray = new Ray(new Vector(0, 0, 1), new Point3D(1, 0, -1));
		assertNull("Ray's line outside against vertex", triangle.findIntsersections(ray));

		// TC05: Ray's line In vertex
		ray = new Ray(new Vector(0, 0, 1), new Point3D(3, 0, -1));
		assertNull("Ray's line outside against vertex", triangle.findIntsersections(ray));

		// TC06: Ray's line On edge's continuation
		ray = new Ray(new Vector(0, 0, 1), new Point3D(-1, 0, -1));
		assertNull("Ray's line outside against vertex", triangle.findIntsersections(ray));
	}
}
