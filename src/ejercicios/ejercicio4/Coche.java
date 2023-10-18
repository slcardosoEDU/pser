package ejercicios.ejercicio4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Coche extends Thread {

    private int id;
    private Parking parking;
    public final static int MAX_ESPERA_MS = 5000;
    public final static int MIN_ESPERA_MS = 1000;

    public Coche(int id, Parking parking) {
        this.id = id;
        this.parking = parking;
    }

    public void run() {
        Random r = new Random();
        try {
            //Intenta aparcar
            parking.entrar(this);
            //Espera un rato
            Thread.sleep(MIN_ESPERA_MS + r.nextInt(MAX_ESPERA_MS - MIN_ESPERA_MS));
            //Desaparca
            parking.salir(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        return this.id == other.id;
    }
    
    

    @Override
    public String toString() {
        return "Coche "+id;
    }
    
    

}
