
package proyectopoocliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author bacral
 */
public class CambiosAntesTorneo {
    
    public CambiosAntesTorneo() {
    }

    public void GuardarJugador(String Nombre, String equipo) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BaseProyecto",
                            "postgres", "123456");
            c.setAutoCommit(false);
            System.out.println("Acceso base de datos exitoso");

            stmt = c.createStatement();

            String sql = "INSERT INTO jugadores (nombre, equipo) "
                    + "VALUES ('" + Nombre + "', '" + equipo + "');";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
        System.out.println("Nombre ingresado");
    }

    public void GuardarDirectorTecnico(String Nombre, String Equipo) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BaseProyecto",
                            "postgres", "123456");
            c.setAutoCommit(false);
            System.out.println("Acceso base de datos exitoso");

            stmt = c.createStatement();

            String sql = "INSERT INTO director_tecnico (nombre_tecnico, equipo_tecnico) "
                    + "VALUES ('" + Nombre + "', '" + Equipo + "');";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
        System.out.println("Director tecnico ingresado");
    }

    public void GuardarDirectivo(String Nombre, String Equipo, float presupuesto) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BaseProyecto",
                            "postgres", "123456");
            c.setAutoCommit(false);
            System.out.println("Acceso base de datos exitoso");

            stmt = c.createStatement();

            String sql = "INSERT INTO directivo (nombre_directivo, equipo, presupuesto) "
                    + "VALUES ('" + Nombre + "', '" + Equipo + "', " + presupuesto + ");";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
        System.out.println("Directivo ingresado");
    }

    public void Transferencias(String Nombre, String equipoTransferir) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BaseProyecto",
                            "postgres", "123456");
            c.setAutoCommit(false);
            System.out.println("Acceso base de datos exitoso");

            stmt = c.createStatement();

            String sql = "delete from jugadores "
                    + "where nombre = '" + Nombre + "'";
            stmt.executeUpdate(sql);

            String sql1 = "insert into jugadores (nombre, equipo) "
                    + "values ('" + Nombre + "', '" + equipoTransferir + "')";
            stmt.executeUpdate(sql1);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
        System.out.println("Directivo ingresado");
    }

    public void GuardarEquipo(String nombre_equipo) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BaseProyecto",
                            "postgres", "123456");
            c.setAutoCommit(false);
            System.out.println("Acceso base de datos exitoso");

            stmt = c.createStatement();

            String sql = "INSERT INTO equipos (nombre_equipo) "
                    + "VALUES ('" + nombre_equipo + "');";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
        System.out.println("Equipo ingresado");
    }
    
}
