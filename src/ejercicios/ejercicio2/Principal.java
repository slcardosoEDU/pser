package ejercicios.ejercicio2;

/**
 *
 * @author Samuel
 */
public class Principal {
    
    public static final int NUM_HILOS = 5;
    
    public static void main(String[] args) throws InterruptedException {
        Hilo[] hilos = new Hilo[NUM_HILOS];
        Contador c = new Contador();
        Hilo h = null;
        for(int i=0; i<NUM_HILOS; i++){
            hilos[i] = new Hilo(c);
            hilos[i].start();
            
        }
        
        for (int i = 0; i < NUM_HILOS; i++) {
            hilos[i].join();
        }
        
        
        System.out.println("c="+c.getContador());
        
        
    }

}
