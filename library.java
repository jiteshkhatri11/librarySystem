import java.util.*;

public class library{

    // ===== Book Class =====
    static class Book {
        int id;
        String title;
        String author;
        boolean isIssued;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        void display() {
            System.out.println(id + " | " + title + " | " + author + " | "
                    + (isIssued ? "Issued" : "Available"));
        }
    }

    // ===== Library Class =====
    static class Library {
        ArrayList<Book> books = new ArrayList<>();

        void addBook(int id, String title, String author) {
            books.add(new Book(id, title, author));
            System.out.println("✅ Book added successfully.");
        }

        void showBooks() {
            if (books.isEmpty()) {
                System.out.println("❌ No books in library.");
                return;
            }
            System.out.println("\nID | Title | Author | Status");
            for (Book b : books) {
                b.display();
            }
        }

        void issueBook(int id) {
            for (Book b : books) {
                if (b.id == id) {
                    if (!b.isIssued) {
                        b.isIssued = true;
                        System.out.println("✅ Book issued successfully.");
                    } else {
                        System.out.println("❌ Book already issued.");
                    }
                    return;
                }
            }
            System.out.println("❌ Book not found.");
        }

        void returnBook(int id) {
            for (Book b : books) {
                if (b.id == id) {
                    if (b.isIssued) {
                        b.isIssued = false;
                        System.out.println("✅ Book returned successfully.");
                    } else {
                        System.out.println("❌ Book was not issued.");
                    }
                    return;
                }
            }
            System.out.println("❌ Book not found.");
        }
    }

    // ===== Main Method =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== COLLEGE LIBRARY SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    library.addBook(id, title, author);
                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    library.issueBook(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(sc.nextInt());
                    break;

                case 5:
                    System.out.println("🙏 Thank you for using Library System.");
                    return;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}

