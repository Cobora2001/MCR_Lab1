package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import apps.App;

/**
 * Class representing the panel where the shapes are drawn
 * Singleton pattern with the Display interface
 */
public class GamePanel extends JPanel implements Displayer {

    private static final int width = 800;
    private static final int height = 600;
    private static GamePanel instance;
    private App app;

    @Override
    public int getWidth() {return super.getWidth();}
    @Override
    public int getHeight() {return super.getHeight();}
    @Override
    public Graphics2D getGraphics() {
        // ⚠️ Do not use this method to draw shapes, use repaint instead!!!
        return (Graphics2D) super.getGraphics(); // Cast valid because we use a JPanel
    }

    @Override
    public void repaint() { super.repaint();}
    @Override
    public void setTitle(String title) { MainFrame.getInstance().setTitle(title);}

    @Override
    public void addKeyListener(KeyAdapter ka) {
        super.addKeyListener(ka);
    }

    private GamePanel() {
        super();
        this.app = null;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e);
            }
        });
    }

    /**
     * Returns the only instance of GamePanel
     * @return the GamePanel instance
     */
    public static GamePanel getInstance() {
        if(instance == null) {
            instance = new GamePanel();
        }
        return instance;
    }

    /**
     * Sets the app to be displayed
     * @param app the app to be displayed
     */
    public void setApp(App app) {
        this.app = app;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //the shapes are drawn using repaint
        super.paintComponent(g);
        if(app != null)
            app.draw();
    }

    private void handleKeyPressed(KeyEvent e) {
        if(app != null)
            app.treatKeySignal(e);
    }
}
