
import java.util.Scanner;

abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20.0;
    protected int count;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getBasePrice();

    public double calculateAmount() {
        return (getBasePrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    public double getBasePrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    public double getBasePrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    public double getBasePrice() {
        return 400.0;
    }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String seatType = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            switch (seatType) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
                default:
                    continue;
            }

            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n", seatType, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
