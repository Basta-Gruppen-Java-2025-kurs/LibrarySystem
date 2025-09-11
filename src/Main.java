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
            System.out.println("6. Visa alla kunder");
            System.out.println("0. Avsluta");
            try {
                choice = s.nextInt();
            } catch (Exception e) {
                System.out.println("Fel inmatning (" + e + ")");
                choice = -1;
            }
            s.nextLine(); // Rensa newline
            switch (choice) {
                case 1:
                    BookHandler.displayAllBooks(bookTitles, bookAuthors, bookISBN);
                    break;
                case 2:
                    displayBookMenu(s);
                    break;
                case 3:
                    displayLoanMenu(s);
                    break;
                case 4:
                    //displayReturnMenu(s);
                    break;
                case 5:
                    EnklaRapporter.displayLibraryStatistics(bookTitles, bookAvailable, userNames);
                    break;
                case 6:
                    UserHandler.displayAllUsers(userNames, phoneNumbers);
                    break;
                case 0:
                    runMenu = false;
                    break;
                default:
                    System.out.println("Ingen åtgärd för detta nummer");
            }
        }
        System.out.println("Hej då.");
    }

    public static void displayBookMenu(Scanner s) {
        System.out.print("Titel: ");
        String title = s.nextLine();
        System.out.print("Författare: ");
        String author = s.nextLine();
        System.out.print("ISBN: ");
        String isbn = s.nextLine();
        BookHandler.addBook(bookTitles, bookAuthors, bookISBN, title, author, isbn, bookAvailable);
    }

    public static void displayLoanMenu(Scanner s) {
        // Loan a book
        System.out.println("Vad heter kunden?");
        String borrowerName = s.nextLine();

        String userPhoneNummer = findOrAddUser(s, borrowerName);

        System.out.print("Söka en bok för att låna: ");
        String searchTerm = s.nextLine();
        int index = BookHandler.searchBook(bookTitles, bookAuthors, searchTerm);
        if (index < 0) {
            System.out.println("Tyvärr finns boken inte");
            return;
        }
        /*if (borrowBook(bookTitles, borrowerNames, borrowedBooks, index, borrowerName)) {
            System.out.println("Book loaned successfully");
        } else {
            System.out.println("Failed to load book.");
        }*/
    }

    static String findOrAddUser(Scanner s, String userName) {
        String userPhoneNummer = UserHandler.searchUser(userNames, phoneNumbers, userName);
        if (userPhoneNummer.equals("Error")) {
            System.out.println("Kunden finns inte. För att lägga till kunden, fyll i telefonnumret:");
            String userPhoneNumber = s.nextLine();
            if (userPhoneNumber.length()>0) {
                UserHandler.registerUser(userNames, phoneNumbers, userName, userPhoneNumber);
            }
        }
        return userPhoneNummer;
    }

    public static void displayReturnMenu(Scanner s) {
        System.out.println("Vem återlämnar boken?");
        String userName = s.nextLine();

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

        //BookHandler.addBook(bookTitles, bookAuthors, bookISBN, "Harry Potter", "J.K. Rowling", "1", bookAvailable);

        displayMainMenu(scanner);
    }

    /*public static void addBook(ArrayList<String> titles,
                               ArrayList<String> authors, ArrayList<String> isbn, String
                                       title, String author, String isbnNumber) {
        titles.add(title);
        authors.add(author);
        isbn.add(isbnNumber);
        bookAvailable.add(true); // Ny bok är alltid tillgänglig
        System.out.println("Bok tillagd: " + title + " av " +
                author);
    }*/
}