/**
 *
 *
 * @author Daniel Karlsson 2016
 */
package GameEngine;

import java.awt.image.BufferedImage;

public class Graphic extends Component {

    //Contains graphical data based on information in the component class
    
    private BufferedImage sprite;
    private in height, width;
    
    public Graphic(String imagePath, int height, int width) {
        compType = Constants.ComponentType.graphic;
        this.height = height;
        this.width = width;
        
        if(imagePath != null) {
            sprite = Constants.theLoader.loadImage(imagePath);
        }
    }
    
    public BufferedImage getSprite() {
        return sprite;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }

}
