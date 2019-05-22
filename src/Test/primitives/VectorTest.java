package primitives;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class VectorTest {

    Vector v;
    @Before
    public void setUp() throws Exception {
        v=new Vector();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        System.out.println("add test");
        v.setHead(new point3D(2,1,1));
        v.add(new Vector(1,1,1));
       v.compareTo(new Vector(3,2,2));
    }

    @Test
    public void subtract() {
    }

    @Test
    public void scalre()
    {
        System.out.println("add scalre");
        Vector v=new Vector(3,2,1);
        v.scalre(4);
        Vector v1=new Vector(12,8,4);
        v.compareTo(v1);
    }

    @Test
    public void length()
    {
        System.out.println("add test");
        Vector v=new Vector(new point3D(0,3,4));
        double l;
        assertEquals(5,v.length(),0.000);
    }

    @Test
    public void dot_product()
    {
        System.out.println("dot_product test");

        Vector v1=new Vector(5,2,1);
        Vector v2=new Vector(1,2,2);
        double result=v1.dot_product(v2);
        assertEquals(result,11,0);

    }

    @Test
    public void cross_product()
    {
        System.out.println("cross_product test");
        Vector v1=new Vector(1,1,2);
        Vector v2=new Vector(2,1,0);
        Vector v3=v1.cross_product(v2);
      //  assertEquals(v3,new Vector(-2,4,-1));

    }

    @Test
    public void normalize()
    {
        System.out.println("normalize test");
        Vector v=new Vector(1,2,3);
    v.normalize();
    double result=v.length();
        assertEquals(result,1,0);
    }

    @Test
    public void compareTo()
    {
        System.out.println("compareTo test");

        Vector v=new Vector(5,4,4);
        Vector vec=new Vector(5,4,4);
       assertEquals(v.compareTo(vec),0);
    }
}