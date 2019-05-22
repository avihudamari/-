package geometries;

public abstract class RadialGeometry extends Geometry
{
    protected double radius;
  public RadialGeometry(){this.radius=0.0;}
  public RadialGeometry(double r){this.radius=r;}
    public double getRadius() {
        return radius;
    }
    public void setRadius(double rad) {
        this.radius = rad;
    }
}
