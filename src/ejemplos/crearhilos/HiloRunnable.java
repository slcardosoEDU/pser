package ejemplos.crearhilos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloRunnable implements Runnable{
    private int time;
    private String name;
    
    public HiloRunnable(String nombre, int time){
        this.name = nombre;
        this.time = time;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("Soy "+this.name+". Hago una cosa.");
            Thread.sleep(time);
            System.err.println("Soy "+this.name+" Terminé.");
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }

}
