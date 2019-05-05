
package proyectopooservidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServidorHilo extends Thread {
    
    private Socket socket;
    private ObjectOutputStream salidaDatos;
    private ObjectInputStream entradaDatos;
    private int idSession;

    public ServidorHilo(Socket socket, int id) {
        this.socket = socket;   //se asigna el socket creada y enviado como parametro
        this.idSession = id;    //se asigna el id de la sesion creada y enviada como parametro
        try {//obtener flujos de entrada y salida de los datos
            //se crea el objeto que administra el envio de mensajes hacia el cliente
            salidaDatos = new ObjectOutputStream(socket.getOutputStream());

            //se crea el objeto que administra la recepcion de mensajes enviados por el cliente
            entradaDatos = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            mostrarMensaje("Se produjo un error al crear el hilo para administrar la conexion entre el "
                    + "servidor y el cliente, el error es: " + ex.toString());
        }
    }

    private void procesarConexion() throws IOException {
        String mensaje = "";

        //ciclo que sirve para procesar los mensajes enviados por el cliente
        do {
            try {
                mensaje = (String) entradaDatos.readObject();//leer el mensaje que ha enviado el cliente
                //comparar cual es el mensaje enviado por el cliente
                switch (mensaje) {
                    case "1":
                        //mostrar en la consola del servidor, el mensaje que envia el cliente
                        mostrarMensaje("El cliente con idSesion " + this.idSession + " saluda"
                                + " y el mensaje es: " + mensaje);
                        enviarMensaje("Hola");  //enviar un mensaje deseado al cliente
                        break;
                    case "2":
                        //mostrar en la consola del servidor, el mensaje que envia el cliente
                        mostrarMensaje("El cliente con id de sesion " + this.idSession + " dice: " + mensaje);
                        enviarMensaje("bien");
                        break;
                    case "TERMINAR":
                        //mostrar en la consola del servidor, el mensaje que envia el cliente
                        mostrarMensaje("El cliente con id de sesion " + this.idSession + " dice: " + mensaje
                                + " lo que indica que quiere terminar la conexion");
                        enviarMensaje("TERMINAR");  //enviar un mensaje deseado al cliente
                        break;
                    default:
                        //mostrar en la consola del servidor, el mensaje que envia el cliente
                        mostrarMensaje("El cliente con id de sesion " + this.idSession + " envio un "
                                + "mensaje invalido, el mensaje es: " + mensaje);
                        enviarMensaje("Mensaje desconocido");  //enviar un mensaje deseado al cliente
                        break;
                }
            } // atrapar problemas que pueden ocurrir al tratar de leer del cliente
            catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                mostrarMensaje("\nSe recibio un tipo de objeto desconocido, el error es: "
                        + excepcionClaseNoEncontrada.toString());
            }
        } while (!mensaje.equals("TERMINAR")); //procesar la conexion siempre que el cliente no envíe 
        //el mensaje de terminar
        mostrarMensaje("FIN DEL CICLO SERVIDOR PARA EL CLIENTE CON ID DE SESION: " + this.idSession);
    }

    //envia el mensaje al cliente
    private void enviarMensaje(String mensaje) {
        // enviar objeto al cliente
        try {
            salidaDatos.writeObject(mensaje);  //se crea el mensaje que se enviara al cliente
            salidaDatos.flush();     //se vacia el buffer que tiene el mensaje enviado al cliente            
        } catch (IOException excepcionES) {// procesar problemas que pueden ocurrir al enviar el objeto
            mostrarMensaje("\nError al enviar el mensaje al cliente, el error es: " + excepcionES.toString());
        }
    }

    //muestra en la consola del servidor el mensaje que ha enviado el cliente
    private void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void desconnectar() {
        try {
            entradaDatos.close();
            salidaDatos.close();
            socket.close();
        } catch (IOException ex) {
            mostrarMensaje("Se produjo un error al cerrar la conexion entre el cliente y el servidor"
                    + ", el error es: " + ex.toString());
        }
    }

    @Override
    public void run() {
        try {
            procesarConexion();  //procesa todas las conexiones que realizan los clientes
        } catch (IOException ex) {
            mostrarMensaje("Se produjo un error en el servidor para escuchar las conexiones"
                    + " que los clientes intenten realizar, el error es: " + ex.toString());
        } finally {
            desconnectar(); // Paso 4: cerrar la conexion
        }
    }
    
}
