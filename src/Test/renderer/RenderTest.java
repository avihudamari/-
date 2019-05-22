package renderer;

import elements.*;
import geometries.Geometry;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Material;
import primitives.Ray;
import primitives.Vector;
import primitives.point3D;
import scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class RenderTest {

    @Test
    public void recursiveTest() {

        Scene scene = new Scene();
        scene.setScreenDistance(300);

        Sphere sphere = new Sphere(500, new point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);
        Sphere sphere2 = new Sphere(250, new point3D(0.0, 0.0, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Vector(2, 2, -3),
                new point3D(-200, -200, -150), 0.1, 0.00001, 0.000005));
        ImageWriter imageWriter = new ImageWriter("Recursive Test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void recursiveTest2() {

        Scene scene = new Scene();
        scene.setScreenDistance(300);
        Sphere sphere = new Sphere(300, new point3D(-550, -500, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.setKt(0.5);
        scene.addGeometry(sphere);

        Sphere sphere2 = new Sphere(150, new point3D(-550, -500, -1000));
        sphere2.setShininess(20);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.setKt(0);
        scene.addGeometry(sphere2);

        Triangle triangle = new Triangle(new point3D(1500, -1500, -1500),
                new point3D(-1500, 1500, -1500),
                new point3D(200, 200, -375));

        Triangle triangle2 = new Triangle(new point3D(1500, -1500, -1500),
                new point3D(-1500, 1500, -1500),
                new point3D(-1500, -1500, -1500));

        triangle.setEmmission(new Color(20, 20, 20));
        triangle2.setEmmission(new Color(20, 20, 20));
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Vector(-2, -2, -3),
                new point3D(200, 200, -150), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Recursive Test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void table_SpotLight() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.setCamera(new Camera(new point3D(100, 0, 35), new Vector(1, 0, 0), new Vector(0, 0, -1)));
        Plane floor = new Plane(new Vector(-1, 0, 0), new point3D(-50, 0, 0));
        floor.setEmmission(new Color(100, 100, 100));
        //region add_obj bulding the table with 2 triangle that represent the plate of the table and 8 triangle that represent the base

        Triangle triangle1 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, 100, -50),
                new point3D(20, -100, -50));
        Triangle triangle2 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, -100, -100),
                new point3D(20, -100, -50));
        Triangle triangle_b7 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, 90, -100),
                new point3D(-50, 100, -100));
        Triangle triangle_b8 = new Triangle(
                new point3D(20, 90, -100),
                new point3D(-50, 90, -100),
                new point3D(-50, 100, -100));
        Triangle triangle_b5 = new Triangle(
                new point3D(20, -100, -100),
                new point3D(20, -90, -100),
                new point3D(-50, -100, -100));
        Triangle triangle_b6 = new Triangle(
                new point3D(20, -90, -100),
                new point3D(-50, -90, -100),
                new point3D(-50, -100, -100));
        Triangle triangle_b1 = new Triangle(
                new point3D(20, 100, -50),
                new point3D(20, 90, -50),
                new point3D(-50, 100, -50));
        Triangle triangle_b2 = new Triangle(
                new point3D(-50, 100, -50),
                new point3D(-50, 90, -50),
                new point3D(20, 90, -50));
        Triangle triangle_b3 = new Triangle(
                new point3D(20, -100, -50),
                new point3D(20, -90, -50),
                new point3D(-50, -100, -50));
        Triangle triangle_b4 = new Triangle(
                new point3D(-50, -100, -50),
                new point3D(-50, -90, -50),
                new point3D(20, -90, -50));
        //region add_mirror building the mirror with 2 tirangl ,and make refliction =1 for making the effect of the mirror
        Triangle triangle_m1 = new Triangle(
                new point3D(-50, 170, 0),
                new point3D(-50, 170, -150),
                new point3D(150, 170, 0));
        Triangle triangle_m2 = new Triangle(
                new point3D(150, 170, 0),
                new point3D(150, 170, -150),
                new point3D(-50, 170, -150));

        triangle_m1.setKr(1);
        scene.addGeometry(triangle_m1);
        triangle_m2.setKr(1);
        scene.addGeometry(triangle_m2);
        //endregion
