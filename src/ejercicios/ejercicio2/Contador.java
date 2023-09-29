package ejercicios.ejercicio2;

import java.util.Random;

/**
 * Un contador puede incrementarse en una unidad.
 *
 * @author Samuel Loureiro Cardoso
 */
public class Contador {

    private int contador;
    private Random random;

    /**
     * Crea un Contador con la cuenta a 0.
     */
    public Contador() {
        this.contador = 0;
        this.random = new Random();
    }

    /**
     * Devuelve el valor actual del contador
     *
     * @return Valor actual del contador.
     */
    public int getContador() {
        return this.contador;
    }

    /**
     * Incrementa el contador en una posición. Este método puede ser utilizado
     * de forma síncrona por varios hilos.
     */
    public void incrementa() {
        //contador++;
        synchronized (this) {
            int valor = this.contador;
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException ex) {
            }
            this.contador = valor + 1;

        }

    }
}
