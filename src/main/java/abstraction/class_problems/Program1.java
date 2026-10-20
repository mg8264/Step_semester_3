package abstraction.class_problems;
import java.util.Scanner;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();
    public abstract String getShape();
}

class Circle extends Plot {
    private double radius;

    public Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    private double length;
    private double width;

    public Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    private double base;
    private double height;

    public Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }

    public String getShape() {
        return "TRIANGLE";
    }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    double radius = sc.nextDouble();
                    plot = new Circle(owner, radius);
                    break;

                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plot = new Rectangle(owner, length, width);
                    break;

                case "TRIANGLE":
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plot = new Triangle(owner, base, height);
                    break;

                default:
                    continue;
            }

            double area = plot.calculateArea();

            System.out.printf(
                    "%s (%s): %.2f%n",
                    plot.owner, plot.getShape(), area
            );

            totalArea += area;
        }

        System.out.printf("Total Area: %.2f%n", totalArea);
        sc.close();
    }
}
