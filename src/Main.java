import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void displayMainMenu() {
    }

    public static void displayBookMenu() {
    }

    public static void displayLoanMenu() {
    }

    // + ansvarar för main-metoden och att koppla ihop alla delar
// I main-metoden - ENDAST dessa listor för att spara tid
// Böcker (index motsvarar varandra)
    ArrayList<String> bookTitles = new ArrayList<>();
    ArrayList<String> bookAuthors = new ArrayList<>();
    ArrayList<String> bookISBN = new ArrayList<>();
    ArrayList<Boolean> bookAvailable = new ArrayList<>(); // true =         tillgänglig
    // Lån (index motsvarar varandra)
    ArrayList<String> borrowerNames = new ArrayList<>();
    ArrayList<String> borrowedBooks = new ArrayList<>(); // ISBN för         lånad bok
// Användare (index motsvarar varandra)

    // Förinställd testdata (Person 5 skapar detta)
    // Enkel huvudmeny (Person 5)
    ArrayList<String> userNames = new ArrayList<>();
    ArrayList<String> phoneNumbers = new ArrayList<>();

    void testBooks() {
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
// Initiera listor och testdata här...
        while (true) {
            System.out.println("\n=== BIBLIOTEKSSYSTEM ===");
            System.out.println("1. Visa alla böcker");
            System.out.println("2. Lägg till bok");
            System.out.println("3. Låna bok");
                /*Exempel på färdig funktion (för referens)
                Tips för att lyckas på kort tid:
                Håll det enkelt - Inga komplicerade algoritmer
                Använd testdata - Slipp skriva in böcker manuellt
                Testa löpande - Kör koden ofta för att hitta fel tidigt*/
            System.out.println("4. Återlämna bok");
            System.out.println("5. Visa statistik");
            System.out.println("0. Avsluta");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Rensa newline
            switch (choice) {
                case 1:
                    //displayAllBooks(bookTitles, bookAuthors, bookISBN);
                    break;
                case 2:
                    System.out.print("Titel: ");
                    String title = scanner.nextLine();
                    System.out.print("Författare: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    // addBook(bookTitles, bookAuthors, bookISBN, title, author, isbn);
                    break;
// Fortsätt för andra val...
            }
        }
    }
}