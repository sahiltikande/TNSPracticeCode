import java.util.*;
import java.io.*;

public class LibrarySystem {
    static ArrayList<Book> library = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 🔐 Login system
        if (!login()) {
            System.out.println("Access denied.");
            return;
        }

        // 💾 Load saved books
        loadFromFile();

        int choice;
        do {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> addBook();
                case 2 -> displayBooks();
                case 3 -> searchBook();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> {
                    System.out.println("Saving books and exiting...");
                    saveToFile();
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    // 🔐 Login method
    static boolean login() {
        System.out.println("==== Admin Login ====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Hardcoded credentials
        return username.equals("admin") && password.equals("admin123");
    }

    // 💾 Save books to file
    static void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book b : library) {
                writer.write(b.title + "," + b.author + "," + b.isBorrowed);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // 💾 Load books from file
    static void loadFromFile() {
        library.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Book b = new Book(data[0], data[1]);
                b.isBorrowed = Boolean.parseBoolean(data[2]);
                library.add(b);
            }
        } catch (FileNotFoundException e) {
            System.out.println("books.txt not found. Starting with empty library.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // 📚 Book actions
    static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        Book book = new Book(title, author);
        library.add(book);
        saveToFile(); // Save after adding
        System.out.println("Book added and saved.");
    }

    static void displayBooks() {
        if (library.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("=== Books in Library ===");
        for (Book b : library) {
            b.displayInfo();
        }
    }

    static void searchBook() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        boolean found = false;
        for (Book b : library) {
            if (b.title.equalsIgnoreCase(title)) {
                b.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    static void borrowBook() {
        System.out.print("Enter title to borrow: ");
        String title = scanner.nextLine();
        for (Book b : library) {
            if (b.title.equalsIgnoreCase(title)) {
                b.borrowBook();
                saveToFile(); // Save status
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter title to return: ");
        String title = scanner.nextLine();
        for (Book b : library) {
            if (b.title.equalsIgnoreCase(title)) {
                b.returnBook();
                saveToFile(); // Save status
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

