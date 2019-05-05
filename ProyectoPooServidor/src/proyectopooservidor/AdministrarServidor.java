
package proyectopooservidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bacral
 */
public class AdministrarServidor {
 
    private Socket socket;
    private ServerSocket ss;
    private int idSession;

    public AdministrarServidor() {
        idSession = 0;
        iniciarServidor();
        esperarConexion();
    }

    private void iniciarServidor() {
        mostrarMensaje("Inicializando servidor... ");

        try {
            ss = new ServerSocket(10578);//iniciar servidor en el puerto 10578
            mostrarMensaje("\t[OK]");
            idSession = 0;
        } catch (IOException ex) {
            mostrarMensaje("Se produjo un error al iniciar el servidor, el error es: " + ex.toString());
        }
    }

    private void esperarConexion() {
        //escuchar y atender todas las conexiones que realicen los clientes
        while (true) {  //ciclo que se ejecuta infinitamente hasta que se cierra el servidor
            try {
                socket = ss.accept();  //se acepta y crea un socket para el cliente y se establece la conexion
                mostrarMensaje("Nueva conexion entrante: " + socket);
                //se inicia el hilo que administra la conexion con el cliente                
                (new ServidorHilo(socket, idSession)).start();

                idSession++; //por cada cliente conectado asigna un id de sesion distinto               
            } catch (IOException ex) {
                mostrarMensaje("Se produjo un error al aceptar la conexion del cliente, el error es: " + ex.toString());
            }
        }
    }

    //metodo para mostrar mensaje en la consola del servidor
    private void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
}
