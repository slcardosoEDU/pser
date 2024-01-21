package ejercicios.uf2.ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cliente de echo. <br>
 * Utiliza sockets para enviar un mensaje al servidor.<br>
 * El programa finalizará cuando el servidor responda 'fin'.
 *
 * @author Samuel
 */
public class Cliente {

    public static String respuesta = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket servidor = new Socket(Conexion.SERVIDOR(), Conexion.PUERTO());
            DataInputStream in = new DataInputStream(servidor.getInputStream());
            DataOutputStream out = new DataOutputStream(servidor.getOutputStream());
            String  mensaje;
            System.out.println("Bienvenido/a. Introduzca un nombre para su usuario");
            do {
                System.out.print("Nombre: ");
                mensaje = sc.nextLine();
                //Enviamos el nombre del cliente
                out.writeUTF(mensaje);
                //El servidor responde
                synchronized (respuesta) {
                    if(respuesta==null){
                    try {
                        respuesta.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                }
                
                respuesta = in.readUTF();
                System.out.println(respuesta);
            } while (!Conexion.FIN_CONN_CLIENTE.equalsIgnoreCase(respuesta));

            servidor.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conexión cerrada");
    }
    
    public void run(DataInputStream in){
        Thread inpuntThread = Thread.currentThread();
        while(!inpuntThread.isInterrupted()){
            synchronized (respuesta) {
                try {
                respuesta = in.readUTF();
                respuesta.notify();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
