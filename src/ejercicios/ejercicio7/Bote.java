package ejercicios.ejercicio7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Un bote es un lugar donde se registan todas las apuestas realizadas por los
 * empleados.
 *
 * @author Samuel
 */
public class Bote {

    private HashMap<Resultado, ArrayList<Apuesta>> apuestas;

    /**
     * Crea un bote sin apuestas.
     */
    public Bote() {
        apuestas = new HashMap<Resultado, ArrayList<Apuesta>>();
    }

    public void apostar(Apuesta ap) {
        ArrayList<Apuesta> existentes;
        //Sincronizamos a nivel de bote para realizar la apuesta. "Leer el importe actual apostado"
        synchronized (this) {
            //Recuperamos las apuestas asociadas a un resultado.
            existentes = apuestas.get(ap.getResultado());
            //Si no hay es necesario crearlas. *Por eso hay que sincronizar el bote.
            if (existentes == null) {
                existentes = new ArrayList();
                apuestas.put(ap.getResultado(), existentes);
            }
        }
        //Sincronizamos a nivel de resultado concreto para que varios hilos puedan apostar
        //simultaneamente a resultados diferentes.
        synchronized (existentes) {
            try {
                Thread.sleep(new Random().nextInt(Empleado.MAX_ESPERA_MS));
                //System.err.println(System.currentTimeMillis() + "\t" + ap);
                existentes.add(ap);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Bote.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    

}
