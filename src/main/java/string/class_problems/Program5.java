package string.class_problems;

import java.util.Scanner;

public class Program5 {

    public static String[] findShortestAndLongestWord(String text) {

        String[] words = text.split(" ");

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {

            if (word.length() < shortest.length()) {
                shortest = word;
            }

            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] result = findShortestAndLongestWord(text);

        System.out.println("Shortest Word: " + result[0]);
        System.out.println("Longest Word: " + result[1]);

        sc.close();
    }
}