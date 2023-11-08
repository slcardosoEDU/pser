package ejercicios.ejercicio5;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Oficina {
    private boolean estaJefe;

    public Oficina() {
        estaJefe = false;
    }
    
    public synchronized void entra(Empleado p){
        if(p.isJefe()){
            System.out.println("EL JEFE HA LLEGADO");
            estaJefe = true;
            notifyAll();
        }else{
            if(!estaJefe){
                System.out.println(p.getName()+" He llegado. ZZZZZ");
                try {
                    wait();
                    System.out.println(p.getName()+" Hola jefe, aqui estoy trabajando");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Oficina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                System.out.println(p.getName()+" Hola, me pongo a trabajar.");
            }
        }
        
    }

}
