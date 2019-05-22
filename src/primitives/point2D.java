package primitives;

public class point2D implements Comparable<point2D>
{
    protected Coordinate x;
    protected Coordinate y;
//region constractors
    public point2D()
    {
        x=new Coordinate();
        y=new Coordinate();
    }
    public point2D(Coordinate _x,Coordinate _y)
    {
        x=new Coordinate(_x);
        y=new Coordinate(_y);
    }
    public point2D(point2D point2D)
    {
        x = point2D.getX();
        y = point2D.getY();
    }
//endregion
    //region get set
    public Coordinate getY() {
        return new Coordinate(y);
    }
    public void setY(Coordinate y) {
        this.y = new Coordinate(y);
    }
    public Coordinate getX() {
        return new Coordinate(x);
    }
    public void setX(Coordinate X) {
        this.x = new Coordinate(X);
    }
//endregion
    @Override
    public int compareTo(point2D po2D) {
        if (this.x.compareTo(po2D.x) == 0 &&
                this.y.compareTo(po2D.y) == 0)
            return 0;
        return 1;
    }
    @Override
    public String toString()
    {
        return "("+  x.getCoordinate()+", "+ y.getCoordinate()+")";
    }
}


