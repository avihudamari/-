package elements;

import primitives.Vector;
import primitives.point3D;

import java.awt.*;

public class SpotLight extends PointLight
{
    Vector _direction;
    public SpotLight(Color color, Vector direction,point3D position, double kc, double kl, double kq) {
       super(color,position,kc,kl,kq);
       _direction=new Vector(direction);
        _direction.normalize();



    }
    public Color getIntesity(point3D point) {
        Color point_color= super.getIntesity();
    Vector L=getL(point);
    L.normalize();
    double k=Math.abs(_direction.dot_product(L));
    if(k>1) k=1;
        return new Color((int)(point_color.getRed()   * k),
                (int)(point_color.getGreen() * k),
                (int)(point_color.getBlue()  * k));
    }
}
