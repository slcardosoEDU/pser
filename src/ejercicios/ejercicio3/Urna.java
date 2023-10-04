package ejercicios.ejercicio3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Contiene los partidos que concurren a las elecciones. <br>
 * Los votantes utilizarán esta urna virtual para emitir sus votos a cada partido. <br>
 * Es importante tener en cuenta que cada objeto urna representa unas elecciones.
 * Esto implica que todos los votantes tienen que utilizar la misma urna para votar. <br>
 * La urna puede ser utilizada por múltiples votantes simultaneamente.
 * @author Samuel
 * @see Votante
 * @see Partido
 */
public class Urna {    
    
    private Partido[] partidos;
    
    public Urna(){
        //Para simplificar el problema siempre concurrirán los mismos partidos.
        partidos = new Partido[5];
        partidos[0] = new Partido("NEGROS");
        partidos[1] = new Partido("VERDES");
        partidos[2] = new Partido("AZULES");
        partidos[3] = new Partido("ROJOS");
        partidos[4] = new Partido("ROSAS");
    }
    
    /**
     * Devuelve la lista de partidos que concurren a las elecciones. <br>
     * Este método está pensado para que los votantes puedan conocer las opciones
     * de voto que tienen. <br>
     * @return Lista de partidos. 
     */
    public Partido[] getPartidos(){
        // Por seguridad no devolvemos la lista de partidos con la que hacemos
        // el recuento.
        return this.partidos.clone();
    }
    
    /**
     * Emite un voto al partido indicado.
     * @param p partido al que se desea votar.
     * @throws PartidoNotFoundException Si el partido no está en la urna.
     */
    public void votar(Partido p) throws PartidoNotFoundException{
        int i = 0;
        while(!p.equals(partidos[i])){
            i++;
            if(i>=partidos.length){
                throw new PartidoNotFoundException(p);
            }
        }
        partidos[i].votar();        
    }
    
    public String toString(){
        
        StringBuilder sb = new StringBuilder("\t\t--Resultado--\n");
        //Ordenamos los partidos de mayor a menor segun los votos recibidos
        Comparator<Partido> c = (Partido p1, Partido p2) -> p2.getVotos()-p1.getVotos();
        Arrays.sort(partidos,c);
        
        int totalVotos = 0;
        List<Partido> ganadores = new ArrayList();
        int maxVotos = 0;
        for(Partido p : partidos){
            totalVotos+=p.getVotos();
            sb.append(p);
            sb.append("\n");
            if(p.getVotos()>=maxVotos){
                ganadores.add(p);
                maxVotos = p.getVotos();
            }
        }
        sb.append("\nTotal votos: ");
        sb.append(totalVotos);
        if(ganadores.size()==1){
            sb.append("\nGanador: ");
            sb.append(ganadores.get(0).getNombre());
        }else{
            sb.append("\nEmpatados: ");
            for(Partido p: ganadores){
                sb.append(p.getNombre());
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }

}
