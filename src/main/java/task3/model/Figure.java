package task3.model;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Figure {
    final int x;
    final int y;
    final HashSet<Coordinate> elements;
    Color color;

    public Figure(int x, int y, HashSet<Coordinate> elements) {
        this.x = x;
        this.y = y;
        this.elements = elements;
    }

    public Figure moveDown(){
        return new Figure(x, y + 1, elements);
    }

    public Figure moveHorizontal(int dx){
        return new Figure(x + dx, y, elements);
    }

    public Set<Coordinate> getAbsoluteCoordinates() {
        Set<Coordinate> ans = new HashSet<>();
        elements.forEach(
                coordinate -> {
                    ans.add(coordinate.move(x, y));
                }
        );
        return ans;
    }

    public HashSet<Coordinate> getCoordinates(){
        return elements;
    }

    public Color getColor(){
        return color;
    }
}
