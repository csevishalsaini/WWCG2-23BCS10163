

public class CompileTime {

  public static void main(String[] args) {
      int a = 10;
      int b = 0;

      try {
          int result = a / b;  
          System.out.println("Result: " + result);

      } catch (ArithmeticException e) {
          System.out.println("Error: Cannot divide a number by zero.");
          System.out.println("Exception: " + e.getMessage());
      }

      System.out.println("Program continues normally...");
  }
}
