package string.class_problems;

import java.util.Scanner;

public class Program3 {

    public static String validateCustomerId(String customerId) {

        if (customerId.startsWith("VIP-")) {
            return "VIP Customer";
        }

        return "Regular Customer";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine();

        String result = validateCustomerId(customerId);

        System.out.println("Customer Type: " + result);

        sc.close();
    }
}