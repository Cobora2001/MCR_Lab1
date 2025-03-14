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
    private static MainFrame instance;
    private static final int width = 800;
    private static final int height = 600;
    private final GamePanel gamePanel = GamePanel.getInstance();

    private MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(gamePanel);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
        gamePanel.requestFocusInWindow();
        gamePanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int panelWidth = gamePanel.getWidth();
                int panelHeight = gamePanel.getHeight();
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

    @Override
    public void addKeyListener(KeyAdapter ka) {
        super.addKeyListener(ka);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }

    public void setPreferredSize(Dimension dimension) {
        gamePanel.setPreferredSize(dimension);
        pack();
    }

    public FieldDimensions getFieldDimensions() {
        return gamePanel.getFieldDimensions();
    }

    public void setFieldDimensions(FieldDimensions fieldDimensions) {
        gamePanel.setFieldDimensions(fieldDimensions);
    }
}
