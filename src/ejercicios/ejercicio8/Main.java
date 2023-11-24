package ejercicios.ejercicio8;

/**
 *
 * @author usuarioa
 */
public class Main {
    public static void main(String[] args) {
      
        for(int i=1; i<=NaveA.NUM_NAVES; i++){
            new NaveA(i).start();
        }
        for(int i=1; i<=NaveB.NUM_NAVES; i++){
            new NaveB(i).start();
        }
    }
}
