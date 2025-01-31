public class Book{
  private String title;
  private String author;
  private int price;

  public Book(String title, String author, int price){
      this.title = title;
      this.author = author;
      this.price = price;
  }

  public void Display(){
    System.out.println("The Titel Of The Book is" + title);
    System.out.println("The Author of the Book is" + author);
    System.out.println("The Price of The Book is" + price);
  }

  public static void main(String[] args){
     Book book1 = new Book("The Rain Man", "Harsh", 1000);

Book book2 = new Book("The Mud Man", "Abhay", 2000);

     book1.Display();
     book2.Display();
   }
}

