package ejercicios.ejercicio3;

/**
 * Hilo principal.
 * @author Samuel
 */
public class Principal {
    /**
     * Cantidad de votantes.
     */
    public static final Integer CENSO = 10000;
    
    public static void main(String[] args) throws InterruptedException {
        Votante[] votantes = new Votante[CENSO];
        Urna u = new Urna();
        for(int i=0;i<votantes.length;i++){
            votantes[i] = new Votante(u);
            votantes[i].start();
        }
        
        for(int i=0;i<votantes.length;i++){            
            votantes[i].join();
        }
        
        System.out.println(u);
        
    }
}
