package problema.hucha;

/**
 *
 * @author Samuel
 */
public class Hucha {
    
    private int dinero;
    private int numSemana;
    public Hucha() {
        this.dinero = 0;
        numSemana = 1;
    }
    
    public synchronized void ingresar(int cantidad){
        dinero += cantidad;
        System.out.println("Semana "+numSemana);
        System.out.println(Thread.currentThread().getName()+" ingresa "+cantidad+"€");
        System.out.println(this);
        numSemana++;
        notifyAll();
    }
    
    public synchronized void retirar(int cantidad) throws InterruptedException{
        while(dinero < cantidad){
            wait();
        }
        dinero -= cantidad;
        System.out.println(Thread.currentThread().getName()+" coge "+cantidad+"€");
    }

    @Override
    public String toString() {
        return "En la hucha hay "+dinero+"€";
    }
    
    

}
