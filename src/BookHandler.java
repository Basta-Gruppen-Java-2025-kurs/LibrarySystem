import java.util.ArrayList;

public class BookHandler {
    public static void addBook(ArrayList<String> titles,
                               ArrayList<String> authors,
                               ArrayList<String> isbn,
                               String title,
                               String author,
                               String isbnNumber,
                               ArrayList<Boolean> available) {
        titles.add(title);
        authors.add(author);
        isbn.add(isbnNumber);
        available.add(true);
        System.out.println("Added book: " + title + " author: " + author);
    }
}