//endregion
        //region add emmsion
        triangle1.setEmmission(new java.awt.Color(205, 133, 63));
        triangle2.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b1.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b2.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b3.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b4.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b5.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b6.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b7.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b8.setEmmission(new java.awt.Color(205, 133, 63));
        //endregion
        //region add geometry
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle_b1);
        scene.addGeometry(triangle_b2);
        scene.addGeometry(triangle_b3);
        scene.addGeometry(triangle_b4);
        scene.addGeometry(triangle_b5);
        scene.addGeometry(triangle_b6);
        scene.addGeometry(triangle_b7);
        scene.addGeometry(triangle_b8);
        scene.addGeometry(floor);
        //endregionm
        scene.addLight(new SpotLight(new Color(100, 100, 100), new Vector(0, -1, -1),
                new point3D(500, 0, 0), 0, 0.00001, 0.000005));
        ImageWriter imageWriter = new ImageWriter("tabletest_spot", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void table_dir() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.setCamera(new Camera(new point3D(100, 0, 35), new Vector(1, 0, 0), new Vector(0, 0, -1)));
        Plane floor = new Plane(new Vector(-1, 0, 0), new point3D(-50, 0, 0));
        floor.setEmmission(new Color(100, 100, 100));
        //region add_obj

        Triangle triangle1 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, 100, -50),
                new point3D(20, -100, -50));
        Triangle triangle2 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, -100, -100),
                new point3D(20, -100, -50));
        Triangle triangle_b7 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, 90, -100),
                new point3D(-50, 100, -100));
        Triangle triangle_b8 = new Triangle(
                new point3D(20, 90, -100),
                new point3D(-50, 90, -100),
                new point3D(-50, 100, -100));
        Triangle triangle_b5 = new Triangle(
                new point3D(20, -100, -100),
                new point3D(20, -90, -100),
                new point3D(-50, -100, -100));
        Triangle triangle_b6 = new Triangle(
                new point3D(20, -90, -100),
                new point3D(-50, -90, -100),
                new point3D(-50, -100, -100));
        Triangle triangle_b1 = new Triangle(
                new point3D(20, 100, -50),
                new point3D(20, 90, -50),
                new point3D(-50, 100, -50));
        Triangle triangle_b2 = new Triangle(
                new point3D(-50, 100, -50),
                new point3D(-50, 90, -50),
                new point3D(20, 90, -50));
        Triangle triangle_b3 = new Triangle(
                new point3D(20, -100, -50),
                new point3D(20, -90, -50),
                new point3D(-50, -100, -50));
        Triangle triangle_b4 = new Triangle(
                new point3D(-50, -100, -50),
                new point3D(-50, -90, -50),
                new point3D(20, -90, -50));
        Triangle triangle_m1 = new Triangle(
                new point3D(-50, 170, 0),
                new point3D(-50, 170, -150),
                new point3D(150, 170, 0));
        Triangle triangle_m2 = new Triangle(
                new point3D(150, 170, 0),
                new point3D(150, 170, -150),
                new point3D(-50, 170, -150));

        triangle_m1.setKr(1);
        scene.addGeometry(triangle_m1);
        triangle_m2.setKr(1);
        scene.addGeometry(triangle_m2);
