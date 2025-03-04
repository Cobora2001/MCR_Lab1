package shapes;

import movement.BouncingMovement;

import java.awt.Graphics;
import java.awt.Color;

public class Square extends Shape{
    public Square(int x, int y, int size, int dx, int dy) {
        super(x, y, size, dx, dy, new BouncingMovement());
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(getX(),getY(), getSize(), getY());
    }
}
