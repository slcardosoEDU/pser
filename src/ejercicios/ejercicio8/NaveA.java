package ejercicios.ejercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Nave taladradora.
 * @author samuel
 */
public class NaveA extends Nave{
    
    public final static int NUM_NAVES = 5;
    
    public NaveA(int nombre){
        super("A"+nombre);
    }

    @Override
    public void aPorEl() {
        try {
            Hwwc.getInstancia().taladrar();
        } catch (InterruptedException ex) {
            Logger.getLogger(NaveA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}
