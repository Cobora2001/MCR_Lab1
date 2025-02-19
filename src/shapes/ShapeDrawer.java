package shapes;

import java.awt.*;

public class ShapeDrawer {
    public static void draw(Shape shape, Graphics g) {
        if (shape instanceof Circle) {
            drawCircle((Circle) shape, g);
        } else if (shape instanceof Square) {
            drawSquare((Square) shape, g);
        }
    }

    private static void drawCircle(Circle circle, Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(circle.getX(), circle.getY(), circle.getSize(), circle.getSize());
    }

    private static void drawSquare(Square square, Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(square.getX(), square.getY(), square.getSize(), square.getSize());
    }
}
