
package abstraction.class_problems;

import java.util.Scanner;

abstract class StaffMember {
    protected String name;

    public StaffMember(String name) {
        this.name = name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends StaffMember {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends StaffMember {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double calculatePay() {
        return stipend;
    }
}

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalPayroll = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            StaffMember staff;

            switch (type) {
                case "FULLTIME":
                    double salary = sc.nextDouble();
                    staff = new FullTimeStaff(name, salary);
                    break;

                case "HOURLY":
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    staff = new HourlyStaff(name, hours, rate);
                    break;

                case "INTERN":
                    double stipend = sc.nextDouble();
                    staff = new InternStaff(name, stipend);
                    break;

                default:
                    continue;
            }

            double pay = staff.calculatePay();
            System.out.printf("%s: %.2f%n", staff.name, pay);
            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}
