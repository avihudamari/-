package elements;

import org.junit.Assert;
import org.junit.Test;
import primitives.Ray;
import primitives.Vector;
import primitives.point3D;
import static org.junit.Assert.*;

public class CameraTest {
    @Test
    public void constructRayThroughPixel() {
    final int WIDTH=3;
    final int HEIGHT=3;
    point3D [][] screen=new point3D[HEIGHT][WIDTH];
    Camera camera =new Camera(new point3D(0,0,0),new Vector(0,1,0),new Vector(0,0,-1));
        System.out.println("Camera:\n" + camera);

    for ( int i=0;i<HEIGHT;i++) {
        for (int j=0;j<WIDTH;j++) {
         Ray ray=camera.constructRayThroughPixel( WIDTH,HEIGHT, j, i, 1, 3*WIDTH, 3*HEIGHT);
         screen[i][j]=ray.getPoo();
            System.out.print(screen[i][j]);
            System.out.print(ray.getDirection());
            assertTrue(Double.compare(screen[i][j].getZ().getCoordinate(), 0.0) == 0);
            // Checking all options
            double x = screen[i][j].getX().getCoordinate();
            double y = screen[i][j].getX().getCoordinate();

         if (Double.compare(x, 3) == 0 || Double.compare(x, 0) == 0 || Double.compare(x, -3) == 0){
                    if (Double.compare(y, 3) == 0 ||
                        Double.compare(y, 0) == 0 ||
                        Double.compare(y, -3) == 0)
                    {
                assertTrue(true);
            } else {
                fail("Wrong y coordinate");
            }
        } else {
            fail("Wrong x coordinate");
        }

    }
    System.out.println("--");
    }
    }
}