
package dsa_fundamental.class_problems;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();

        System.out.println("Reversed: " + reversed);

        if (word.equalsIgnoreCase(reversed.toString())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }

        sc.close();
    }
}
