package primitives;

public class Coordinate implements Comparable<Coordinate>
{
   protected double coordinate;

    //*******constractors*********//
    public Coordinate() {this.coordinate=0.0;}
    public Coordinate(double coor){this.coordinate=coor;}
    public Coordinate (Coordinate coor){this.coordinate= coor.coordinate;}
    /**********get set******/
    public double getCoordinate()
    {
        return coordinate;
    }
    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }
@Override
    public int  compareTo(Coordinate coor){return Double.compare(this.coordinate , coor.coordinate);}

    public void add (Coordinate coor)
    {
        this.coordinate+=coor.coordinate;
    }
    public void subtract(Coordinate coor)
    {
        this.coordinate-=coor.coordinate;
    }
}
