package ejercicios.ejercicio8;

/**
 *
 * @author usuarioa
 */
public class NaveB extends Nave{    
    public final static int NUM_NAVES = 3;
    
    public NaveB(int nombre){
        super("B"+nombre);
    }

    @Override
    public void aPorEl() {
        Hwwc.getInstancia().boom();
    }

}
