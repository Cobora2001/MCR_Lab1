// Authors: Thomas Vuilleumier, Sebastian Diaz

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class representing the panel where the shapes are drawn.
 * Singleton pattern with the Display interface.
 */
public class GamePanel extends JPanel {
    // Singleton instance
    private static GamePanel instance;

    // Buffered image for double buffering
    private BufferedImage bufferImage;

    /**
     * Private constructor for the GamePanel class.
     */
    private GamePanel() {
        super();
        setFocusable(true);
    }

    /**
     * Initializes the buffer image.
     */
    private void initBuffer() {
        int width = getWidth();
        int height = getHeight();

        if (width > 0 && height > 0) {
            bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        } else {
            Dimension preferredSize = MainFrame.getInstance().getPreferredSize();
            bufferImage = new BufferedImage(preferredSize.width, preferredSize.height, BufferedImage.TYPE_INT_ARGB);
        }
    }

    /**
     * Returns the only instance of GamePanel.
     * @return the GamePanel instance.
     */
    public static GamePanel getInstance() {
        if (instance == null) {
            instance = new GamePanel();
        }
        return instance;
    }

    /**
     * Paints the component.
     * @param g the Graphics object.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bufferImage == null) {
            initBuffer();
        }

        if (bufferImage != null) {
            g.drawImage(bufferImage, 0, 0, null);
        }
    }

    /**
     * Repaints the component.
     */
    public void refresh() {
        repaint();
    }

    /**
     * Returns the buffered image.
     * @return the buffered image.
     */
    public BufferedImage getBufferImage() {
        if (bufferImage == null || getWidth() != bufferImage.getWidth() || getHeight() != bufferImage.getHeight()) {
            initBuffer();
        }
        return bufferImage;
    }

}
