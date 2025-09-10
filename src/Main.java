import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void displayMainMenu(Scanner s) {
        boolean runMenu = true;
        int choice;

        while (runMenu) {
            System.out.println("\n=== BIBLIOTEKSSYSTEM ===");
            System.out.println("1. Visa alla böcker");
            System.out.println("2. Lägg till bok");
            System.out.println("3. Låna bok");
            System.out.println("4. Återlämna bok");
            System.out.println("5. Visa statistik");
            System.out.println("0. Avsluta");
            try {
                choice = s.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input (" + e + ")");
                choice = -1;
            }
            s.nextLine(); // Rensa newline
            switch (choice) {
                case 1:
                    //displayAllBooks(bookTitles, bookAuthors, bookISBN);
                    break;
                case 2:
                    System.out.print("Titel: ");
                    String title = s.nextLine();
                    System.out.print("Författare: ");
                    String author = s.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = s.nextLine();
                    // addBook(bookTitles, bookAuthors, bookISBN, title, author, isbn);
                    break;
                case 0:
                    runMenu = false;
                    break;
                default:
                    System.out.println("No action for this number");
            }
        }
        System.out.println("Good bye.");
    }

    public static void displayBookMenu(Scanner s) {
    }

    public static void displayLoanMenu(Scanner s) {
    }

    // + ansvarar för main-metoden och att koppla ihop alla delar
// I main-metoden - ENDAST dessa listor för att spara tid
// Böcker (index motsvarar varandra)
    static ArrayList<String> bookTitles = new ArrayList<>();
    static ArrayList<String> bookAuthors = new ArrayList<>();
    static ArrayList<String> bookISBN = new ArrayList<>();
    static ArrayList<Boolean> bookAvailable = new ArrayList<>(); // true =         tillgänglig
    // Lån (index motsvarar varandra)
    static ArrayList<String> borrowerNames = new ArrayList<>();
    static ArrayList<String> borrowedBooks = new ArrayList<>(); // ISBN för         lånad bok
// Användare (index motsvarar varandra)

    // Förinställd testdata (Person 5 skapar detta)
    // Enkel huvudmeny (Person 5)
    static ArrayList<String> userNames = new ArrayList<>();
    static ArrayList<String> phoneNumbers = new ArrayList<>();

    static void testBooks() {
// Lägg till dessa i början av main för att spara tid på inmatning
// Fördefinierade böcker
        bookTitles.add("Harry Potter");
        bookTitles.add("Sagan om ringen");
        bookTitles.add("1984");
        bookAuthors.add("J.K. Rowling");
        bookAuthors.add("Tolkien");
        bookAuthors.add("Orwell");
        bookISBN.add("111");
        bookISBN.add("222");
        bookISBN.add("333");
        bookAvailable.add(true);
        bookAvailable.add(true);
        bookAvailable.add(false); // 1984 är utlånad
// Fördefinierade användare
        userNames.add("Anna");
        userNames.add("Erik");
        phoneNumbers.add("070-1234567");
        phoneNumbers.add("070-7654321");
// Fördefinierat lån
        borrowerNames.add("Anna");
        borrowedBooks.add("333"); // Anna har lånat 1984
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        testBooks();

        BookHandler.addBook(bookTitles, bookAuthors, bookISBN, "Harry Potter", "J.K. Rowling", "1", bookAvailable);

        displayMainMenu(scanner);
    }

    public static void addBook(ArrayList<String> titles,
                               ArrayList<String> authors, ArrayList<String> isbn, String
                                       title, String author, String isbnNumber) {
        titles.add(title);
        authors.add(author);
        isbn.add(isbnNumber);
        bookAvailable.add(true); // Ny bok är alltid tillgänglig
        System.out.println("Bok tillagd: " + title + " av " +
                author);
    }
}