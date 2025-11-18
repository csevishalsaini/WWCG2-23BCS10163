import java.io.FileReader;
import java.io.IOException;

public class RunTime {
    public static void main(String[] args) {

        try {
            
            FileReader fr = new FileReader("data.txt");
            System.out.println("File opened successfully!");
            fr.close();  

        } catch (IOException e) {  
            
            System.out.println("Error: Unable to open the file.");
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Program continues normally...");
    }
}
