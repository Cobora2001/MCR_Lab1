package shapes;

import movement.BouncingMovement;

import java.awt.Graphics;
import java.awt.Color;

public class Circle extends Shape {
    public Circle(int x, int y, int size, int dx, int dy) {
        super(x, y, size, dx, dy, new BouncingMovement());
    }
}
