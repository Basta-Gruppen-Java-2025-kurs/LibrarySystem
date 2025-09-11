package main;

import java.util.List;

public final class LoanSystem {

    private LoanSystem() {}

    public static boolean borrowBook(List<Boolean> available,
                                     List<String> borrowers,
                                     List<String> borrowedBooks,
                                     int bookIndex,
                                     String borrowerName) {
        if (!isValidIndex(bookIndex, available, borrowers, borrowedBooks))
            throw new RuntimeException("Invalid book index");

        boolean isAvailable = available.get(bookIndex);
        if (!isAvailable) return false;

        available.set(bookIndex, false);
        borrowers.add(borrowerName);
        borrowedBooks.add(String.valueOf(bookIndex)); // ????????????????????????
        return true;
    }

    public static boolean returnBook(List<Boolean> available,
                                     List<String> borrowers,
                                     List<String> borrowedBooks,
                                     String isbnNumber) {
        int bookIndex = borrowedBooks.indexOf(isbnNumber);

        if (!isValidIndex(bookIndex, available, borrowers, borrowedBooks))
            throw new RuntimeException("Book not found");

        available.set(bookIndex, true);
        borrowers.remove(bookIndex);
        borrowedBooks.remove(bookIndex);
        return true;
    }

    public static void displayBorrowedBooks(List<String> borrowers, List<String> borrowedBooks) {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed");
            return;
        }

        if (borrowedBooks.size() != borrowers.size())
            throw new RuntimeException("Lists are out of sync");

        for (int i = 0; i < borrowers.size(); i++) {
            System.out.printf("%-10s %s%n", borrowers.get(i), borrowedBooks.get(i));
        }
    }

    private static boolean isValidIndex(int index, List<?>... lists) {
        if (index < 0) return false;

        for (List<?> list : lists) {
            if (index >= list.size()) {
                return false;
            }
        }
        return true;
    }
}
