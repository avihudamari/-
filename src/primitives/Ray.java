package primitives;


public class Ray {
    protected point3D poo;
    protected Vector direction;
    //region get set
    public void setPoo(point3D _POO)            { this.poo = new point3D(_POO);            }
    public void setDirction(Vector direction) { this.direction = new Vector(direction);	}
    public Vector getDirection() { return new Vector(direction); }
    public point3D getPoo()       { return new point3D(poo);	   }

    //endregion
    //region constractors
    public Ray() {
        this.poo = new point3D();
        this.direction = new Vector();
    }
    public Ray(Ray ray) {
        this.poo=ray.getPoo();
        this.direction=ray.getDirection();

    }
    public Ray(point3D p3D, Vector dir) {
        this.poo=new point3D(p3D);
        this.direction=new Vector(dir);
        this.direction.normalize();
    }

    //endregion
}
