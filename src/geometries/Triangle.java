package geometries;
import primitives.point3D;
import primitives.Vector;
import primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public  class Triangle extends Geometry implements FlatGeometry
{
    protected point3D p1;
    protected point3D p2;
    protected point3D p3;
    //region constractor
    public  Triangle() {
    p1=new point3D();
    p2=new point3D();
    p3=new point3D();
    }
    public Triangle(Triangle t) {
    p1=t.getP1();
    p2=t.getP2();
    p3=t.getP3();
    }
    public Triangle(point3D _p1,point3D _p2,point3D _p3) {
        p1=new point3D(_p1);
        p2=new point3D(_p2);
        p3=new point3D(_p3);
    }
    //endregion
    //region get set

    public point3D getP1() {
        return new point3D(p1);
    }

    public void setP1(point3D p1) {
        this.p1 = new point3D(p1);
    }

    public point3D getP2() {
        return new point3D(p2);
    }

    public void setP2(point3D p2) {
        this.p2 =new point3D(p2);
    }

    public point3D getP3() {
        return new point3D(p3);
    }

    public void setP3(point3D p3) {
        this.p3 = new point3D(p3);
    }
    //endregion
    @Override
    public Vector getNormal(point3D PD3) {
    Vector U = new Vector (p1, p2);
    Vector V = new Vector (p1, p3);
    Vector N = new Vector (U.cross_product(V));

		N.normalize();
		N.scalre(-1);
		return N;
}

    @Override
    public List<point3D> FindIntersections(Ray ray) {

        List<point3D> intersectionPoints = new ArrayList<point3D>(1);

        // Intersecting the triangular plane

        point3D P0 = ray.getPoo();

        Vector N = getNormal(null);
        Plane plane = new Plane(N, p3);

        if (plane.FindIntersections(ray).isEmpty())
            return intersectionPoints;

        point3D intersectionPlane = plane.FindIntersections(ray).get(0);

        // Checking if the interseculating point is bounded by the triangle
        Vector P_P0 = new Vector(P0, intersectionPlane);

        // Checking 1/3 triangular side
        Vector V1_1 = new Vector(P0, this.p1);
        Vector V2_1 = new Vector(P0, this.p2);
        Vector N1 = V1_1.cross_product(V2_1);
        N1.normalize();
        double S1 = -P_P0.dot_product(N1);

        // Checking 2/3 triangular side
        Vector V1_2 = new Vector(P0, this.p2);
        Vector V2_2 = new Vector(P0, this.p3);
        Vector N2 = V1_2.cross_product(V2_2);
        N2.normalize();
        double S2 = -P_P0.dot_product(N2);

        // Checking 1/3 triangular side
        Vector V1_3 = new Vector(P0, this.p3);
        Vector V2_3 = new Vector(P0, this.p1);
        Vector N3 = V1_3.cross_product(V2_3);
        N3.normalize();
        double S3 = -P_P0.dot_product(N3);

        if (((S1 > 0) && (S2 > 0) && (S3 > 0)) ||
                ((S1 < 0) && (S2 < 0) && (S3 < 0))){
            intersectionPoints.add(intersectionPlane);
        }

        return intersectionPoints;

    }

}
