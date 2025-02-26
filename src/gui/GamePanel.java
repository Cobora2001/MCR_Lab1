package gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Displayer {

    @Override
    public int getWidth() {return super.getWidth();}
    @Override
    public int getHeight() {return super.getHeight();}
    @Override
    public Graphics2D getGraphics() {return (Graphics2D) super.getGraphics();} // Cast valid because we use a JPanel
    @Override
    public void repaint() { super.repaint();}
    @Override
    public void setTitle(String title) { super.setName(title);}

    private static GamePanel instance;

    private GamePanel() {
        super();
    }

    public void setPreferredSize(int width, int height) {
        super.setPreferredSize(new Dimension(width, height));
    }

    public static GamePanel getInstance() {
        if(instance == null) {
            instance = new GamePanel();
        }
        return instance;
    }



}
