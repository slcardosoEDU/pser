package ejercicios.uf2.ejercicio3;

import static ejercicios.uf2.ejercicio3.Servidor.getTime;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel
 */
public class HiloCliente extends Thread {

    private String nombre;
    private Socket cliente;

    public HiloCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {

        DataInputStream in = null;
        try {
            //Solicitamos el nombre
            System.out.println(getTime() + "\tRecibido cliente " + cliente.getRemoteSocketAddress());
            in = new DataInputStream(cliente.getInputStream());
            
            String mensaje;
            StringBuilder sb;
            //Esperamos el nombre de usuario
            mensaje = in.readUTF();
            if (registrarCliente(mensaje)) {
                synchronized (this) {
                   enviarMensaje("Escriba el nombre del usuario que quiere comprobar, "
                        + "'Fin' para terminar o 'shutdown' para apagar el servidor remoto"); 
                }
                
                while (true) {
                    sb = new StringBuilder();
                    mensaje = in.readUTF();
                    if (Conexion.FIN.equalsIgnoreCase(mensaje)) {
                        enviarMensaje(Conexion.FIN_CONN_CLIENTE);
                        
                        Servidor.CLIENTES_CONECTADOS.remove(this);
                        break;
                    }

                    if (Conexion.SHUTDOWN.equalsIgnoreCase(mensaje)) {
                        Servidor.shutdown();
                        continue;
                    }
                    sb.append(datosUsuario(mensaje));
                    sb.append("\n");
                    sb.append("Escriba el nombre del usuario que quiere comprobar, "
                            + "'Fin' para terminar o 'shutdown' para apagar el servidor remoto");
                    enviarMensaje(sb.toString());                    
                    
                }

            }

            //Consultas
        } catch (IOException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Cerrando cliente " + nombre);
        } 

        System.out.println(this.nombre + " desconectado.");

    }

    
    private synchronized void enviarMensaje(String mensaje) throws IOException{
        DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
        out.writeUTF(mensaje);
    }
    
    public synchronized void shutdown() {
        try {
            
            enviarMensaje(Conexion.FIN_CONN_CLIENTE);
            cliente.close();

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean registrarCliente(String nombre) {
        synchronized (Servidor.CLIENTES_CONECTADOS) {
            this.nombre = nombre;
            if (Servidor.CLIENTES_CONECTADOS.contains(this)) {
                try {
                    System.err.println("Rechazando conexion para " + nombre);
                    enviarMensaje(Conexion.FIN_CONN_CLIENTE);
                    
                } catch (IOException ex) {
                    Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                return false;
            }
            
            Servidor.CLIENTES_CONECTADOS.add(this);
        }
        synchronized (Servidor.HISTORICO_CONEXIONES) {
            Integer conexiones = Servidor.HISTORICO_CONEXIONES.get(nombre);
            conexiones = conexiones == null ? 1 : ++conexiones;
            Servidor.HISTORICO_CONEXIONES.put(nombre, conexiones);
        }

        return true;
    }

    private String datosUsuario(String nombre) {
        StringBuilder sb = new StringBuilder(nombre);
        sb.append(" ");
        String conectado = "no conectado ";
        synchronized (Servidor.CLIENTES_CONECTADOS) {
            for(HiloCliente hc:Servidor.CLIENTES_CONECTADOS){
                if(nombre.equals(hc.getNombre()))
                {
                    conectado = "conectado ";
                    break;
                }
            }
            sb.append(conectado);
            sb.append(getTime());
        }
        sb.append("\nNúmero de conexiones: ");
        synchronized (Servidor.HISTORICO_CONEXIONES) {
            Integer conexiones = Servidor.HISTORICO_CONEXIONES.get(nombre);
            conexiones = conexiones == null ? 0 : conexiones;
            sb.append(conexiones);
        }

        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public Socket getCliente() {
        return cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HiloCliente other = (HiloCliente) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    

    @Override
    public String toString() {
        return this.nombre;
    }

}
