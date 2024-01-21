package problema.hucha;

/**
 *
 * @author Samuel
 */
public abstract class Familiar extends Thread{
    protected Hucha hucha;
    public Familiar(String nombre, Hucha hucha){
        super(nombre);
        this.hucha = hucha;
    }
    
    public void run(){
        aLaHucha();
    }
    
    abstract void aLaHucha();

}
