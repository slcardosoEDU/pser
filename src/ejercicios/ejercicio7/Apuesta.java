package ejercicios.ejercicio7;

/**
 * Una apuesta es un importe de dinero (€) que se asocia a un empleado y a un
 * resultado. <br>
 * 
 * @author Samuel
 */
public class Apuesta {
    private Empleado empleado;
    private Resultado resultado;
    private int importe;

    /**
     * Crea una apuesta de un empleado. <br>
     * @param empleado Empleado que realiza la apuesta.
     * @param resultado Resultado al que se apuesta el importe.
     * @param importe Cantidad de dinero que se apuesta. No se permite apostar céntimos.
     */
    public Apuesta(Empleado empleado, Resultado resultado, int importe) {
        this.empleado = empleado;
        this.resultado = resultado;
        this.importe = importe;
    }
    
    /**
     * Crea una apuesta de un empleado al resultado indicado.<br>
     * @param empleado Empleado que realiza la apuesta.
     * @param golesPRF Cantidad de goles que el empleado cree que marcará el equipo PRF.
     * @param golesDM2 Cantidad de goles que el empleado cree que marcará el equipo DM2.
     */
    public Apuesta(Empleado empleado, int golesPRF, int golesDM2,  int importe) {
        this.empleado = empleado;
        this.resultado = new Resultado(golesPRF,golesDM2);
        this.importe = importe;
    }
    
    
    /**
     * Crea una apuesta de 1 euro para un empleado. <br>
     * @param empleado Empleado que realiza la apuesta.
     * @param resultado Resultado al que se apuesta el importe.
     */
    public Apuesta(Empleado empleado, Resultado resultado) {
        this.empleado = empleado;
        this.resultado = resultado;
        this.importe = 1;
    }
    
    /**
     * Crea una apuesta de 1 euro para un empleado al resultado indicado.<br>
     * @param empleado Empleado que realiza la apuesta.
     * @param golesPRF Cantidad de goles que el empleado cree que marcará el equipo PRF.
     * @param golesDM2 Cantidad de goles que el empleado cree que marcará el equipo DM2.
     */
    public Apuesta(Empleado empleado, int golesPRF, int golesDM2) {
        this.empleado = empleado;
        this.resultado = new Resultado(golesPRF,golesDM2);
        this.importe = 1;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public int getImporte() {
        return importe;
    }

    @Override
    public String toString() {
        return empleado.getName()+"\t["+importe+"€]"+"\t"+resultado;
    }
    
    
    
}
