package shapes;

import movement.MovementStrategy;

import java.awt.*;

public abstract class Shape {
    protected int x, y, size, dx, dy;
    protected MovementStrategy movementStrategy;

    public Shape(int x, int y, int size, int dx, int dy, MovementStrategy m) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        this.dy = dy;
        this.movementStrategy = m;
    }

    public void move(int width, int height) {
        movementStrategy.move(this, width, height);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getSize() {
        return size;
    }
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dy) {
        this.dy = dy;
    }
}
