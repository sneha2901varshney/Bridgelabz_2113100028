public class Book
{
    private static String libraryName = "ABC Library" ;
    private String title ;
    private String author ;
    private final String isbn ;
    private static String displayLibraryName ;

    static String displayLibraryName()
    {
        return displayLibraryName ;
    }

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn ;
    }

    public void displayBookDetails()
    {
        if (this instanceof Book) 
        {
            System.out.println("Library Name: " + libraryName);
            System.out.println("Title name: " + this.title);
            System.out.println("Author Holder: " + this.author);
            System.out.println("ISBN : " + this.isbn);
        }
    }
    
    public static void main(String[] args) 
    {
        Book bk1 = new Book("Geography", "Mihra", "7786896754321");
        Book bk2 = new Book("Maths","Priya", "997890866676");

        bk1.displayBookDetails();
        bk2.displayBookDetails();
    }
}

