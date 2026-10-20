
package abstraction.class_problems;

import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;
    protected static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();
    public abstract String getMode();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return distance * 2.0;
    }

    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return distance * 1.5;
    }

    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return 2500 + distance * 4.0;
    }

    public String getMode() {
        return "FLIGHT";
    }
}

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            TravelBooking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;

                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;

                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;

                default:
                    continue;
            }

            System.out.printf(
                    "%s: %.2f%n",
                    booking.getMode(),
                    booking.calculateTotalFare()
            );
        }

        sc.close();
    }
}
