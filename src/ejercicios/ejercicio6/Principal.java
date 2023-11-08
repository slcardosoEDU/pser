package ejercicios.ejercicio6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author samuel
 */
public class Principal {
    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {
       BufferedReader br = new BufferedReader(new FileReader("pescadores.txt"));
       Pescador marcos = new Pescador("marcos",br);
       Pescador pedro = new Pescador("pedro",br);
       marcos.start();
       pedro.start();
       marcos.join();
       pedro.join();
       br.close();
    }

}
