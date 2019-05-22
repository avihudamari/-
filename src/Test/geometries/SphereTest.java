package geometries;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import elements.Camera;
import geometries.Sphere;
import primitives.point3D;
import primitives.Ray;
import primitives.Vector;
public class SphereTest {
    @Test
    public void testIntersectionPoints(){

        final int WIDTH  = 3;
        final int HEIGHT = 3;

        Ray[][] rays = new Ray [HEIGHT][WIDTH];

        Camera camera = new Camera(new point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));

        Sphere sphere  = new Sphere(1, new point3D(0.0, 0.0, -3.0));
        Sphere sphere2 = new Sphere(10, new point3D(0.0, 0.0, -3.0));

        // Only the center ray intersect the sphere in two locations
        List<point3D> intersectionPointsSphere = new ArrayList<point3D>();

        // The sphere encapsulates the view plane - all rays intersect with the sphere once
        List<point3D> intersectionPointsSphere2 = new ArrayList<point3D>();

        System.out.println("Camera:\n" + camera);

        for (int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        WIDTH, HEIGHT, j, i, 2, 3 * WIDTH, 3 * HEIGHT);

                List<point3D> rayIntersectionPoints  = sphere. FindIntersections(rays[i][j]);
                List<point3D> rayIntersectionPoints2 = sphere2.FindIntersections(rays[i][j]);

                for (point3D iPoint: rayIntersectionPoints)
                    intersectionPointsSphere.add(iPoint);

                for (point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsSphere2.add(iPoint);

            }
        }

        assertTrue(intersectionPointsSphere. size() == 2);
        assertTrue(intersectionPointsSphere2.size() == 9);

        System.out.println("Intersection Points:");
        for (point3D iPoint: intersectionPointsSphere){

            assertTrue(iPoint.compareTo(new point3D(0.0, 0.0, -2.0)) == 0 ||
                    iPoint.compareTo(new point3D(0.0, 0.0, -4.0)) == 0);

            System.out.println(iPoint);
        }
    }
}