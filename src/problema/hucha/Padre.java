package problema.hucha;


/**
 *
 * @author Samuel
 */
public class Padre extends Familiar{
    public final static int INGRESO_HUCHA = 10;
    public final static int SEMANA_MS = 1000;
    
    public Padre(Hucha hucha){
        super("Padres",hucha);
    }
    
    @Override
    void aLaHucha() {
        while(!Thread.interrupted()){
            hucha.ingresar(INGRESO_HUCHA);
            try {
                Thread.sleep(SEMANA_MS);
            } catch (InterruptedException ex) {
                this.interrupt();
            }
        }
    }
    

}
