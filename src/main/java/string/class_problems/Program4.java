package string.class_problems;

import java.util.Scanner;

public class Program4 {

    private static double rowAverage(int[] row) {

        int sum = 0;

        for (int value : row) {
            sum = sum + value;
        }

        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {

        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {

            double average = rowAverage(seatingScores[i]);

            if (average >= threshold) {
                result = result + "Row " + (i + 1) + ": Buzzing\n";
            } else {
                result = result + "Row " + (i + 1) + ": Quiet\n";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        int[][] seatingScores = new int[rows][];

        for (int i = 0; i < rows; i++) {

            System.out.print("Enter number of scores in row " + (i + 1) + ": ");
            int n = sc.nextInt();

            seatingScores[i] = new int[n];

            System.out.println("Enter scores:");

            for (int j = 0; j < n; j++) {
                seatingScores[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = sc.nextInt();

        String result = classifyRows(seatingScores, threshold);

        System.out.println(result);
    }
}