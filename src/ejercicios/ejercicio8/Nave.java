package ejercicios.ejercicio8;

/**
 *
 * @author usuarioa
 */
public abstract class Nave extends Thread {
    
    public Nave(String nombre){
        super("Nave "+ nombre);
        
    }
    
    public void run(){
        System.out.println(getName()+" despegando!");
        while(Hwwc.getInstancia().hayMeteoritos()){
            aPorEl();
        }
        System.out.println(getName()+" aterrizando!");        
    }
    
    public abstract void aPorEl();

}
