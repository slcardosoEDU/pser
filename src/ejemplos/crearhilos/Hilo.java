package ejemplos.crearhilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase hereda de Thread. Puede ejecutarse el código del método run() en un
 * hilo llamando al método {@link Thread#start() }
 * @author Samuel Loureiro Cardoso
 */
public class Hilo extends Thread{
    
    public Hilo(String nombre){
        super(nombre);        
    }
    
    /**
     * Tarea que se ejecuta en paralelo. <br>
     * Cuando finaliza el método run el hilo pasa a estado "muerto" y
     * no podrá volver a ser lanzado.
     */
    public void run(){
        try {
            System.out.println(super.getName()+":Haciendo una cosa");
            Random rand = new Random();
            int t = rand.nextInt(1000)+1;
            Thread.sleep(t);
            System.err.println(super.getName()+":Terminé");
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
