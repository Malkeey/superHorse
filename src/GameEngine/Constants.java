/**
 *
 *
 * @author Daniel Karlsson 2016
 */
package GameEngine;


public final class Constants {

    //Holds constants for the game
    
    //Holds references to all sub-systems and game engine
    
    public static enum ComponentType {graphic, physics, sound, controller, collider};
    public static enum Event {collision};
    
    public static GameEngine theGameEngine = null;
    public static InputHandler theInputHandler = null;
    public static Loader theLoader = null;
    public static PhysicsEngine thePhysicsEngine = null;
    public static Renderer theRenderer = null;
    public static SoundEngine theSoundEngine = null;

}
