public class Circle{
  private double radius;

  public Circle(double radius){
     this.radius = radius;
  }

  public double Area() {
    double result = Math.PI * radius * radius;
    return result;
  }

  public double Circum() {
     double result = 2*Math.PI*radius;
     return result;
  }

  public void Display(){
    System.out.println("The Radius is" + radius);

 System.out.println("The Area is" + Area());
    System.out.println("The Circumfrence is" + Circum());
  }

  public static void main(String[] args){
     Circle circle1 = new Circle(2);
     Circle circle2 = new Circle(4);

     System.out.println("Circle 1");
     circle1.Display();

     System.out.println("Circle 2");
     circle2.Display();
   }
}

