package problema.hucha;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class Hijo extends Familiar {
    public final static int NUM_HIJOS = 5;
    public final static int NUM_RETIRADAS = 10;
    public final static int MIN_ESPERA = 200;
    public final static int MAX_ESPERA = 500;

    public Hijo(String nombre, Hucha hucha) {
        super(nombre, hucha);
    }
    
    
    @Override
    void aLaHucha() {
        for(int i = 1; i <= NUM_RETIRADAS; i++){
            try {
                hucha.retirar(fibonacci(i));
            } catch (InterruptedException ex) {
                Logger.getLogger(Hijo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(getName()+" HA MADURADO");
    }
    
    public int fibonacci(int num){
        int a = 0;
        int b = 1;
        
        for(int i= 0; i<num; i++){
            b = b+a;
            a = b-a;            
        }
        return a;
    }

}
