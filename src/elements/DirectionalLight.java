package elements;

import primitives.Vector;
import primitives.point3D;
import java.awt.*;

public class DirectionalLight extends Light implements LightSource
{
protected Vector _direction;
public DirectionalLight(Color color,Vector direction) {
    super(color);
    _direction=new Vector(direction);
}
    public Vector getDirection()                { return new Vector(_direction); }
    public Color getIntensity(point3D point)
    {
        return getIntesity();
    }

    public Vector getL(point3D point)           { return getDirection();         }
    public void setDirection(Vector _direction) { this._direction = _direction;	 }
}
