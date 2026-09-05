package string.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program5 {

    public static void printFilteredWordFrequency(String feedback) {

        // Convert text to lowercase
        String cleanedText = feedback.toLowerCase();

        // Remove punctuation
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        // Split text into words
        String[] words = cleanedText.split("\\s+");

        // Stop words
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {
                frequencyMap.put(
                        word,
                        frequencyMap.getOrDefault(word, 0) + 1
                );
            }
        }

        // Convert map entries into an array
        Map.Entry<String, Integer>[] entries =
                frequencyMap.entrySet().toArray(
                        new Map.Entry[0]
                );

        // Sort by frequency in descending order
        for (int i = 0; i < entries.length - 1; i++) {

            for (int j = i + 1; j < entries.length; j++) {

                if (entries[j].getValue() > entries[i].getValue()) {

                    Map.Entry<String, Integer> temp = entries[i];
                    entries[i] = entries[j];
                    entries[j] = temp;
                }
            }
        }

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}