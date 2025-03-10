package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import apps.App;
import movement.FieldDimensions;

/**
 * Class representing the panel where the shapes are drawn
 * Singleton pattern with the Display interface
 */
public class GamePanel extends JPanel implements Displayer {

    private static final int width = 800;
    private static final int height = 600;
    private static GamePanel instance;
    private Image buffer;
    private App app;
    private FieldDimensions fieldDimensions = null;

    @Override
    public int getWidth() {return super.getWidth();}
    @Override
    public int getHeight() {return super.getHeight();}
    @Override
    public Graphics2D getGraphics() {
        return buffer == null ? null : (Graphics2D) buffer.getGraphics();
    }

    @Override
    public void repaint() { super.repaint();}
    @Override
    public void setTitle(String title) { MainFrame.getInstance().setTitle(title);}

    @Override
    public void addKeyListener(KeyAdapter ka) {
        super.addKeyListener(ka);
    }

    public void setFieldDimensions(FieldDimensions fieldDimensions) {
        this.fieldDimensions = fieldDimensions;
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
        buffer = createImage(width, height);
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
        buffer = createImage(getWidth(), getHeight());
        if(app != null)
            app.draw();
        g.drawImage(buffer, 0, 0, this);
    }

    private void handleKeyPressed(KeyEvent e) {
        if(app != null)
            app.treatKeySignal(e);
    }
}