//endregion
        //region add emmsion
        triangle1.setEmmission(new java.awt.Color(205, 133, 63));
        triangle2.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b1.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b2.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b3.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b4.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b5.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b6.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b7.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b8.setEmmission(new java.awt.Color(205, 133, 63));
        //endregion
        //region add geo
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle_b1);
        scene.addGeometry(triangle_b2);
        scene.addGeometry(triangle_b3);
        scene.addGeometry(triangle_b4);
        scene.addGeometry(triangle_b5);
        scene.addGeometry(triangle_b6);
        scene.addGeometry(triangle_b7);
        scene.addGeometry(triangle_b8);
        scene.addGeometry(floor);
        //endregion
        //  scene.addLight(new PointLight(new Color(255, 255, 102), new point3D(2500, 200, -100),
        //        0, 0.000001, 0.0000005));
        scene.addLight(new DirectionalLight(new Color(255, 255, 102), new Vector(-1, 0, -1)));
        ImageWriter imageWriter = new ImageWriter("tabletest_dir", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void table_point() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.setCamera(new Camera(new point3D(100, 0, 35), new Vector(1, 0, 0), new Vector(0, 0, -1)));
        Plane floor = new Plane(new Vector(-1, 0, 0), new point3D(-50, 0, 0));
        floor.setEmmission(new Color(100, 100, 100));
        //region add_obj

        Triangle triangle1 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, 100, -50),
                new point3D(20, -100, -50));
        Triangle triangle2 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, -100, -100),
                new point3D(20, -100, -50));
        Triangle triangle_b7 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, 90, -100),
                new point3D(-50, 100, -100));
        Triangle triangle_b8 = new Triangle(
                new point3D(20, 90, -100),
                new point3D(-50, 90, -100),
                new point3D(-50, 100, -100));
        Triangle triangle_b5 = new Triangle(
                new point3D(20, -100, -100),
                new point3D(20, -90, -100),
                new point3D(-50, -100, -100));
        Triangle triangle_b6 = new Triangle(
                new point3D(20, -90, -100),
                new point3D(-50, -90, -100),
                new point3D(-50, -100, -100));
        Triangle triangle_b1 = new Triangle(
                new point3D(20, 100, -50),
                new point3D(20, 90, -50),
                new point3D(-50, 100, -50));
        Triangle triangle_b2 = new Triangle(
                new point3D(-50, 100, -50),
                new point3D(-50, 90, -50),
                new point3D(20, 90, -50));
        Triangle triangle_b3 = new Triangle(
                new point3D(20, -100, -50),
                new point3D(20, -90, -50),
                new point3D(-50, -100, -50));
        Triangle triangle_b4 = new Triangle(
                new point3D(-50, -100, -50),
                new point3D(-50, -90, -50),
                new point3D(20, -90, -50));
        Triangle triangle_m1 = new Triangle(
                new point3D(-50, 170, 0),
                new point3D(-50, 170, -150),
                new point3D(150, 170, 0));
        Triangle triangle_m2 = new Triangle(
                new point3D(150, 170, 0),
                new point3D(150, 170, -150),
                new point3D(-50, 170, -150));

        triangle_m1.setKr(1);
        scene.addGeometry(triangle_m1);
        triangle_m2.setKr(1);
        scene.addGeometry(triangle_m2);
//endregion
        //region add emmsion
        triangle1.setEmmission(new java.awt.Color(205, 133, 63));
        triangle2.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b1.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b2.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b3.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b4.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b5.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b6.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b7.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b8.setEmmission(new java.awt.Color(205, 133, 63));
        //endregion
        //region add geo
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle_b1);
        scene.addGeometry(triangle_b2);
        scene.addGeometry(triangle_b3);
        scene.addGeometry(triangle_b4);
        scene.addGeometry(triangle_b5);
        scene.addGeometry(triangle_b6);
        scene.addGeometry(triangle_b7);
        scene.addGeometry(triangle_b8);
        scene.addGeometry(floor);
        //endregion
        scene.addLight(new PointLight(new Color(255, 255, 102), new point3D(2500, 200, -100),
                0, 0.000001, 0.0000005));
        ImageWriter imageWriter = new ImageWriter("tabletest_point", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void table_check() {
        Scene scene = new Scene();
        scene.setScreenDistance(400);
        scene.setCamera(new Camera(new point3D(400, 200, -500), new Vector(1, 0, 0), new Vector(-0.75, -0.5, 1)));
//        scene.setCamera(new Camera(new point3D(100, 0, -200), new Vector(1, 0, 0), new Vector(0, 0, 1)));

        Plane floor = new Plane(new Vector(-1, 0, 0), new point3D(-50, 0, 0));
        floor.setEmmission(new Color(100, 100, 100));
        //region add_obj

        Triangle triangle1 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, 100, -50),
                new point3D(20, -100, -50));
        Triangle triangle2 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, -100, -100),
                new point3D(20, -100, -50));
        Triangle triangle_b7 = new Triangle(
                new point3D(20, 100, -100),
                new point3D(20, 90, -100),
                new point3D(-50, 100, -100));
        Triangle triangle_b8 = new Triangle(
                new point3D(20, 90, -100),
                new point3D(-50, 90, -100),
                new point3D(-50, 100, -100));
        Triangle triangle_b5 = new Triangle(
                new point3D(20, -100, -100),
                new point3D(20, -90, -100),
                new point3D(-50, -100, -100));
        Triangle triangle_b6 = new Triangle(
                new point3D(20, -90, -100),
                new point3D(-50, -90, -100),
                new point3D(-50, -100, -100));
        Triangle triangle_b1 = new Triangle(
                new point3D(20, 100, -50),
                new point3D(20, 90, -50),
                new point3D(-50, 100, -50));
        Triangle triangle_b2 = new Triangle(
                new point3D(-50, 100, -50),
                new point3D(-50, 90, -50),
                new point3D(20, 90, -50));
        Triangle triangle_b3 = new Triangle(
                new point3D(20, -100, -50),
                new point3D(20, -90, -50),
                new point3D(-50, -100, -50));
        Triangle triangle_b4 = new Triangle(
                new point3D(-50, -100, -50),
                new point3D(-50, -90, -50),
                new point3D(20, -90, -50));
        Triangle triangle_m1 = new Triangle(
                new point3D(-50, 170, 0),
                new point3D(-50, 170, -150),
                new point3D(150, 170, 0));
        Triangle triangle_m2 = new Triangle(
                new point3D(150, 170, 0),
                new point3D(150, 170, -150),
                new point3D(-50, 170, -150));

        triangle_m1.setKr(1);
        scene.addGeometry(triangle_m1);
        triangle_m2.setKr(1);
        scene.addGeometry(triangle_m2);
