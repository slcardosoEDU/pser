package ejercicios.ejercicio3;

/**
 * Excepción que indica que no se ha encontrado un partido en la lista de
 * partidos.
 * @author Samuel
 */
public class PartidoNotFoundException extends IndexOutOfBoundsException{
    
    public PartidoNotFoundException(Partido p) {
        super(p.getNombre()+" no encontrado está en la lista de partidos.");
        
    }

}
