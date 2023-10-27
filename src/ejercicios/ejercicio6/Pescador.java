package ejercicios.ejercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Pescador extends Thread {

    public final static int MAX_DELAY = 4000;
    private BufferedReader br;

    public Pescador(String nombre, BufferedReader br) {
        super(nombre);
        this.br = br;
    }

    public void run() {
        Random r = new Random();
        synchronized (br) {
            try {
            String linea;
            while ((linea = br.readLine()) != null) {
                Thread.sleep(r.nextInt(MAX_DELAY));
                br.notify();
                System.out.println(getName()+": "+linea);
                br.wait();
                
            }
            br.notify();
        } catch (IOException ex) {
            Logger.getLogger(Pescador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pescador.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

}
