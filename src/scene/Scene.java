package scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import elements.AmbientLight;
import elements.Camera;
import elements.LightSource;
import geometries.Geometry;
public class Scene {
    protected Color background;
    protected  AmbientLight ambientLight;
    protected List<Geometry> geomtries=new ArrayList<Geometry>();
    protected Camera camera;
    protected double screenDistance;
    protected List<LightSource>lights=new ArrayList<LightSource>();
    protected String sceneName="scene";
    //region constractors
    public Scene(){
        background = new Color(0, 0, 0);
        ambientLight = new AmbientLight();
        setCamera(new Camera());
        screenDistance = 100;
    }
    public Scene(Scene sce) {
        background = sce.getBackground();
        ambientLight = sce.getAmbientLight();
        geomtries = sce.geomtries;
        lights = sce.lights;
        camera = sce.getCamera();
        screenDistance = sce.screenDistance;
    }
    public Scene(AmbientLight aLight, Color background, Camera camera, double screenDistance){

        this.background = background;
        ambientLight = new AmbientLight(aLight);
        setCamera(new Camera(camera));
        this.screenDistance = screenDistance;
    }
    //endregion
    //region getter , setter

    public Color        getBackground()     { return background;                     }
    public AmbientLight getAmbientLight()   { return new AmbientLight(ambientLight); }
    public Camera       getCamera()         { return new Camera(camera);         	  }
    public String       getSceneName()      { return sceneName;					  }
    public double       getScreenDistance() { return screenDistance;	              }

    public void setBackground(Color _background)           { this.background = _background;                       }
    public void setAmbientLight(AmbientLight _ambientLight) { this.ambientLight = new AmbientLight(_ambientLight); }
    public void setCamera(Camera _camera)                   { this.camera = new Camera(_camera);                    }
    public void setSceneName(String _sceneNAme)             { this.sceneName = _sceneNAme;						   }
    public void setScreenDistance(double _screenDistance)   { this.screenDistance = _screenDistance;          	   }



//endregion
    public void addGeometry(Geometry geometry){
        geomtries.add(geometry);
    }
    public Iterator<Geometry> getGeometriesIterator(){
        return geomtries.iterator();
    }

    public void addLight(LightSource light){
        lights.add(light);
    }

    public Iterator<LightSource> getLightsIterator(){
        return lights.iterator();
    }


}