//endregion
        //region add emmsion
        triangle1.setEmmission(new java.awt.Color(205, 133, 63));
        triangle2.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b1.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b2.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b3.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b4.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b5.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b6.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b7.setEmmission(new java.awt.Color(205, 133, 63));
        triangle_b8.setEmmission(new java.awt.Color(205, 133, 63));
        //endregion
        //region add geo
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle_b1);
        scene.addGeometry(triangle_b2);
        scene.addGeometry(triangle_b3);
        scene.addGeometry(triangle_b4);
        scene.addGeometry(triangle_b5);
        scene.addGeometry(triangle_b6);
        scene.addGeometry(triangle_b7);
        scene.addGeometry(triangle_b8);
        scene.addGeometry(floor);
        //endregion
        scene.addLight(new SpotLight(new Color(100, 100, 100), new Vector(0, -1, -1),
                new point3D(500, 0, 0), 0, 0.00001, 0.000005));
        ImageWriter imageWriter = new ImageWriter("tabletest_check", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void test() {
        //Scene
        Scene scene = new Scene();
        scene.setScreenDistance(100);
        scene.setBackground(new Color(0, 0, 0));
        scene.setAmbientLight(new AmbientLight());
        scene.setCamera(new Camera(new point3D(100, 0, 35), new Vector(1, 0, 0), new Vector(0, 0, -1)));

        //Sphere1
        Sphere sphere1 = new Sphere(10, new point3D(-20, 30, -40));

        // sphere1.setMaterial(new Material(0.8 ,0.8,10,1,1));
        sphere1.setEmmission(new Color(108, 0, 21));
        //Sphere2
        Sphere sphere2 = new Sphere(10,
                new point3D(-20, -30, -40));
        sphere2.setEmmission(new Color(0, 9, 108));
        // sphere2.setMaterial(new Material(0.8 ,0.8,10));

        //Plane
        Plane floor = new Plane(new Vector(-1, 0, 0), new point3D(-30, 0, 0));
        floor.setEmmission(new Color(28, 75, 14));
        // plane.setMaterial(new Material(0.7 ,0.7,10));
        scene.addGeometry(sphere1);
        scene.addGeometry(sphere2);

        //Light Source
        scene.addLight(new PointLight(new Color(255, 252, 145), new point3D(-20, 0, -40),
                0, 0.000001, 0.0000005));
        //Add To Scene
        scene.addGeometry(sphere1);
        scene.addGeometry(sphere2);
        scene.addGeometry(floor);
        //Render Image

        ImageWriter imageWriter = new ImageWriter("shadow_1", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }


}









