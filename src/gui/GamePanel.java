package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import movement.FieldDimensions;

/**
 * Class representing the panel where the shapes are drawn
 * Singleton pattern with the Display interface
 */
public class GamePanel extends JPanel {
    private static GamePanel instance;
    private FieldDimensions fieldDimensions = null;
    private BufferedImage bufferImage;

    private GamePanel() {
        super();
        setFocusable(true);
        setPreferredSize(new Dimension(800, 600)); // Taille par défaut
    }

    private void initBuffer() {
        // Attendre que GamePanel ait une taille valide
        int width = getWidth();
        int height = getHeight();

        if (width > 0 && height > 0) {
            bufferImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }
    }

    /**
     * Returns the only instance of GamePanel
     * @return the GamePanel instance
     */
    public static GamePanel getInstance() {
        if (instance == null) {
            instance = new GamePanel();
        }
        return instance;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (bufferImage == null) {
            initBuffer(); // Initialiser le buffer seulement quand la fenêtre est prête
        }

        if (bufferImage != null) {
            g.drawImage(bufferImage, 0, 0, null);
        }
    }

    public void refresh() {
        repaint();
    }

    public BufferedImage getBufferImage() {
        if (bufferImage == null || getWidth() != bufferImage.getWidth() || getHeight() != bufferImage.getHeight()) {
            initBuffer();
        }
        return bufferImage;
    }

    public void setFieldDimensions(FieldDimensions fieldDimensions) {
        this.fieldDimensions = fieldDimensions;
    }

    public FieldDimensions getFieldDimensions() {
        return fieldDimensions;
    }
}
