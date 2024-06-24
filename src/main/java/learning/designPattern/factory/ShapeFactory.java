package learning.designPattern.factory;

public class ShapeFactory {

    public Shape createShape(String type) {
        return switch (type) {
            case "Rectangle" -> new Rectangle();
            case "Square" -> new Square();
            default -> throw new NullPointerException("This is not a Valid shape");
        };
    }
}
