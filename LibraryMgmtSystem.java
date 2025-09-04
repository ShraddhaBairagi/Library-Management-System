import java.util.*;

class Book {
    int id;
    String title, author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String toString() {
        return id + " | " + title + " | " + author + " | " + (isIssued ? "Issued" : "Available");
    }
}

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book Added!");
    }

    static void issueBook() {
        System.out.print("Enter Book ID to Issue: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book Issued!");
                return;
            }
        }
        System.out.println("Book Not Available!");
    }

    static void viewBooks() {
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Book\n2. Issue Book\n3. View Books\n4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: addBook(); break;
                case 2: issueBook(); break;
                case 3: viewBooks(); break;
                case 4: return;
            }
        }
    }
}
