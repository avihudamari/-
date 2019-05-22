package geometries;

import elements.Camera;
import org.junit.Test;
import primitives.Ray;
import primitives.Vector;
import primitives.point3D;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void findIntersections() {


            final int WIDTH  = 3;
            final int HEIGHT = 3;

            Ray[][] rays = new Ray [HEIGHT][WIDTH];

            Camera camera = new Camera(new point3D(0.0 ,0.0 ,0.0),
                    new Vector(0.0, 1.0, 0.0),
                    new Vector (0.0, 0.0, -1.0));

            Triangle triangle = new Triangle(new point3D( 0,  1, -2),
                    new point3D( 1, -1, -2),
                    new point3D(-1, -1, -2));

            Triangle triangle2 = new Triangle(new point3D( 0,  10, -2),
                    new point3D( 1, -1, -2),
                    new point3D(-1, -1, -2));

            List<point3D> intersectionPointsTriangle = new ArrayList<point3D>();
            List<point3D> intersectionPointsTriangle2 = new ArrayList<point3D>();

            System.out.println("Camera:\n" + camera);

            for (int i = 0; i < HEIGHT; i++){
                for (int j = 0; j < WIDTH; j++){

                    rays[i][j] = camera.constructRayThroughPixel(
                            WIDTH, HEIGHT, j, i, 1, 3 * WIDTH, 3 * HEIGHT);

                    List<point3D> rayIntersectionPoints   = triangle.  FindIntersections(rays[i][j]);
                    List<point3D> rayIntersectionPoints2  = triangle2. FindIntersections(rays[i][j]);

                    for (point3D iPoint: rayIntersectionPoints)
                        intersectionPointsTriangle.add(iPoint);

                    for (point3D iPoint: rayIntersectionPoints2)
                        intersectionPointsTriangle2.add(iPoint);
                }
            }

            assertTrue(intersectionPointsTriangle. size() == 1);
            assertTrue(intersectionPointsTriangle2.size() == 2);

            System.out.println("Intersection Points:");
            for (point3D iPoint: intersectionPointsTriangle){
                System.out.println(iPoint);
            }
            System.out.println("--");
            for (point3D iPoint: intersectionPointsTriangle2){
                System.out.println(iPoint);
            }

        }
    }
