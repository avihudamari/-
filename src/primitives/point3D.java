package primitives;


public class point3D extends point2D
{
    private Coordinate z;
// region get and set
    public Coordinate getZ() {
        return new Coordinate(z);
    }
    public void setZ(Coordinate Z) {
        this.z =new Coordinate(Z);
    }
    //endregion
    // region constractor
    public point3D(){z=new Coordinate();}
    public point3D(Coordinate X,Coordinate Y,Coordinate Z) {
        super(X,Y);
        z=new Coordinate(Z);
    }
    public point3D (double X,double Y,double Z ) {
        super(new Coordinate(X),new Coordinate(Y));
        z=new Coordinate(Z);
    }
    public point3D(point3D po3d) {
        super(po3d.getX(),po3d.getY());
            z =po3d.getZ();
    }
    //endregion
   @Override
   public String toString() {
       return "(" + x.getCoordinate() + ", " +
               y.getCoordinate() + ", " +
               z.getCoordinate() + ")";
   }
    public int comapreTo(point3D po3d) {
       if(((point2D)this).compareTo((point2D)po3d)==0)
           if (this.getZ().compareTo(po3d.getZ())==0)
               return 0;
       return 1;
   }
   //region opertion
    public void add(Vector vec) {
        this.x.add(vec.getHead().getX());
        this.y.add(vec.getHead().getY());
        this.z.add(vec.getHead().getZ());
    }
    public void subtract(Vector vector) {

        this.x.subtract(vector.getHead().getX());
        this.y.subtract(vector.getHead().getY());
        this.z.subtract(vector.getHead().getZ());

    }
    public double distance(point3D point) {
        return Math.sqrt(Math.pow(this.x.getCoordinate() - point.getX().getCoordinate(), 2) +
                Math.pow(this.y.getCoordinate() - point.getY().getCoordinate(), 2) +
                Math.pow(this.z.getCoordinate() - point.getZ().getCoordinate(), 2));
    }
//endregion



}
