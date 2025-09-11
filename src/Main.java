import java.util.ArrayList;
import java.util.Scanner;

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
            System.out.println("7. Visa alla lånat böker");
            System.out.println("8. Visa filmer meny");
            System.out.println("0. Avsluta");
            try {
                choice = s.nextInt();
            } catch (Exception e) {
                System.out.println("Fel inmatning (" + e + ")");
                choice = -1;
            }
            s.nextLine();
            switch (choice) {
                case 1 -> BookHandler.displayAllBooks(bookTitles, bookAuthors, bookISBN);
                case 2 -> displayBookMenu(s);
                case 3 -> displayLoanMenu(s);
                case 4 -> displayReturnMenu(s);
                case 5 -> EnklaRapporter.displayLibraryStatistics(bookTitles, bookAvailable, userNames);
                case 6 -> UserHandler.displayAllUsers(userNames, phoneNumbers);
                case 7 -> LoanSystem.displayBorrowedBooks(borrowerNames, borrowedBooks);
                case 8 -> MovieLibrary.main(new String[0]);
                case 0 -> runMenu = false;
                default -> System.out.println("Ingen åtgärd för detta nummer");
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
        System.out.println("Vad heter kunden?");
        String borrowerName = s.nextLine();

        String userPhoneNummer = findOrAddUser(s, borrowerName);
        if (userPhoneNummer.length() < 1) {
            return;
        }

        System.out.print("Söka en bok för att låna: ");
        String searchTerm = s.nextLine();

        int index = BookHandler.searchBook(bookTitles, bookAuthors, searchTerm);
        if (index < 0) {
            System.out.println("Tyvärr finns boken inte");
            return;
        }
        boolean isLoanSuccessful = LoanSystem.borrowBook(bookAvailable, borrowerNames, borrowedBooks, bookISBN, index, borrowerName);
        if (isLoanSuccessful) {
            System.out.println("Book loaned successfully");
        } else {
            System.out.println("Failed to load book.");
        }
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

    private static void displayReturnMenu(Scanner s) {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books available");
            return;
        }

        System.out.println("Ange bokens ISBN:");
        String isbn = s.nextLine();

        boolean isReturnSuccessful = LoanSystem.returnBook(bookAvailable, borrowerNames, borrowedBooks, isbn);
        if (isReturnSuccessful) {
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Failed to return book.");
        }
    }

    static ArrayList<String> bookTitles = new ArrayList<>();
    static ArrayList<String> bookAuthors = new ArrayList<>();
    static ArrayList<String> bookISBN = new ArrayList<>();
    static ArrayList<Boolean> bookAvailable = new ArrayList<>();
    static ArrayList<String> borrowerNames = new ArrayList<>();
    static ArrayList<String> borrowedBooks = new ArrayList<>();
    static ArrayList<String> userNames = new ArrayList<>();
    static ArrayList<String> phoneNumbers = new ArrayList<>();

    static void testBooks() {
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
        bookAvailable.add(false);
        userNames.add("Anna");
        userNames.add("Erik");
        phoneNumbers.add("070-1234567");
        phoneNumbers.add("070-7654321");
        borrowerNames.add("Anna");
        borrowedBooks.add("333");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        testBooks();

        displayMainMenu(scanner);
    }

}