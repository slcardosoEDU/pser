package ejercicios.ejercicio3;

import java.util.Random;

/**
 * Esta clase representa a un votante. <br>
 * Un votante tiene la capacidad de votar paralelamente a otros votantes en la
 * misma urna. <br>
 * El votante asignara su voto de forma aleatoria a uno de los partidos disponibles 
 * en la urna. Cada votante solo emitira un voto ejecutando su método {@link #start()}
 * @author Samuel
 * @see Urna
 */
public class Votante extends Thread{
    /**
     * Tiempo máximo (milisegundos) que se tomará el votante para reflexionar su voto. 
     */
    public final static Integer MAX_ESPERA = 500;
    private Urna urna;
    /**
     * Crea un votante que podrá votar a uno de los partidos disponibles en la urna.
     * @param urna Urna en la que contiene los partidos que concurren a las elecciones
     * y sus votos.
     */
    public Votante(Urna urna){
        this.urna = urna;
    }
    
    /**
     * Implementación de la acción asíncrona de votar.
     */
    public void run(){
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(MAX_ESPERA));
            Partido[] parts = urna.getPartidos();
            urna.votar(parts[r.nextInt(parts.length)]);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }

}
