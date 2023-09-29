package ejercicios.ejercicio2;

import java.util.Random;
/**
 * 
 * @author Samuel
 */
public class Contador {

    private int contador;
    private Random random;

    public Contador() {
        this.contador = 0;
        this.random = new Random();
    }

    public int getContador() {
        return this.contador;
    }

    public void incrementa() {
        //contador++;
        int valor = this.contador;
        try {
            Thread.sleep(random.nextInt(5));
        } catch (InterruptedException ex) {
        }
        this.contador = valor + 1;

    }
}
