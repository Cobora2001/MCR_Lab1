// Authors: Thomas Vuilleumier, Sebastian Diaz

package apps;

import java.awt.event.KeyEvent;

/**
 * Interface defining the methods that an App should have.
 */
public interface App {
    /**
     * Is used to run the simulation
     */
    void run();

    /**
     * Is used to draw specific elements from the App on a Graphics object
     */
    void draw();

    /**
     * Is used to treat a key signal
     * @param e the key event
     */
    void treatKeySignal(KeyEvent e);
}
