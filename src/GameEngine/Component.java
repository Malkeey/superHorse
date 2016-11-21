/**
 *
 *
 * @author Daniel Karlsson 2016
 */
package GameEngine;


public abstract class Component {

    // Holds components used to create game objects
    
    protected GameObject owner;
    protected Constants.ComponentType compType;
    
    public void tick(float delta) {
        
    }
    
    public Constants.ComponentType getType() {
        return compType;
    }
    
    public Transform getOwnerTransform() {
        return owner.getTransform();
    }
    
    public void setOwner(GameObject owner) {
        this.owner = owner;
    }

}
