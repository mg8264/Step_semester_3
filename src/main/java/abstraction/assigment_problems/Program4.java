
import java.util.Scanner;

interface NightService {
    double NIGHT_MULTIPLIER = 1.20;

    default double applyNightFare(double fare) {
        return fare * NIGHT_MULTIPLIER;
    }
}

abstract class Cab {
    protected double distance;

    public Cab(double distance) {
        this.distance = distance;
    }

    public abstract double getRatePerKm();

    public double calculateFare() {
        return Math.max(100.0, distance * getRatePerKm());
    }
}

class MiniCab extends Cab {
    public MiniCab(double distance) {
        super(distance);
    }

    public double getRatePerKm() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double distance) {
        super(distance);
    }

    public double getRatePerKm() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double distance) {
        super(distance);
    }

    public double getRatePerKm() {
        return 18.0;
    }
}

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(distance);
                    break;
                case "SEDAN":
                    cab = new SedanCab(distance);
                    break;
                case "SUV":
                    cab = new SUVCab(distance);
                    break;
                default:
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
