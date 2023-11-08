package ejercicios.ejercicio7;

/**
 * Empleado de la empresa que puede realizar un numero de apuestas.
 * @author Samuel
 */
public class Empleado extends Thread{
    /**
     * Número máximo de apuestas que hace un empleado.
     */
    public final static int NUM_APUESTAS_EMPLEADO = 5; 
    /**
     * Tiempo máximo que tarda en reflexionar un Empleado.
     */
    public final static int MAX_ESPERA_MS = 300;
    private Bote bote;

    public Empleado(String nombre, Bote bote) {
        super(nombre);
        this.bote = bote;
    }
    
    public void run(){
        for(int i=0; i<NUM_APUESTAS_EMPLEADO; i++){
            Apuesta ap = new Apuesta(this,Resultado.getResultadoAleatorio());
            //System.err.println("->Apuesta"+i+"\t"+ap);
            bote.apostar(ap);
        }
    }

    
    @Override
    public String toString() {
        return this.getName();
    }

    
}


