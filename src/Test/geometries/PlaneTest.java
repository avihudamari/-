package geometries;

import elements.Camera;
import org.junit.Test;
import primitives.Ray;
import primitives.Vector;
import primitives.point3D;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlaneTest {

    @Test
    public void findIntersections() {
    final int width=3;
    final int height=3;
        Ray[][] rays=new Ray[width][height];
        Camera camera=new Camera(new point3D(0,0,0),new Vector(0,1,0),new Vector(0,0,-1));
        Plane plane =new Plane(new Vector(0,0,-1),new point3D(0,0,-3));
        Plane plane2 = new Plane(new Vector(0.0, 0.25, -1.0), new point3D(0.0, 0.0, -3.0));

        List<point3D> intersectionPointsPlane = new ArrayList<point3D>();
        List<point3D> intersectionPointsPlane2 = new ArrayList<point3D>();

        System.out.println("Camera:\n" + camera);

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        width, height, j, i, 1, 3 * width, 3 * height);

                List<point3D> rayIntersectionPoints   = plane. FindIntersections(rays[i][j]);
                List<point3D> rayIntersectionPoints2  = plane2.FindIntersections(rays[i][j]);

                for (point3D iPoint: rayIntersectionPoints)
                    intersectionPointsPlane.add(iPoint);

                for (point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsPlane2.add(iPoint);
            }
        }

        assertTrue(intersectionPointsPlane. size() == 9);
        assertTrue(intersectionPointsPlane2.size() == 9);

        for (point3D iPoint: intersectionPointsPlane)
            System.out.println(iPoint);

        System.out.println("---");

        for (point3D iPoint: intersectionPointsPlane2)
            System.out.println(iPoint);
    }

}