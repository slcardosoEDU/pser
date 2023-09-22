package problema.recreo2;

import javax.swing.JOptionPane;
import problema.recreo.Comecocos;

/**
 *Esta es la clase del hilo principal. <br>
 *
 * Partiendo del problema {@link problema.recreo.Recreo}. 
 * En esta ocasión lanzaremos la ventana del botón en
 * un hilo independiente.<br>
 * Utilizaremos el método join para sincronizar ambos hilos.
 * desde el hilo principal.
 * @author Samuel Loureiro Cardoso
 * @see problema.recreo.Recreo
 * @see problema.recreo.Comecocos
 */
public class Recreo {
    
    //Hilo principal
    //El método join puede generar la excepción InterruptedException
    public static void main(String[] args) throws InterruptedException {
        Thread ventana = new Thread(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "Presiona el botón para parar.");
            }
        });
        ventana.start();
        Comecocos c = new Comecocos();
        c.start();
        //Esperamos a que termine el hilo ventana
        ventana.join();
        c.detener();
        System.out.println(c.getMensaje());
    }
    
}
