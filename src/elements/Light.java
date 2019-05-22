package elements;
import java.awt.Color;
public abstract class Light
{
    protected Color color;
    public Light(){color=null;}
    public Light(Color c){color=c;}
    public Color getIntesity() {
        return color;
    }
}
