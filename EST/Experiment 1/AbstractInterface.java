import java.lang.*;

interface Animal {
  void sound();  
}


abstract class Dog implements Animal {
  abstract void breed(); 

  void sleep() {          
      System.out.println("Dog is sleeping...");
  }
}


class GermanShepherd extends Dog {

  @Override
  public void sound() {
      System.out.println("Barks loudly!");
  }

  @Override
  void breed() {
      System.out.println("Breed: German Shepherd");
  }
}


public class AbstractInterface {
  public static void main(String[] args) {
      GermanShepherd gs = new GermanShepherd();

      gs.sound();   
      gs.breed();   
      gs.sleep();   
  }
}
