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
        System.out.println("Added book: " + title + " author: " + author);
    }
}
