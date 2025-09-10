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

    public static void displayAllBooks(ArrayList<String> titles,
                                       ArrayList<String> authors,
                                       ArrayList<String> isbn) {

        System.out.println("Alla böcker i biblioteket");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println((i + 1) + ". " + titles.get(i) +
                    " av " + authors.get(i) +
                    " (ISBN: " + isbn.get(i) + ")");
        }
    }
}
