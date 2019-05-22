package elements;
        import geometries.Plane;
        import geometries.Sphere;
        import geometries.Triangle;
        import org.junit.Test;
        import primitives.Material;
        import primitives.Vector;
        import primitives.point3D;
        import renderer.ImageWriter;
        import renderer.Render;
        import scene.Scene;

        import java.awt.*;
        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.Assert.*;

public class LightTest
{
    @Test
    public void emmissionTest(){

        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(new Sphere(30, new point3D(0.0, 0.0, -50)));

        Triangle triangle = new Triangle(new point3D( 100, 0, -49),
                new point3D(  0, 100, -49),
                new point3D( 100, 100, -49));

        Triangle triangle2 = new Triangle(new point3D( 100, 0, -49),
                new point3D(  0, -100, -49),
                new point3D( 100,-100, -49));
        triangle2.setEmmission(new Color(50, 200, 50));

        Triangle triangle3 = new Triangle(new point3D(-100, 0, -49),
                new point3D(  0, 100, -49),
                new point3D(-100, 100, -49));
        triangle3.setEmmission(new Color (50, 50, 200));

        Triangle triangle4 = new Triangle(new point3D(-100, 0, -49),
                new point3D(  0,  -100, -49),
                new point3D(-100, -100, -49));
        triangle4.setEmmission(new Color (200, 50, 50));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmission_test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }
    @Test
    public void spotLightTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(100, 100, 100), new Vector(2, 2, -3),
                new point3D(500, -200, -100), 0, 0.00001, 0.000005));
        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();

    }
    @Test
    public void spotLightTest3(){

        Scene scene = new Scene();

        Triangle triangle = new Triangle(new point3D(  3500,  3500, -2000),
                new point3D( -3500, -3500, -1000),
                new point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new point3D(  3500,  3500, -2000),
                new point3D( -3500,  3500, -1000),
                new point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100),
                new Vector(-2, -2, -3),
                new point3D(200, 200, -100), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
    @Test
    public void spotLightTest2(){

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500, new point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new point3D(-125, -225, -260),
                new point3D(-225, -125, -260),
                new point3D(-225, -225, -270));

        triangle.setEmmission(new Color (0, 0, 100));
        triangle.setShininess(4);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Vector(2, 2, -3),
                new point3D(-200, -200, -150), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }
    @Test
    public void shadowTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new point3D(0.0, 0.0, -1000));
        sphere.setShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        Triangle triangle = new Triangle(new point3D(  3500,  3500, -2000),
                new point3D( -3500, -3500, -1000),
                new point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new point3D(  3500,  3500, -2000),
                new point3D( -3500,  3500, -1000),
                new point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Vector(-2, -2, -3),
                new point3D(200, 200, -100), 0, 0.000001, 0.0000005));
        ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();

    }
    @Test
    public void shadowTest1() {
        //Scene
        Scene scene=new Scene();
        scene.setCamera(new Camera(new point3D(50.0, 20.0 , 30), new Vector(0.0, 1.0, 0.0), new Vector(0.0, 0.0, -1.0)));
        scene.setScreenDistance(150);
        scene.setBackground(new Color(0, 0, 0));
        scene.setAmbientLight(new AmbientLight());
        //Sphere1
        Sphere sphere1 = new Sphere(10, new point3D(30,-20, -40));
        sphere1.setEmmission( new Color(108, 0, 21));
        sphere1.setMaterial(new Material());
        //Sphere2
        Sphere sphere2 = new Sphere(10, new point3D(-30, -20, -40));
        sphere2.setEmmission(  new Color(0, 9, 108));
        sphere2.setMaterial(new Material());

        //Plane
        Plane plane = new Plane(new Vector(0,50,0),new point3D(0,-30,0));
        plane.setEmmission(new Color(28, 75, 14));
        plane.setMaterial(new Material());


        //Light Sources
        List<LightSource> lights = new ArrayList<LightSource>();
        PointLight pointLight1=new PointLight(new Color(255, 252, 145),new point3D(20 ,20, -40),0.1, 0.01 ,0.001);
        PointLight pointLight = new PointLight(new Color(255, 252, 145),
                new point3D(0 ,15, -40),0.1, 0.01 ,0.001);

        //Add To Scene
        scene.addGeometry(sphere1);
        scene.addGeometry(sphere2);
        scene.addGeometry(plane);
        //  scene.addLight(pointLight);
        scene.addLight(pointLight1);


        //Render Image


        ImageWriter imageWriter = new ImageWriter("ShadowTest1",501, 501, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.renderImage();
        render.writeToImage();
    }


}