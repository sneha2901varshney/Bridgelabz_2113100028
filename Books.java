 import java.util.*;

public class Books
 {

    private static String title;
    private static String author;

    public Books(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
     public static void main(String[] args) {
        Books bk1 = new Books("Geography", " R.K.Agarwal");
        Books bk2 = new Books("Maths", " PQR");
        Books bk3 = new Books("English", " RST");
        Books bk4 = new Books("Electronics", " ABC ");
        Books bk5 = new Books("Communication", " JKL");

        Library lib1 = new Library("State Library");
        Library lib2 = new Library(".University Library");

        lib1.addBook(bk3);
        lib1.addBook(bk2);
        lib1.addBook(bk5);
        lib2.addBook(bk3);
        lib2.addBook(bk2);

        lib1.displayBooks();
        lib2.displayBooks();
    }
}

 class Library
{
    private static String libraryName;
    private static List<Books> newBook;

    Library(String libraryName)
    {
        this.libraryName = libraryName;
        this.newBook = new ArrayList<>();
    }

    public void addBook(Books book)
    {
        newBook.add(book);
    }

    public void displayBooks()
    {
        System.out.println("Library: " + libraryName);
        for (Books book : newBook)
        {
            System.out.println(book);
        }
    }
}
