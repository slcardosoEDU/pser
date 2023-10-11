package ejemplos.productorconsumidor;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Productor extends Thread{

    private Bufer bufer;
    public Productor(Bufer bufer) {
        this.bufer = bufer;
    }
    
    public void run(){
        Random r = new Random();
        while(true){
            try {
                Thread.sleep(r.nextInt(500));
                Integer i = r.nextInt(101);
                System.out.println("P->"+i);
                bufer.escribir(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    

}
