package string.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Program5 {

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 7.0 && codingScore >= 60;
    }

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        String getName() {
            return name;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }
    }

    static Candidate[] shortlistAndRank(Candidate[] candidates) {

        int count = 0;

        for (Candidate candidate : candidates) {

            if (isEligible(candidate.cgpa, candidate.codingScore)) {
                count++;
            }
        }

        Candidate[] shortlisted = new Candidate[count];

        int index = 0;

        for (Candidate candidate : candidates) {

            if (isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[index] = candidate;
                index++;
            }
        }

        Arrays.sort(shortlisted);

        return shortlisted;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Enter details for candidate " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Coding Score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(
                    name,
                    cgpa,
                    codingScore
            );
        }

        Candidate[] result = shortlistAndRank(candidates);

        System.out.println("\nShortlisted Candidates:");

        for (Candidate candidate : result) {
            System.out.println(
                    candidate.getName()
                            + " - Composite Score: "
                            + candidate.getCompositeScore()
            );
        }
    }
}