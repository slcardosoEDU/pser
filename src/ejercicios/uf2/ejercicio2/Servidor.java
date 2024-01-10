package ejercicios.uf2.ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servidor de echo que solo puede atender a un cliente. <br>
 * El servidor finaliza su ejecución cuando recibe del cliente un mensaje con la
 * palabra 'fin'.
 *
 * @author Samuel
 */
public class Servidor {

    private static boolean encendido = true;
    private static int contador = 0;
    private static ServerSocket server;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(Conexion.PUERTO());
            System.out.println("Servidor escuchando en " + server.getLocalSocketAddress());

            //Recibimos clientes mientras el servidor este "encendido".
            while (encendido) {
                Socket cliente = server.accept();
                //Abrimos un hilo para procesar cada cliente
                Thread hiloSocket = new Thread(() -> runHiloSocket(cliente));
                hiloSocket.start();
            }

        } catch (IOException ex) {
            //Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Apagando...");

    }

    public static void runHiloSocket(Socket cliente) {
        DataInputStream in = null;
        try {
            int idCliente = ++contador;
            System.out.println(getTime() + "\tRecibido cliente_" + idCliente + " " + cliente.getRemoteSocketAddress());
            in = new DataInputStream(cliente.getInputStream());
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            String mensaje;
            do {
                //Recibir mensaje
                mensaje = in.readUTF();
                System.out.println(getTime()
                        + "\tcliente_"+idCliente+"\t"
                        + mensaje);
                //Enviar mensaje
                out.writeUTF(mensaje);
                //Si recibimos un shutdown paramos de escuchar peticiones con el servidor.
                if ("shutdown".equalsIgnoreCase(mensaje)) {
                    encendido = false;
                    
                    try{
                        if(!server.isClosed())
                            server.close();                        
                    }catch(IOException ex){
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } while (!"fin".equalsIgnoreCase(mensaje));
            System.out.println(getTime() + "\tCerrando conexion cliente_" + idCliente);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static String getTime() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm:ss");
        return formater.format(LocalDateTime.now());
    }

}
