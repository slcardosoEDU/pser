package ejercicios.ejercicio5;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Empleado extends Thread{
    public final static int MAX_ESPERA = 3000;
    private Oficina oficina;
    private boolean esJefe;
    public Empleado(String nombre, Oficina o){
        super(nombre);
        oficina = o;
        esJefe = false;
    }
    
    public Empleado(String nombre, Oficina o, boolean esJefe){
        super(nombre);
        oficina = o;
        this.esJefe = esJefe;        
    }
    
    
    
    public void run(){
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(MAX_ESPERA));
            oficina.entra(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isJefe(){
        return esJefe;
    }
}
