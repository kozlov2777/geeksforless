import java.io.IOException;
import java.io.PrintWriter;

public class Writer {


    public static void write(String filename, Double calculate){
        try {
            PrintWriter writer =new PrintWriter(filename);
            writer.print(calculate);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
