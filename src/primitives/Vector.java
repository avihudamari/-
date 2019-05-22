package primitives;

public class Vector implements Comparable<Vector> {
    protected point3D head;
    // region constractor
    public Vector() {
        this.head = new point3D();
    }

    public Vector(point3D he) {
        this.head = new point3D(he);
    }

    public Vector(Vector vec) {
        this.head = vec.getHead();
    }

    public Vector(double xHead, double yHead, double zHead) {
        head = new point3D(new Coordinate(xHead),
                new Coordinate(yHead),
                new Coordinate(zHead));
    }

    public Vector(point3D p1, point3D p2) {

        this(p2.getX().getCoordinate() - p1.getX().getCoordinate(),
                p2.getY().getCoordinate() - p1.getY().getCoordinate(),
                p2.getZ().getCoordinate() - p1.getZ().getCoordinate());

    }

    //endregion
    //region get set
    public point3D getHead() {
        return new point3D(this.head);
    }
    public void setHead(point3D he) {
        this.head = new point3D(he);
    }

    //endregion
    //region operation
    public void add(Vector vec) {
        this.head.add(vec);
    }
    public void subtract(Vector vec) {
        this.head.subtract(vec);
    }
    public Vector scalre(double alfha) {
      this.head.setX(new Coordinate(alfha * this.head.getX().getCoordinate()));
        this.head.setY(new Coordinate((alfha * this.head.getY().getCoordinate())));
        this.head.setZ(new Coordinate(alfha * this.head.getZ().getCoordinate()));
        return this;
    }
    public double length() {
        double x = this.getHead().getX().getCoordinate();
        double y = this.getHead().getY().getCoordinate();
        double z = this.getHead().getZ().getCoordinate();

        return
                Math.sqrt(Math.pow(x, 2) +
                        Math.pow(y, 2) +
                        Math.pow(z, 2));

    }
    public double dot_product(Vector vector) {
        return
                (this.head.getX().getCoordinate()*vector.head.getX().getCoordinate())+
                        (this.head.getY().getCoordinate()*vector.head.getY().getCoordinate())+
                        (this.head.getZ().getCoordinate()*vector.head.getZ().getCoordinate());
    }
    public Vector cross_product(Vector vec) {
        double x=(this.head.getY().getCoordinate()*vec.head.getZ().getCoordinate()-vec.head.getY().getCoordinate()*this.head.getZ().getCoordinate());
        double y=-1*(this.head.getX().getCoordinate()*vec.head.getZ().getCoordinate()-vec.head.getX().getCoordinate()*this.head.getZ().getCoordinate());
        double z=(this.head.getX().getCoordinate()*vec.head.getY().getCoordinate()-vec.head.getX().getCoordinate()*this.head.getY().getCoordinate());
        return new Vector(x,y,z);
    }
    public void normalize() {
        double x = this.getHead().getX().getCoordinate();
        double y = this.getHead().getY().getCoordinate();
        double z = this.getHead().getZ().getCoordinate();

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException();

        this.setHead(new point3D(x/length,
                y/length,
                z/length));
    }
    //endregion
    @Override
    public int compareTo(Vector vec) {
        return this.head.comapreTo(vec.head);
    }
    @Override
    public String toString() {
        return head.toString();
    }

}

