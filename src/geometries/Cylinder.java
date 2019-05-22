package geometries;
import primitives.Ray;
import primitives.Vector;
import primitives.point3D;

import java.util.ArrayList;
import java.util.List;

public class Cylinder extends RadialGeometry
{
  protected point3D p;
    protected Vector direction;
    //region get set
    public point3D getP() {
        return new point3D(p);
    }
    public Vector getDirection() { return new Vector(direction); }
    public void setP(point3D p) {
        this.p = new point3D(p);
    }
    public void setDirection(Vector direction) { this.direction = new Vector(direction); }
    //endregion
    //region constractors
    public Cylinder() {
        this.radius=0.0;
        this.direction=new Vector();
        this.p=new point3D();

    }
    public Cylinder(Cylinder ci) {
        this.radius=ci.radius;
        this.p=ci.getP();
        this.direction=ci.getDirection();
    }
    public Cylinder(double r,point3D _p,Vector v) {
        this.radius=r;
        this.p=new point3D(_p);
        this.direction=new Vector(v);
    }
    //endregion
    @Override
    public Vector getNormal(point3D PD3) {return null;}

    @Override
    public List<point3D> FindIntersections(Ray ray) {
        List<point3D> n=new ArrayList<>(0);
        return  n;
    }
}
