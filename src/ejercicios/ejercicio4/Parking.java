package ejercicios.ejercicio4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Parking {
    private Coche[] plazas;
    public final static int NUM_PLAZAS = 10;
    public Parking() {
        plazas = new Coche[NUM_PLAZAS];
    }
    
    public synchronized void entrar(Coche c){
        //sección critica
        
        Integer libre;
        while((libre = buscarLibre())==null){
            System.out.println(c+" esperando por plaza");
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        plazas[libre] = c;
        System.out.println(c+" aparca en "+libre);
        System.out.println(this);
        
    }
    
    public synchronized void salir(Coche c){
        Integer plaza = buscarCoche(c);
        plazas[plaza] = null;
        System.out.println(c+" deja libre "+plaza);
        System.out.println(this);
        notifyAll();
    }
    
    private Integer buscarLibre(){
        int i = 0;
        while(i < plazas.length && plazas[i] != null ){
            i++;
        }
        return i == plazas.length ? null:i;
    }
    
    private Integer buscarCoche(Coche c){
        int i = 0;
        while(i < plazas.length && c != null &&!c.equals(plazas[i]) ){
            i++;
        }
        return i == plazas.length ? null:i;
    }

    @Override
    public String toString() {
        return plazas.toString();
    }
    
    
}
