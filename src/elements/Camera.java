package elements;

import javafx.geometry.Point3D;
import primitives.Vector;
import primitives.Ray;
import primitives.point3D;

import java.util.Map;

public class Camera {
    protected point3D p0;
    protected Vector vUp;
    protected Vector vTo;
    protected Vector vRight;

    //region constractors
    public Camera() {
        p0 = new point3D(0, 0, 10);
        vUp = new Vector(1, 0, 0);
        vTo = new Vector(0, 0, -1.0);
        vRight = new Vector(vTo.cross_product(vUp));
    }

    public Camera(Camera cam) {
        this.p0 = cam.getP0();
        this.vRight = cam.getvRight();
        this.vUp = cam.getvUp();
        this.vTo = cam.getvTo();
    }

    public Camera(point3D p, Vector vu, Vector vt) {
        this.p0 = new point3D(p);
        this.vUp = new Vector(vu);
        this.vTo = new Vector(vt);

        this.vRight = new Vector(vt.cross_product(vu));
        this.vRight.normalize();
        this.vUp.normalize();
        this.vTo.normalize();
    }

    //endregion
    //region setter and getter
    public point3D getP0() {
        return new point3D(p0);
    }

    public Vector getvUp() {
        return new Vector(vUp);
    }

    public void setvUp(Vector vUp) {
        this.vUp = new Vector(vUp);
    }

    public Vector getvTo() {
        return new Vector(vTo);
    }

    public void setvTo(Vector vTo) {
        this.vTo = new Vector(vTo);
    }

    public Vector getvRight() {
        return new Vector(vRight);
    }

    public void setvRight(Vector vRight) {
        this.vRight = new Vector(vRight);
    }

    //endregion
    @Override
    public String toString() {
        return "Vto: " + vTo + "\n" +
                "Vup: " + vUp + "\n" +
                "Vright:" + vRight + ".";
    }

    public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y,
                                        double screenDist,
                                        double screenWidth,
                                        double screenHeight) {
        //get copy's for all the vectors in this camera
        Vector vTo=getvTo();
        Vector vRight=getvRight();
        Vector vUp=getvUp();
        //normalize the vectors
        vTo.normalize();
        vRight.normalize();
        vUp.normalize();

        //center point on the view plane
        point3D Pc=getP0();
        Pc.add(vTo.scalre(screenDist));

        //Ratio (pixel size)
        double Rx=screenWidth/Nx;
        double Ry=screenHeight/Ny;

        //Calculate how much to go from the center
        Vector goRight = vRight.scalre((x-(Nx/2.0))*Rx+(Rx/2.0));
        Vector goUp=vUp.scalre(-((y-(Ny/2.0))*Ry+(Ry/2.0)));

        //find the point intersection between the ray and the view plane
        Pc.add(goRight);
        Pc.add(goUp);

        //the new ray
        return new Ray(getP0(),new Vector(getP0(),Pc));
    }




























/*    public Camera(Map<String, String> attributes) {

        String[] P0params = attributes
                .get("P0").split("\\s+");

        p0 = new point3D(Double.valueOf(P0params[0]),
                Double.valueOf(P0params[1]),
                Double.valueOf(P0params[2]));

        String[] vToParam = attributes
                .get("vTo").split("\\s+");
        vTo = new Vector(Double.valueOf(vToParam[0]),
                Double.valueOf(vToParam[1]),
                Double.valueOf(vToParam[2]));

        String[] vUpParam = attributes
                .get("vUp").split("\\s+");
        vUp = new Vector(Double.valueOf(vUpParam[0]),
                Double.valueOf(vUpParam[1]),
                Double.valueOf(vUpParam[2]));

        vRight = vUp.cross_product(vTo);
        vUp = vTo.cross_product(vRight);

        vUp.normalize();
        vTo.normalize();
        vRight.normalize();


    }
    */

}
