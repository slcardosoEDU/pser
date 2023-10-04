package ejercicios.ejercicio3;

import java.util.Objects;

/**
 * Representa un partido que concurre a las elecciones. <br>
 * Es importante tener en cuenta que varios votantes pueden estar votando
 * simultaneamente a un mismo partido.
 * @author Samuel
 */
public class Partido implements Cloneable{
    private final String nombre;
    private Integer votos;
    
    /**
     * Crea un partido con 0 votos.
     * @param nombre nombre del partido.
     */
    public Partido(String nombre){
        this.nombre = nombre;
        this.votos = 0;
    }
    
    /**Constructor de copia. Para clonar partidos.
     * 
     * @param nombre
     * @param votos 
     */
    private Partido(String nombre, Integer votos){
        this.nombre = nombre;
        this.votos = votos;
    }
    
    /**
     * Incrementa en una unidad el número de votos del partido de forma síncrona. 
     */
    public synchronized void votar(){
        votos++;
    }
    
    /**
     * Devuelve el nombre del partido.
     * @return nombre del partido. 
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Devuelve la cantidad de votos del partido.
     * @return votos del partido.
     */
    public Integer getVotos(){
        return this.votos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nombre.toUpperCase());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partido other = (Partido) obj;
        return this.nombre.equalsIgnoreCase(other.nombre);
    }    
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(this.nombre);
        sb.append("\t (");
        sb.append(this.votos);
        sb.append(" votos)");
        return sb.toString();
    }
    
    /**
     * Devuelve una copia exacta del partido actual
     * @return nuevo objeto partido con los mismos valores que el actual.
     * @throws CloneNotSupportedException 
     */
    public Object colone() throws CloneNotSupportedException{
        return new Partido(this.nombre,this.votos);
    }
}
