package problema.recreo;

import javax.swing.JOptionPane;

/**
 *Esta es la clase del hilo principal. <br>
 * 
 * El <strong>comecocos</strong> es un juego infantil de papel que consiste en 
 * una pequeña papiroflexia que <a href="https://www.youtube.com/watch?v=fJp6fdftLpw">
 * se puede hacer con una hoja de papel</a>.<br>
 * Para jugar, se hace girar la papiroflexia en la mano y se abre y cierra
 * varias veces hasta que el jugador decide parar. 
 * Luego, se abre el comecocos y se revela un mensaje o pregunta que el
 * jugador debe responder.<br>
 * 
 * En esta clase se simula el funcionamiento del Comecocos. El comecocos
 * debe ejecutarse en un hilo independiente que irá cambiando de mensaje con
 * cierta frecuencia hasta que el usuario (desde el hilo principal) presione un botón. 
 * Cuando el usuario presione el botón el sistema mostrará el mensaje seleccionado.
 * <br>
 * @author Samuel Loureiro Cardoso
 * @see Comecocos
 */
public class Recreo {
    
    //Hilo principal
    public static void main(String[] args) {
        Comecocos c = new Comecocos();
        c.start();
        JOptionPane.showMessageDialog(null, "Presiona el botón para parar.");
        c.detener();
        System.out.println(c.getMensaje());
    }
    
}
