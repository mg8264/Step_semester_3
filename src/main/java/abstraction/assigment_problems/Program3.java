
import java.util.Scanner;

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();
}

interface BusUser {
    double BUS_FEE = 12000.0;
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    public double calculateFee() {
        return 40000.0 + BUS_FEE;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    public double calculateFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    public ScholarshipStudent(String name) {
        super(name);
    }

    public double calculateFee() {
        return 20000.0 + BUS_FEE;
    }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    continue;
            }

            double fee = student.calculateFee();
            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
