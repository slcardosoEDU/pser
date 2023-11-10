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

    public void anadirApuesta(Apuesta ap) {
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
    
    public int getTotalBote(){
        int totalBote = 0;
        for (Resultado r : apuestas.keySet()) {
            for (Apuesta ap : apuestas.get(r)) {
                totalBote += ap.getImporte();
            }
        }
        return totalBote;
    }

    public String getGanadores(Resultado r) {
        ArrayList<Apuesta> aciertos = apuestas.get(r);
        HashMap<Empleado, Integer> ganadores = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (aciertos == null) {
            return "No hay ganadores.";
        }
        //Cantidad total apostada al resultado ganador.
        int cantidadApostada = 0;
        for (Apuesta a : aciertos) {
            Empleado e = a.getEmpleado();
            if(ganadores.containsKey(e)){
                ganadores.put(e, ganadores.get(e)+a.getImporte());
            }else{
                ganadores.put(e, a.getImporte());
            }
            cantidadApostada += a.getImporte();
        }
        sb.append("\tGANADORES\n");
        for(Empleado e: ganadores.keySet()){
            sb.append(e);
            sb.append("\tgana\t");
            sb.append(String.format("%.2f", (double)getTotalBote()*ganadores.get(e)/cantidadApostada));
            
            sb.append("\n");
        }
        
        return sb.toString();
    }
   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int totalBote = 0;
        for (Resultado r : apuestas.keySet()) {
            for (Apuesta ap : apuestas.get(r)) {
                sb.append(ap);
                sb.append("\n");
                totalBote += ap.getImporte();
            }
        }
        sb.append("TOTAL\t[");
        sb.append(totalBote);
        sb.append("€]");
        return sb.toString();
    }

}
