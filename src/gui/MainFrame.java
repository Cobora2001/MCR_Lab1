// Authors: Thomas Vuilleumier, Sebastian Diaz

package gui;

import movement.FieldDimensions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class represents the main frame of the application.
 * Singleton pattern
 */
public class MainFrame extends JFrame implements Displayer {
    // Singleton instance
    private static MainFrame instance;

    // Desired content pane dimensions
    private static final int width = 800;
    private static final int height = 600;

    // Game panel of the frame
    private final GamePanel gamePanel = GamePanel.getInstance();

    /**
     * Private constructor for the MainFrame class.
     */
    private MainFrame() {
        // Allow the user to close the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the game panel as the content pane
        setContentPane(gamePanel);
        // Set the preferred size on the content pane
        getContentPane().setPreferredSize(new Dimension(width, height));
        pack();

        // Show the frame
        setVisible(true);

        // Request focus in window
        gamePanel.requestFocusInWindow();

        // Add a component listener to update field dimensions on resize

        gamePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resetSize();
                repaint();
            }
        });

        // Add a window listener to update the field dimensions once the frame is shown.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                resetSize();
            }
        });
    }

    private void resetSize() {
        Dimension size = gamePanel.getSize();
        FieldDimensions.getInstance().setMaxX(size.width);
        FieldDimensions.getInstance().setMaxY(size.height);
    }

    /**
     * Returns the only instance of MainFrame.
     * @return the MainFrame instance.
     */
    public static MainFrame getInstance() {
        if (instance == null) {
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

    /**
     * Repaints the frame.
     */
    @Override
    public void repaint() {
        super.repaint();
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
     * Sets the preferred size of the content pane.
     * @param dimension the dimension to set.
     */
    public void setPreferredSize(Dimension dimension) {
        getContentPane().setPreferredSize(dimension);
        pack();
    }

    /**
     * Returns the preferred size of the content pane.
     * @return the preferred size of the content pane.
     */
    @Override
    public Dimension getPreferredSize() {
        return getContentPane().getPreferredSize();
    }
}
