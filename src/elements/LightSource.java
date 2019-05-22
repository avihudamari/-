package elements;

import java.awt.Color;
import primitives.point3D;
import primitives.Vector;

public interface LightSource {

    public abstract Color getIntensity(point3D point);
    public abstract Vector getL(point3D point); // light to point vector
}
