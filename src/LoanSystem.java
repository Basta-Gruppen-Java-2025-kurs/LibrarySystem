import java.util.ArrayList;
import java.util.List;

public class LoanSystem {

    public static boolean borrowBook(ArrayList<Boolean> available,
                                     ArrayList<String> borrowers,
                                     ArrayList<String> borrowedBooks,
                                     int bookIndex,
                                     String borrowerName) {
        boolean isAvailable = available.get(bookIndex);
        if (!isAvailable)
            return false;

        String book = borrowedBooks.get(bookIndex);
        available.set(bookIndex, false);
        borrowedBooks.add(bookIndex, book);
        borrowers.add(bookIndex, borrowerName);
        return true;
    }

    public static boolean returnBook(List<Boolean> available,
                                     List<String> borrowers,
                                     List<String> borrowedBooks,
                                     String isbnNumber) {
        int bookIndex = borrowedBooks.indexOf(isbnNumber);
        if (bookIndex < 0)
            return false;

        available.set(bookIndex, true);
        borrowers.remove(bookIndex);
        borrowedBooks.remove(bookIndex);
        return true;
    }

    public static void displayBorrowedBooks(List<String> borrowers, List<String> borrowedBooks) {
        for (int i = 0; i < borrowers.size(); i++) {
            System.out.printf("%-10s %s%n", borrowers.get(i), borrowedBooks.get(i));
        }
    }
}
