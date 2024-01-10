package ejercicios.uf2.ejercicio1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servidor de echo que solo puede atender a un cliente. <br>
 * El servidor finaliza su ejecución cuando recibe del cliente un mensaje
 * con la palabra 'fin'.
 * @author Samuel
 */
public class Servidor {
    
    public static void main(String[] args) {
        try {
            //Para formatear la fecha que imprimiremos despues.
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss");
            ServerSocket server = new ServerSocket(Conexion.PUERTO());
            System.out.println("Servidor escuchando en "+server.getLocalSocketAddress());
            //Esperamos hasta recibir una conexión de un cliente.
            Socket cliente = server.accept();
            System.out.println("Recibido cliente: "+cliente.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(cliente.getInputStream());
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            String  mensaje;
            do {
                //Recibir mensaje
                mensaje = in.readUTF();
                System.out.println(formater.format(LocalDateTime.now())+
                        "\t"+
                        mensaje);
                //Enviar mensaje
                out.writeUTF(mensaje);
            } while (!"fin".equalsIgnoreCase(mensaje));
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Cerrando conexión.");
        
    }

}
