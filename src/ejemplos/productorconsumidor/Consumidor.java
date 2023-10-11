package ejemplos.productorconsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Consumidor extends Thread{
    
    private Bufer bufer;
    public Consumidor(Bufer bufer) {
        this.bufer = bufer;
    }
    
    public void run(){
        Random r = new Random();
        while(true){
            try {
                Thread.sleep(r.nextInt(500));
                
                System.out.println("C->"+bufer.leer());
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
