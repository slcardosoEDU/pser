package ejercicios.ejercicio8;

/**
 *
 * @author usuarioa
 */
public class NaveB extends Nave{
    public NaveB(String nombre){
        super(nombre);
    }

    @Override
    public void aPorEl() {
        Hwwc.getInstancia().boom();
    }

}
