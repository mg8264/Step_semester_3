
package abstraction.class_problems;

import java.util.Scanner;

abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }

        return 100 * 5 + (units - 100) * 7;
    }

    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        return units * 8 + 100;
    }

    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super(units);
    }

    public double calculateBill() {
        return Math.max(units * 6, 1000);
    }

    public String getType() {
        return "FACTORY";
    }
}

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            ElectricityConnection connection;

            switch (type) {
                case "HOME":
                    connection = new HomeConnection(units);
                    break;

                case "SHOP":
                    connection = new ShopConnection(units);
                    break;

                case "FACTORY":
                    connection = new FactoryConnection(units);
                    break;

                default:
                    continue;
            }

            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n", connection.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

