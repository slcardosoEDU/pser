package ejercicios.ejercicio8;

/**
 * Nave taladradora.
 * @author samuel
 */
public class NaveA extends Nave{
    
    public NaveA(String nombre){
        super(nombre);
    }

    @Override
    public void aPorEl() {
        Hwwc.getInstancia().taladrar();
    }
    
    

}
