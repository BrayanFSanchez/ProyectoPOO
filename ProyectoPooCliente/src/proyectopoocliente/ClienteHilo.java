package proyectopoocliente;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilo extends Thread {

    protected Socket socket;
    protected ObjectOutputStream salidaDatos;
    protected ObjectInputStream entradaDatos;
    
    CambiosAntesTorneo oCambiosAntesTorneo = new CambiosAntesTorneo();

        DatosAdministrativos oDatosAdministrativos = new DatosAdministrativos();

        SuministrarInfoLiga oSuministrarInfoLiga = new SuministrarInfoLiga();

        Calendario oCalendario = new Calendario();
        
        Scanner oEntradaInt = new Scanner(System.in);
        Scanner oEntradaString = new Scanner(System.in);

    // conectarse al servidor y procesar mensajes del servidor
    private void ejecutarCliente() {
        // conectarse al servidor, obtener flujos, procesar la conexi�n
        try {
            if (conectarAServidor("127.0.0.1")) { // Paso 1: crear un socket para realizar la conexion
                obtenerFlujos();      // Paso 2: obtener los flujos de entrada y salida
                procesarConexion(); // Paso 3: procesar la conexion                
            }
        } // el servidor cerro la conexion
        catch (EOFException excepcionEOF) {
            mostrarMensaje("Se produjo un error en la conexion con el servidor, el error es: "
                    + excepcionEOF.toString());
        } // procesar los problemas que pueden ocurrir al comunicarse con el servidor
        catch (IOException excepcionES) {
            mostrarMensaje("Se produjo un error en la comunicacion con el servidor, el error es: "
                    + excepcionES.toString());
        } finally {
            cerrarConexion(); // Paso 4: cerrar la conexion
        }

    } // fin del metodo ejecutarCliente

    // conectarse al servidor
    private boolean conectarAServidor(String host) {
        try {
            mostrarMensaje("Intentando realizar conexion\n");
            // crear Socket para realizar la conexion con el servidor
            socket = new Socket(InetAddress.getByName(host), 10578);

            // mostrar la informacion de la conexion en la consola del cliente
            mostrarMensaje("Conectado a: " + socket.getInetAddress().getHostName());
            return true;
        } catch (IOException ex) {
            mostrarMensaje("No se pudo establecer la conexion con el servidor, el error es: " + ex.toString());
            return false;
        }
    }

    // obtener flujos para enviar y recibir datos
    private void obtenerFlujos() throws IOException {
        // establecer flujo de salida para los objetos que se envian al servidor
        salidaDatos = new ObjectOutputStream(socket.getOutputStream());
        salidaDatos.flush(); // vaciar buffer de salida para enviar informacion de encabezado

        // establecer flujo de entrada para los objetos que se reciben por parte del servidor
        entradaDatos = new ObjectInputStream(socket.getInputStream());
    }

    // procesar la conexion con el servidor
    private void procesarConexion() throws IOException {
        String mensajeRespuesta = "";
        int opc = 1;
        Scanner sc = new Scanner(System.in);
        do { // procesar mensajes recibidos del servidor
            // leer mensaje y mostrarlo en pantalla
            try {
                mostrarMensaje("");
                mostrarMensaje("Selecione una opcion:");
                mostrarMensaje("Cambios antes del torneo:");
                mostrarMensaje("  1. Agregar Jugador.");
                mostrarMensaje("  2. Agregar Director Tecnico.");
                mostrarMensaje("  3. Agregar Directivo.");
                mostrarMensaje("  4. Transferir un jugador.");
                mostrarMensaje("");
                mostrarMensaje("Calendario:");
                mostrarMensaje("  5. Generar Calendario.");
                mostrarMensaje("  6. Imprimir Calendario.");
                mostrarMensaje("");
                mostrarMensaje("Suministrar informacion a la liga:");
                mostrarMensaje("  7. Actualizar las estadisticas de un jugador.");
                mostrarMensaje("  8. Actualizar director tecnico.");
                mostrarMensaje("  9. Actualizar directivo.");
                mostrarMensaje("  10. Actualizar equipos.");
                mostrarMensaje("");
                mostrarMensaje("Datos administrativos:");
                mostrarMensaje("  11. Visualizar la lista de directores tecnicos.");
                mostrarMensaje("  12. Visualizar la lista de directivos.");
                mostrarMensaje("  13. Visualizar la lista de ciudades de los equipos.");
                mostrarMensaje("");
                mostrarMensaje("Tabla de posiciones y Jugador mas valioso:");
                mostrarMensaje("  14. Visualizar tabla de posiciones.");
                mostrarMensaje("  15. Seleccionar al jugador mas valioso.");
                mostrarMensaje("");
                mostrarMensaje("Ingrese -1 para salir:");
                opc = oEntradaInt.nextInt();
                mostrarMensaje("");
                
                switch (opc) {

                case 1:
                    System.out.println("Ingrese el nombre del jugador:");
                    String NombreJugador = oEntradaString.nextLine();
                    System.out.println("Ingrese el equipo del jugador:");
                    String EquipoJugador = oEntradaString.nextLine();
                    oCambiosAntesTorneo.GuardarJugador(NombreJugador, EquipoJugador);
                    break;

                case 2:
                    System.out.println("Ingrese el nombre del director tecnico:");
                    String NombreDirector = oEntradaString.nextLine();
                    System.out.println("Ingrese el equipo del director tecnico:");
                    String EquipoDirector = oEntradaString.nextLine();
                    oCambiosAntesTorneo.GuardarDirectorTecnico(NombreDirector, EquipoDirector);
                    break;

                case 3:
                    System.out.println("Ingrese el nombre del directivo:");
                    String NombreDirectivo = oEntradaString.nextLine();
                    System.out.println("Ingrese el equipo del directivo:");
                    String EquipoDirectivo = oEntradaString.nextLine();
                    System.out.println("Ingrese el numero de presupuesto del directivo:");
                    float presupuesto = oEntradaInt.nextInt();
                    oCambiosAntesTorneo.GuardarDirectivo(NombreDirectivo, EquipoDirectivo, presupuesto);
                    break;

                case 4:
                    System.out.println("Ingrese el nombre del jugador a transferir:");
                    String NombreJugadorTrans = oEntradaString.nextLine();
                    System.out.println("Ingrese el nuevo equipo del jugador:");
                    String NombreEquipoTrans = oEntradaString.nextLine();
                    oCambiosAntesTorneo.Transferencias(NombreJugadorTrans, NombreEquipoTrans);
                    break;

                case 5:

                    System.out.println("Ingrese el nombre de diez equipos:");
                    String equipo1 = oEntradaString.nextLine();
                    String equipo2 = oEntradaString.nextLine();
                    String equipo3 = oEntradaString.nextLine();
                    String equipo4 = oEntradaString.nextLine();
                    String equipo5 = oEntradaString.nextLine();
                    String equipo6 = oEntradaString.nextLine();
                    String equipo7 = oEntradaString.nextLine();
                    String equipo8 = oEntradaString.nextLine();
                    String equipo9 = oEntradaString.nextLine();
                    String equipo10 = oEntradaString.nextLine();
                    oCalendario.CrearCalendario(equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8, equipo9, equipo10);
                    oCambiosAntesTorneo.GuardarEquipo(equipo1);
                    oCambiosAntesTorneo.GuardarEquipo(equipo2);
                    oCambiosAntesTorneo.GuardarEquipo(equipo3);
                    oCambiosAntesTorneo.GuardarEquipo(equipo4);
                    oCambiosAntesTorneo.GuardarEquipo(equipo5);
                    oCambiosAntesTorneo.GuardarEquipo(equipo6);
                    oCambiosAntesTorneo.GuardarEquipo(equipo7);
                    oCambiosAntesTorneo.GuardarEquipo(equipo8);
                    oCambiosAntesTorneo.GuardarEquipo(equipo9);
                    oCambiosAntesTorneo.GuardarEquipo(equipo10);
                    break;

                case 6:
                    oCalendario.ImprimirCalendario();
                    break;

                case 7:
                    System.out.println("Ingrese el nombre del jugador:");
                    String NombreJugadorAct = oEntradaString.nextLine();
                    System.out.println("Ingrese el numero de goles anotados:");
                    int GolesAnotados = oEntradaInt.nextInt();
                    System.out.println("Ingrese el numero de tarjetas amarillas:");
                    int TarjetasAmarillas = oEntradaInt.nextInt();
                    System.out.println("Ingrese el numero de tarjetas rojas:");
                    int TarjetasRojas = oEntradaInt.nextInt();
                    System.out.println("Ingrese el numero de faltas:");
                    int Faltas = oEntradaInt.nextInt();
                    oSuministrarInfoLiga.ActualizarInfoJugadores(NombreJugadorAct, GolesAnotados, TarjetasAmarillas, TarjetasRojas, Faltas);
                    break;

                case 8:
                    System.out.println("Ingrese el nombre del directo tecnico:");
                    String NombreDirectorAct = oEntradaString.nextLine();
                    System.out.println("Ingrese el numero de encuentros:");
                    int Encuentros = oEntradaInt.nextInt();
                    System.out.println("Ingrese el numero de partidos ganados:");
                    int PartidosGanados = oEntradaInt.nextInt();
                    System.out.println("Ingrese el numero de partidos empatados:");
                    int PartidosEmpatados = oEntradaInt.nextInt();
                    System.out.println("Ingrese el numero de partidos perdidos:");
                    int PartidosPerdidos = oEntradaInt.nextInt();
                    oSuministrarInfoLiga.ActualizarDirectorTecnico(NombreDirectorAct, Encuentros, PartidosGanados, PartidosEmpatados, PartidosPerdidos);
                    break;

                case 9:
                    System.out.println("Ingrese el nombre del directivo:");
                    String NombreDirectivoAct = oEntradaString.nextLine();
                    System.out.println("Ingrese la cantidad que desea sumar al presupuesto:");
                    int Presupuesto = oEntradaInt.nextInt();
                    oSuministrarInfoLiga.ActualizarDirectivos(NombreDirectivoAct, Presupuesto);
                    break;

                case 10:
                    System.out.println("Ingrese el nombre del equipo:");
                    String NombreEquipo = oEntradaString.nextLine();
                    System.out.println("Ingrese la cantidad de partidos jugados que desea sumar:");
                    int PartidosJugados = oEntradaInt.nextInt();
                    System.out.println("Ingrese la cantidad de partidos ganados que desea sumar:");
                    int PartidosGanadosAct = oEntradaInt.nextInt();
                    System.out.println("Ingrese la cantidad de partidos empatados que desea sumar:");
                    int PartidosEmpatadosAct = oEntradaInt.nextInt();
                    System.out.println("Ingrese la cantidad de partidos perdidos que desea sumar:");
                    int PartidosPerdidosAct = oEntradaInt.nextInt();
                    System.out.println("Ingrese la cantidad de goles a favor que desea sumar:");
                    int GolesFavorAct = oEntradaInt.nextInt();
                    System.out.println("Ingrese la cantidad de goles en contra que desea sumar:");
                    int GolesContraAct = oEntradaInt.nextInt();
                    System.out.println("Ingrese la cantidad de puntos que desea sumar:");
                    int PuntosAct = oEntradaInt.nextInt();
                    oSuministrarInfoLiga.ActualizarEquipo(NombreEquipo, PartidosJugados, PartidosGanadosAct,
                            PartidosEmpatadosAct, PartidosPerdidosAct, GolesFavorAct, GolesContraAct, PuntosAct);

                    break;

                case 11:
                    oDatosAdministrativos.VisualizarDirectoresTecnicos();
                    break;

                case 12:
                    oDatosAdministrativos.VisualizarDirectivos();
                    break;

                case 13:
                    oDatosAdministrativos.VisualizarCiudadEquipos();
                    break;

                case 14:
                    oSuministrarInfoLiga.VisualizarTablaPosiciones();
                    break;

                case 15:
                    oSuministrarInfoLiga.JugadorMasValioso();
                    break;

                default:
                    if (opc != -1) {
                        System.out.println("Opcion invalida");
                    }
                    break;
            }
                
                //mostrarMensaje("Escriba el mensaje que desea enviar al servidor");
                //enviarMensaje((String)sc.nextLine());
                //mensajeRespuesta = (String) entradaDatos.readObject();
                //mostrarMensaje("Servidor devuelve el mensaje: " + mensajeRespuesta);*/
            } // atrapar los problemas que pueden ocurrir al leer del servidor
            catch (Exception e){}
            /*catch (ClassNotFoundException excepcionClaseNoEncontrada) {
                mostrarMensaje("\nSe recibio un objeto de tipo desconocido, el error es: "
                        + excepcionClaseNoEncontrada.toString());
            }*/
        } while (opc != -1);
        //} while (!mensajeRespuesta.equals("TERMINAR"));
        mostrarMensaje("FIN DEL CICLO CLIENTE");
    } // fin del metodo procesarConexion

    // enviar mensaje al servidor
    private void enviarMensaje(String mensaje) {
        // enviar objeto al servidor
        try {
            salidaDatos.writeObject(mensaje);
            salidaDatos.flush();
        } // procesar los problemas que pueden ocurrir al enviar el objeto
        catch (IOException excepcionES) {
            mostrarMensaje("\nError al enviar el mensaje al servidor, el error es: "
                    + excepcionES.toString());
        }
    }

    // cerrar flujos y socket
    private void cerrarConexion() {
        try {
            salidaDatos.close();
            entradaDatos.close();
            socket.close();
        } catch (IOException excepcionES) {
            mostrarMensaje("Se produjo un error al cerrar la conexion con el servidor, "
                    + "el error es: " + excepcionES.toString());
        }
    }

    private void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public void run() {
        ejecutarCliente();
    }

}
