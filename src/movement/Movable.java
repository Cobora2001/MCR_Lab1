package movement;

public interface Movable {
    int x = 0;
    int y = 0;
    int dx = 0;
    int dy = 0;
    int size = 0;

    int getX();
    int getY();
    int getSize();
    int getDx();
    int getDy();

    void setX(int x);
    void setY(int y);
    void setDx(int dx);
    void setDy(int dy);
    void setSize(int size);
}
