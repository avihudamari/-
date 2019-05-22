package primitives;


import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void compareTo()
    {
        Coordinate co1=new Coordinate(5);
        Coordinate CO2=new Coordinate(5);
        assertEquals(co1.compareTo(CO2),0);
    }
}