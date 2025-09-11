import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<String> bookTitles = new ArrayList<>();
    private static final ArrayList<String> bookAuthors = new ArrayList<>();
    private static final ArrayList<String> bookISBN = new ArrayList<>();
    private static final ArrayList<Boolean> bookAvailable = new ArrayList<>();
    private static final ArrayList<String> borrowerNames = new ArrayList<>();
    private static final ArrayList<String> borrowedBooks = new ArrayList<>();
    private static final ArrayList<String> userNames = new ArrayList<>();
    private static final ArrayList<String> phoneNumbers = new ArrayList<>();

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
            s.nextLine();
            switch (choice) {
                case 1 -> BookHandler.displayAllBooks(bookTitles, bookAuthors, bookISBN);
                case 2 -> addBookMenu(s);
                case 3 -> displayLoanMenu(s);
                case 4 -> displayReturnMenu(s);
                case 5 -> LoanSystem.displayBorrowedBooks(borrowerNames, borrowedBooks);
                case 0 -> runMenu = false;
                default -> System.out.println("No action for this number");
            }
        }
        System.out.println("Good bye.");
    }

    private static void addBookMenu(Scanner s) {
        System.out.print("Title: ");
        String title = s.nextLine();
        System.out.print("Author: ");
        String author = s.nextLine();
        System.out.print("ISBN: ");
        String isbn = s.nextLine();

        BookHandler.addBook(bookTitles, bookAuthors, bookISBN, title, author, isbn, bookAvailable);
    }

    private static void displayReturnMenu(Scanner s) {
        System.out.println("Enter book ISBN:");
        String isbn = s.nextLine();

        boolean isReturnSuccessful = LoanSystem.returnBook(bookAvailable, borrowerNames, borrowedBooks, isbn);
        if (isReturnSuccessful) {
            System.out.println("Book returned successfully");
        } else {
            System.out.println("Failed to return book.");
        }
    }

    private static void displayLoanMenu(Scanner s) {
        System.out.println("Vad heter du?");
        String borrowerName = s.nextLine();
        System.out.print("Enter book title: ");
        String searchTerm = s.nextLine();

        int index = bookTitles.indexOf(searchTerm);
        boolean isLoanSuccessful = LoanSystem.borrowBook(bookAvailable, borrowerNames, borrowedBooks, index, borrowerName);
        if (isLoanSuccessful) {
            System.out.println("Book loaned successfully");
        } else {
            System.out.println("Failed to load book.");
        }
    }

    public static void addBook(ArrayList<String> titles,
                               ArrayList<String> authors,
                               ArrayList<String> isbn,
                               String title,
                               String author,
                               String isbnNumber) {
        titles.add(title);
        authors.add(author);
        isbn.add(isbnNumber);
        bookAvailable.add(true);
        System.out.println("Bok tillagd: " + title + " av " + author);
    }

    private static void testBooks() {
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
        testBooks();
        try (Scanner scanner = new Scanner(System.in)) {
            BookHandler.addBook(bookTitles, bookAuthors, bookISBN, "Harry Potter", "J.K. Rowling", "1", bookAvailable);
            displayMainMenu(scanner);
        }
    }
}