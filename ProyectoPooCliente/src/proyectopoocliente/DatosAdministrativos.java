package proyectopoocliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author bacral
 */
public class DatosAdministrativos {

    public DatosAdministrativos() {
    }

    public void VisualizarDirectoresTecnicos() {
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
            String sql = "SELECT nombre_tecnico, equipo_tecnico, encuentros, partidos_ganados, "
                    + "partidos_empatados, partidos_perdidos FROM director_tecnico ";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String nombre_tecnico = result.getString("nombre_tecnico");
                String equipo_tecnico = result.getString("equipo_tecnico");
                String encuentros = result.getString("encuentros");
                String partidos_ganados = result.getString("partidos_ganados");
                String partidos_empatados = result.getString("partidos_empatados");
                String partidos_perdidos = result.getString("partidos_perdidos");
                System.out.println("Nombre: " + nombre_tecnico + " Equipo: " + equipo_tecnico
                        + " Encuentros: " + encuentros + " Partidos ganados: " + partidos_ganados
                        + " Partidos empatados: " + partidos_empatados + " Partidos Perdidos: "
                        + partidos_perdidos);
            }

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
    }

    public void VisualizarDirectivos() {
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
            String sql = "SELECT nombre_directivo, equipo, presupuesto FROM directivo ";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String nombre_directivo = result.getString("nombre_directivo");
                String equipo = result.getString("equipo");
                String presupuesto = result.getString("presupuesto");

                System.out.println("Nombre: " + nombre_directivo + " Equipo: " + equipo
                        + " Presupuesto: " + presupuesto);
            }

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
    }

    public void VisualizarCiudadEquipos() {
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
            String sql = "SELECT nombre_equipo, ciudad FROM equipos ";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String nombre_equipo = result.getString("ciudad");
                String ciudad = result.getString("ciudad");

                System.out.println("Nombre del equipo: " + nombre_equipo + " Ciudad: " + ciudad);
            }

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            //System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
    }

}
