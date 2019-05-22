package elements;
import primitives.point3D;
import primitives.Vector;;

import java.awt.*;

public class PointLight extends Light  implements LightSource{

    point3D _position;
    double _Kc, _Kl, _Kq;
    public PointLight(Color color, point3D position, double kc, double kl, double kq) {
        super(color);
        _Kc = kc;
        _Kl = kl;
        _Kq = kq;
        _position = new point3D(position);
    }
    @Override
    public Color getIntensity(point3D point) {

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        double d = _position.distance(point);

        double k = 1/(_Kc + _Kl*d + _Kq*Math.pow(d, 2));

        if (k > 1) k = 1;

        return new Color((int)(r * k),
                (int)(g * k),
                (int)(b * k));
    }
    @Override
    public Vector getL(point3D point) { return new Vector (_position, point); }
}