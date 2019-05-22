package primitives;

import javafx.geometry.Point3D;
import org.junit.Test;

import static org.junit.Assert.*;

public class point3DTest {
    @Test
    public void add()
    {
        point3D p1=new point3D(1,2,3);
        Vector p2 =new Vector(2,3,4);
        p1.add(p2);
        point3D pr=new point3D(3,5,7);
        assertSame("testing add func",p1.comapreTo(pr),0);

    }

    @Test
    public void subtract()
    {
        point3D p1=new point3D(1,2,3);
        Vector p2 =new Vector(2,3,4);
        p1.subtract(p2);
        point3D pr=new point3D(-1,-1,-1);
        assertSame("testing sub func",p1.comapreTo(pr),0);

    }

    @Test
    public void distance()
    {
        point3D p1=new point3D(1,3,3);
        point3D p2 =new point3D(2,3,3);
       Integer result=(int)p1.distance(p2);

        assertSame("testing distance func",result.compareTo(1),0);
    }

}