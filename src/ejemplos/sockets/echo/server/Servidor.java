package ejemplos.sockets.echo.server;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Esta clase representa un servidor echo muy básico. <br>
 * Lo único que hace es esperar a que se conecte un cliente,
 * aceptar la conexión, recibir un mensaje y reenviar ese mismo mensaje.
 * @author samuel
 */
public class Servidor {
    public final static int PUERTO = 7007;
    public static void main(String[] args) throws IOException {
        
        ServerSocket server;
        server = new ServerSocket(PUERTO);
        System.out.println("Escuchando en el puerto "+PUERTO);
        Socket cliente = server.accept();
        DataInputStream in = new DataInputStream(cliente.getInputStream());
        DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
        boolean seguir = true;
        String mensaje;
        while(seguir){
            try{
                mensaje = in.readUTF();
                System.out.println("SERVER: lee "+mensaje);
                out.writeUTF(mensaje);
            }catch(IOException e){
                seguir = false;
            }           
        }
        cliente.close();       
        
    }

}
