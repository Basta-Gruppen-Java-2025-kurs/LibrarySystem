import java.util.ArrayList;
import java.util.stream.Collectors;

public class EnklaRapporter {
    public static int countAvailableBooks(ArrayList<Boolean> available) {
        return available.stream().filter(a -> a).collect(Collectors.toList()).size();
    }

    public static int countBorrowedBooks(ArrayList<Boolean> available) {
        return available.stream().filter(a -> !a).collect(Collectors.toList()).size();
    }

    public static void displayLibraryStatistics(ArrayList<String>titles, ArrayList<Boolean> available, ArrayList<String> userNames) {
        System.out.println("Totalt antal böcker i biblioteket: " + titles.size());
        System.out.println("Antal tillgängliga böcker på biblioteket: " + countAvailableBooks(available));
        System.out.println("Antal lånade böcker på biblioteket: " + countBorrowedBooks(available));
        System.out.println("Antal kunder på biblioteket: " + userNames.size());
    }
}
