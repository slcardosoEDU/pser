package ejemplos.sockets.echo.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *Esta clase representa un cliente que envía un mensaje de echo a un servidor local. <br>
 * El cliente solicita al usuario un mensaje, se conecta al servidor, se lo envía
 * y espera la respuesta. Una vez recibida la respuesta se termina la conexión y el
 * programa.
 * @author samuel
 */
public class Cliente {
    
    public final static int PUERTO = 7007;
    public final static String IP = "127.0.0.1";
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mensaje > ");
        String mensaje = sc.nextLine();
        
        Socket servidor = new Socket(IP, PUERTO);
        
        DataInputStream in = new DataInputStream(servidor.getInputStream());
        DataOutputStream out = new DataOutputStream(servidor.getOutputStream());
        
        out.writeUTF(mensaje);
        String recibido = in.readUTF();
        
        servidor.close();
        
        System.out.println("Servidor responde: "+recibido);
    }
    

}
