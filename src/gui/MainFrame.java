// Authors: Thomas Vuilleumier, Sebastian Diaz

package gui;

import movement.FieldDimensions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;

/**
 * This class represents the main frame of the application.
 * Singleton pattern
 */
public class MainFrame extends JFrame implements Displayer {
    // Singleton pattern instance
    private static MainFrame instance;

    // Width and height of the frame (preferred size, not fixed size)
    private static final int width = 800;
    private static final int height = 600;

    // Game panel of the frame
    private final GamePanel gamePanel = GamePanel.getInstance();

    /**
     * Private constructor for the MainFrame class, to ensure only one instance is created.
     */
    private MainFrame() {
        // Allow the user to close the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the game panel as the content pane
        setContentPane(gamePanel);

        // Set the preferred size of the frame and pack it
        setPreferredSize(new Dimension(width, height));

        // Show the frame
        setVisible(true);

        // Request focus in window
        gamePanel.requestFocusInWindow();

        // Add a component listener to the game panel
        gamePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Update the field dimensions when the panel is resized
                int panelWidth = gamePanel.getWidth();
                int panelHeight = gamePanel.getHeight();
                // Update the field dimensions
                // (Do not change the reference of the object using setFieldDimensions!)
                gamePanel.getFieldDimensions().setMaxX(panelWidth);
                gamePanel.getFieldDimensions().setMaxY(panelHeight);
                repaint();
            }
        });
    }

    /**
     * Returns the only instance of MainFrame
     * @return the MainFrame instance
     */
    public static MainFrame getInstance() {
        if(instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    /**
     * Sets the title of the frame.
     * @param title the title to be displayed in the frame's border.
     */
    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    /**
     * Adds a key listener to the frame.
     * @param ka the key adapter to be added to the frame.
     */
    @Override
    public void addKeyListener(KeyAdapter ka) {
        gamePanel.addKeyListener(ka);
    }


    @Override
    public void repaint() {
        super.repaint();
    }

    /**
     * Returns the width of the frame.
     * @return the width of the frame.
     */
    @Override
    public int getWidth() {
        return super.getWidth();
    }

    /**
     * Returns the height of the frame.
     * @return the height of the frame.
     */
    @Override
    public int getHeight() {
        return super.getHeight();
    }

    /**
     * Returns the graphics object of the frame.
     * @return the graphics object of the frame.
     */
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }

    /**
     * Sets the preferred size of the frame.
     * @param dimension the dimension to set.
     */
    public void setPreferredSize(Dimension dimension) {
        gamePanel.setPreferredSize(dimension);
        pack();
    }

    /**
     * Returns the preferred size of the frame.
     * @return the preferred size of the frame.
     */
    public Dimension getPreferredSize() {
        return gamePanel.getPreferredSize();
    }

    /**
     * Returns the game panel of the frame.
     * @return the game panel of the frame.
     */
    public FieldDimensions getFieldDimensions() {
        return gamePanel.getFieldDimensions();
    }

    /**
     * Sets the field dimensions of the frame.
     * @param fieldDimensions the field dimensions to set.
     */
    public void setFieldDimensions(FieldDimensions fieldDimensions) {
        gamePanel.setFieldDimensions(fieldDimensions);
    }
}
