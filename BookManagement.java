package AssignmentLinkList;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

public class BookManagement{
    private Book head;
    private Book tail;
    private int bookCount;

    public void addBookAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    public void addBookAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    public void removeBookById(int bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }
                bookCount--;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("Found: " + temp.title + " by " + temp.author);
            }
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.title + " by " + temp.author);
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public int countBooks() {
        return bookCount;
    }
}

class Library{
    public static void main(String[] args) {
        BookManagement library = new BookManagement();

        library.addBookAtEnd(1, "The God of Small Things", "Arundhati Roy", "Fiction", true);
        library.addBookAtEnd(2, "Malgudi Days", "R.K. Narayan", "Short Stories", true);
        library.addBookAtBeginning(3, "Train to Pakistan", "Khushwant Singh", "Historical Fiction", false);

        System.out.println("Library Books (Forward):");
        library.displayBooksForward();

        System.out.println("\nLibrary Books (Reverse):");
        library.displayBooksReverse();

        System.out.println("\nSearching for books by R.K. Narayan:");
        library.searchByAuthor("R.K. Narayan");

        System.out.println("\nUpdating availability of Train to Pakistan to true");
        library.updateAvailability(3, true);
        library.displayBooksForward();

        System.out.println("\nTotal books in library: " + library.countBooks());
    }
}

