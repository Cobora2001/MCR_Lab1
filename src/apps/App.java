package apps;

import java.awt.event.KeyEvent;

public interface App {
    /**
     * Is used to draw specific elements from the App on a Graphics object
     */
    public void draw();
    public void treatKeySignal(KeyEvent e);
}
