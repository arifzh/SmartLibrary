import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem{
 
    static ArrayList<String> books = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("---------------------------");
        System.out.println("Library System");
        System.out.println("---------------------------");
        mainMenu(); // Entry point
        System.out.println("---------------------------");
        System.out.println("Exiting Library System");
        System.out.println("---------------------------");
    }

    public static void mainMenu() {
        System.out.println("Entering mainMenu");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. View All Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook(scanner);
                case 2 -> removeBook(scanner);
                case 3 -> viewBooks();
                case 4 -> {
                    System.out.println("Exiting mainMenu");
                    return; 
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Add a book
    public static void addBook(Scanner scanner) {
        System.out.println("Entering addBook");
        System.out.print("Enter the name of the book to add: ");
        String bookName = scanner.nextLine();
        books.add(bookName);
        System.out.println("Book added: " + bookName);
        System.out.println("Exiting addBook");
    }

    // Remove a book
    public static void removeBook(Scanner scanner) {
        System.out.println("Entering removeBook");
        if (books.isEmpty()) {
            System.out.println("No books to remove!");
        } else {
            System.out.println("Enter the index of the book to remove (starting from 1):");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
            int index = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline

            if (index >= 0 && index < books.size()) {
                String removedBook = books.remove(index);
                System.out.println("Book removed: " + removedBook);
            } else {
                System.out.println("Invalid index. No book removed.");
            }
        }
        System.out.println("Exiting removeBook");
    }

    // View all books
    public static void viewBooks() {
        System.out.println("Entering viewBooks");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the Library:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
        System.out.println("Exiting viewBooks");
    }
}
