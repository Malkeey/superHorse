/**
 *
 *
 * @author Daniel Karlsson 2016
 */
package GameEngine;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.Clip;

import GameEngine.Constants.Event;

public class Sound extends Component {

    //Sound related data, such as what file to play and at what volume
    //Possibly playback speed etc
    
    double volume = 1;
    HashMap<Event, File> eventClips = new HashMap<Event, File>();
    
    public Sound(String path, Event event) {
        compType = Constants.ComponentType.sound;
        File temp = Constants.theLoader.loadSound(path);
        if(temp != null) {
            eventClips.put(event, temp);
        }
    }
    
    public File getEventSound(Event event) {
        return eventClips.get(event);
    }
    
}
