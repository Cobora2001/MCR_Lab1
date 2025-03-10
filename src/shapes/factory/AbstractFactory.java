package shapes.factory;


import shapes.Bouncable;

public interface AbstractFactory {
    Bouncable createCircle();
    Bouncable createSquare();
}
