package geometries;
import primitives.Vector;
import primitives.point3D;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Geometry implements FlatGeometry
{
    protected Vector normal;
    protected point3D Q;
    //region get set
    public void setNormal(Vector normal) {
        this.normal =new Vector(normal);
    }
    public void setQ(point3D p) {
        this.Q = new point3D(p);
    }
    public Vector getNormal() {
        return new Vector(normal);
    }
    public point3D getQ() {
        return new point3D(Q);
    }
//endregion
    //region constractors
    public Plane() {
        this.normal=new Vector();
        this.Q=new point3D();
    }
    public Plane (Plane pl) {
        this.Q=pl.getQ();
        this.normal=pl.getNormal();
    }
    public  Plane(Vector vec,point3D p3) {
        this.normal=new Vector(vec);
        this.normal.normalize();
        this.Q=new point3D(p3);
    }
    //endregion
    @Override
    public Vector getNormal(point3D PD3) { return new Vector((normal));}
    @Override
    public List<point3D> FindIntersections(Ray ray) {
    List<point3D> intersectionPoint =new ArrayList<point3D>(1);
    point3D po=ray.getPoo();
    point3D Q0=this.getQ();
    Vector N=this.getNormal();
    Vector V=ray.getDirection();
        Vector v = new Vector (Q0, po);
        double t = (N.dot_product(v) * -1) / N.dot_product(V);
        if(t>=0)
          {
          V.scalre(t);
          po.add(V);
          intersectionPoint.add(po);
          }
        return intersectionPoint;
    }
}
