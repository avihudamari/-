package geometries;

import primitives.Ray;
import primitives.Vector;
import primitives.point3D;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class Sphere extends RadialGeometry
{
    protected point3D center;
    //region get set
    public point3D getCenter() {
        return new point3D(center);
    }
    public void setCenter(point3D center) {
        this.center =new point3D(center);
    }

    //endregion
    //region constractors
public Sphere()
{
    center=new point3D();
}
public Sphere(Sphere sp){super(sp.radius);this.center=sp.getCenter();}
public Sphere(double r,point3D p)
{
    this.radius=r;
    this.center=new point3D(p);
}

//endregion
    @Override
    public Vector getNormal(point3D point) {

        Vector N = new Vector (center, point);
        N.normalize();
        return N;

    }
    @Override
    public List<point3D> FindIntersections(Ray ray) {
        point3D tmp;
        List<point3D> pointsList=new ArrayList<>();
        Vector L=new Vector(ray.getPoo(),getCenter());
        Vector rayVector=ray.getDirection();
        rayVector.normalize();
        double tm=L.dot_product(rayVector);
        double d=sqrt(L.length()*L.length()-tm*tm);
        if(d>radius)//if there is no intersection point
            return pointsList;
        double th=sqrt(radius*radius-d*d);
        double t1=tm-th;
        double t2=tm+th;
        if(t1>=0){// if there is one intersection point
            tmp=new point3D(ray.getPoo());
            tmp.add(ray.getDirection().scalre(t1));
            pointsList.add(tmp);
        }
        if(t2>0&&t1!=t2){//if there is two intersection point
            tmp=new point3D(ray.getPoo());
            tmp.add(ray.getDirection().scalre(t2));
            pointsList.add(tmp);
        }
        return pointsList;
    }
}
