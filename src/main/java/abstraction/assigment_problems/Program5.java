
import java.util.Scanner;

interface SaverMode {
    double SAVING_FACTOR = 0.75;

    default double calculateSavedUnits(double units) {
        return units * SAVING_FACTOR;
    }
}

abstract class Appliance {
    protected double hours;
    protected double power;

    public Appliance(double hours, double power) {
        this.hours = hours;
        this.power = power;
    }

    public double calculateUnits() {
        return power * hours / 1000.0;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours, 150.0);
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours) {
        super(hours, 1500.0);
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super(hours, 100.0);
    }
}

class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine(double hours) {
        super(hours, 500.0);
    }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            if (sc.hasNextLine()) {
                String remaining = sc.nextLine().trim();
                saverRequested = remaining.equals("SAVER");
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    continue;
            }

            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not available");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested) {
                units = ((SaverMode) appliance).calculateSavedUnits(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
