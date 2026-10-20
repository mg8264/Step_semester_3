
package dsa_fundamental.class_problems;

import java.util.Scanner;

public class Program10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        int mark1 = sc.nextInt();
        int mark2 = sc.nextInt();
        int mark3 = sc.nextInt();

        double average = (mark1 + mark2 + mark3) / 3.0;
        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 60) {
            grade = 'C';
        } else if (average >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Name: " + name.toUpperCase());
        System.out.printf("Average: %.1f%n", average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
