package string.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class Program5 {

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 10 && !injured;
    }

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private boolean injured;
        private double fantasyPoints;

        Player(String name, int matchesPlayed,
               boolean injured, double fantasyPoints) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.injured = injured;
            this.fantasyPoints = fantasyPoints;
        }

        String getName() {
            return name;
        }

        double getFantasyPoints() {
            return fantasyPoints;
        }

        @Override
        public int compareTo(Player other) {

            return Double.compare(
                    other.fantasyPoints,
                    this.fantasyPoints
            );
        }
    }

    static Player[] draftAndRank(Player[] players) {

        int count = 0;

        for (Player player : players) {

            if (isDraftable(
                    player.matchesPlayed,
                    player.injured)) {

                count++;
            }
        }

        Player[] shortlisted = new Player[count];

        int index = 0;

        for (Player player : players) {

            if (isDraftable(
                    player.matchesPlayed,
                    player.injured)) {

                shortlisted[index] = player;
                index++;
            }
        }

        Arrays.sort(shortlisted);

        return shortlisted;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println(
                    "\nEnter details for player " + (i + 1)
            );

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Matches Played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            System.out.print("Fantasy Points: ");
            double fantasyPoints = sc.nextDouble();

            sc.nextLine();

            players[i] = new Player(
                    name,
                    matchesPlayed,
                    injured,
                    fantasyPoints
            );
        }

        Player[] result = draftAndRank(players);

        System.out.println("\nDrafted Players:");

        for (Player player : result) {

            System.out.println(
                    player.getName()
                            + " - Fantasy Points: "
                            + player.getFantasyPoints()
            );
        }
    }
}
