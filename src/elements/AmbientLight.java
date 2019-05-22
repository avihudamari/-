package elements;

import java.awt.*;
import java.util.Map;

public class AmbientLight extends Light {
    protected final double ka=0.1;
    //region constractors

    public AmbientLight() {
        super(new Color(255,255,255));

    }
    public AmbientLight (AmbientLight aLight)
    {
        super(aLight.color);
    }
    public AmbientLight(int r,int g,int b){super(new Color(r,g,b));}
    //endregion
    public AmbientLight(Map<String, String> attributes){
        String[] ambientLightColors = attributes
                .get("color" ).split("\\s+");
        color = new Color((int)(255 * Double.valueOf(ambientLightColors[0])),
                (int)(255 * Double.valueOf(ambientLightColors[1])),
                (int)(255 * Double.valueOf(ambientLightColors[2])));
    }
    //region get set
    public Color getcolor(){return  color;}
    public void setcolor(Color col){color=col;}
    public double getKa(){return ka;}

    public Color getIntensity() {
        return new Color((int) (color.getRed() * ka),
                (int) (color.getGreen() * ka),
                (int) (color.getBlue() * ka));
    }
    //endregion


}
