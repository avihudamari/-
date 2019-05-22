package geometries;

import primitives.Material;
import primitives.Vector;
import primitives.point3D;
import primitives.Ray;

import java.awt.*;
import java.util.List;

public abstract class Geometry {
    private Color emmission=new Color(0,0,0);
    private Material material=new Material();
    private double Shininess=1;

    //region getter setter
    public void setMaterial(Material material) {
        this.material = material;
    }
    public void setShininess(double nShininess) {
        this.Shininess = nShininess;
    }
    public void setEmmission(Color emmission) {
        this.emmission = new Color(emmission.getRGB());
    }

    public Material getMaterial() {
        return new Material( material);
    }
    public double getShininess() {
        return Shininess;
    }
    public Color getEmmission() {
        return new Color(emmission.getRGB());
    }
    public void setKs(double ks) { material.setKs(ks); }
    public void setKd(double kd) { material.setKd(kd); }
    public void setKr(double Kr) { material.setKr(Kr); }
    public void setKt(double Kt) { material.setKt(Kt); }

//endregion


    public abstract Vector getNormal(point3D PD3);
    public abstract List<point3D> FindIntersections(Ray ray);
}
