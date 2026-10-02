package inheritance.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();

    public LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getBorrowingDays());
    }
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    @Override
    public int getBorrowingDays() {
        return 3;
    }
}

public class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));
            String title = line.substring(line.indexOf(" ") + 1);

            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            System.out.println(
                    item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}