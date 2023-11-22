package ejercicios.ejercicio8;

/**
 *
 * @author samuel
 */
public class Meteorito {

    private boolean taladrado;
    private int numero;

    public Meteorito(int numero) {
        taladrado = false;
        this.numero = numero;
    }

    public boolean isTaladrado() {
        return taladrado;
    }
    
    public void taladrar(){
        taladrado = true;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.taladrado ? 1 : 0);
        hash = 37 * hash + this.numero;
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
        final Meteorito other = (Meteorito) obj;
        if (this.taladrado != other.taladrado) {
            return false;
        }
        return this.numero == other.numero;
    }
    
    

    @Override
    public String toString() {
        return "Meteorito "+numero+(taladrado?"(taladrado)":"");
    }
    
    
    
    
}
