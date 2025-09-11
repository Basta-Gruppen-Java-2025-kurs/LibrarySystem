import java.util.ArrayList;

public class BookHandler {
    public static void addBook(ArrayList<String> bookTitles,
                               ArrayList<String> bookAuthors,
                               ArrayList<String> bookIsbn,
                               String title,
                               String author,
                               String isbnNumber,
                               ArrayList<Boolean> available) {
        bookTitles.add(title);
        bookAuthors.add(author);
        bookIsbn.add(isbnNumber);
        available.add(true);
        System.out.println("Bok tillagd: " + title + " av: " + author);
    }

    public static void displayAllBooks(ArrayList<String> bookTitles,
                                       ArrayList<String> bookAuthors,
                                       ArrayList<String> bookIsbn) {

        System.out.println("\n=== Alla böcker i biblioteket ===");
        for (int i = 0; i < bookTitles.size(); i++) {
            System.out.println((i + 1) + ". " + bookTitles.get(i) +
                    " av " + bookAuthors.get(i) +
                    " (ISBN: " + bookIsbn.get(i) + ")");
        }
    }

    public static int searchBook(ArrayList<String> bookTitles,
                                  ArrayList<String> bookAuthors,
                                  String searchTerm) {
        for (int i = 0; i < bookTitles.size(); i++) {

            boolean titleMatch = bookTitles.get(i).toLowerCase().contains(searchTerm.toLowerCase());
            boolean authorMatch = bookAuthors.get(i).toLowerCase().contains(searchTerm.toLowerCase());

            if (titleMatch || authorMatch) {
                System.out.println("Hittade: " + bookTitles.get(i) + " av " + bookAuthors.get(i));
                return i;
            }
        }
        System.out.println("Ingen bok hittades med sökordet: " + searchTerm);
        return -1;
    }
}
