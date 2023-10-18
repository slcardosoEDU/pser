package ejercicios.ejercicio4;

/**
 *
 * @author samuel
 */
public class Main {
    public final static int COCHES = 50;
    public static void main(String[] args) {
        
        Parking p = new Parking();
        for (int i = 1; i <= COCHES; i++) {
            Coche c = new Coche(i,p);
            c.start();
        }
    }

}
