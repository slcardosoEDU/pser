package ejercicios.ejercicio7;

import java.util.Random;

/**
 * Un resultado representa la cantidad de goles que ha metido el equipo local (PRF)
 * y la cantidad de goles que ha metido el equipo visitante (DM2). <br>
 * @author Samuel
 */
public class Resultado {
    public final static int MAX_GOLES = 4;
    private int prf;
    private int dm2;

    public Resultado(int prf, int dm2) {
        this.prf = prf;
        this.dm2 = dm2;
    }
    
    public static Resultado getResultadoAleatorio(){
        Random r = new Random();
        return new Resultado(r.nextInt(MAX_GOLES+1),r.nextInt(MAX_GOLES+1));
    }

    public int getPrf() {
        return prf;
    }

    public void setPrf(int prf) {
        this.prf = prf;
    }

    public int getDm2() {
        return dm2;
    }

    public void setDm2(int dm2) {
        this.dm2 = dm2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.prf;
        hash = 37 * hash + this.dm2;
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
        final Resultado other = (Resultado) obj;
        if (this.prf != other.prf) {
            return false;
        }
        return this.dm2 == other.dm2;
    }

    @Override
    /**
     * Devuelve el resultado en formato prf-dm2.
     */
    public String toString() {
        return prf + "-" + dm2;
    }
    
    

}
