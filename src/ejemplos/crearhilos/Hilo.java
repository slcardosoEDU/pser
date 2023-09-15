package ejemplos.crearhilos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuarioa
 */
public class Hilo extends Thread{
    
    public Hilo(String nombre){
        super(nombre);        
    }
    
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
