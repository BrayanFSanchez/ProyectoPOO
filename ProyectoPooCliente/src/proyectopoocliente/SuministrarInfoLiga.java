package proyectopoocliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author bacral
 */
public class SuministrarInfoLiga {

    public void ActualizarInfoJugadores(String nombre, int goles_anotados,
            int tarjetas_amarillas, int tarjetas_rojas, int faltas) {

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

            String sql = "update jugadores set goles_anotados = goles_anotados + " + goles_anotados + ", "
                    + " tarjetas_amarillas = tarjetas_amarillas + " + tarjetas_amarillas + ", "
                    + " tarjetas_rojas = tarjetas_rojas + " + tarjetas_rojas + ","
                    + "faltas = faltas + " + faltas + " "
                    + "where nombre = '" + nombre + "';";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Jugador actualizado");

    }

    public void ActualizarDirectorTecnico(String nombre_tecnico, int encuentros,
            int partidos_ganados, int partidos_empatados, int partidos_perdidos) {
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

            String sql = "update director_tecnico set encuentros = encuentros + " + encuentros + ", "
                    + "partidos_ganados = partidos_ganados + " + partidos_ganados + ", "
                    + "partidos_empatados = partidos_empatados + " + partidos_empatados + ", "
                    + "partidos_perdidos = partidos_perdidos + " + partidos_perdidos + " "
                    + "where nombre_tecnico = '" + nombre_tecnico + "';";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Director tecnico actualizado");
    }

    public void ActualizarDirectivos(String nombre_directivo, float presupuesto) {

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

            String sql = "update directivo set presupuesto = presupuesto + " + presupuesto + " "
                    + "where nombre_directivo = '" + nombre_directivo + "';";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Directivo actualizado");

    }

    /*public void ActualizarDirectorTecnico(String nombre_tecnico, int encuentros,
            int partidos_ganados, int partidos_empatados, int partidos_perdidos) {
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

            String sql = "update director_tecnico set encuentros = encuentros + " + encuentros + ", "
                    + "partidos_ganados = partidos_ganados + " + partidos_ganados + ", "
                    + "partidos_empatados = partidos_empatados + " + partidos_empatados + ", "
                    + "partidos_perdidos = partidos_perdidos + " + partidos_perdidos + " "
                    + "where nombre_tecnico = '" + nombre_tecnico + "';";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Director tecnico actualizado");
    }*/
    public void ActualizarEquipo(String nombre_equipo, int partidos_jugados, int partidos_ganados,
            int partidos_empatados, int partidos_perdidos, int goles_favor, int goles_contra,
            int puntos) {

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

            String sql = "update equipos set partidos_jugados = partidos_jugados + " + partidos_jugados + ","
                    + " partidos_ganados = partidos_ganados + " + partidos_ganados + ","
                    + " partidos_empatados = partidos_empatados + " + partidos_empatados + ", "
                    + " partidos_perdidos = partidos_perdidos + " + partidos_perdidos + ", "
                    + " goles_favor = goles_favor + " + goles_favor + ", "
                    + " goles_contra = goles_contra + " + goles_contra + ", "
                    + " puntos = puntos + " + puntos + " "
                    + "where nombre_equipo = '" + nombre_equipo + "';";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            // System.exit(0);
        }
        System.out.println("Directivo actualizado");

    }

    public void VisualizarTablaPosiciones() {

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
            String sql = "SELECT * FROM equipos "
                    + "order by nombre_equipo, partidos_jugados , partidos_ganados, "
                    + "partidos_empatados, partidos_perdidos, goles_favor, goles_contra, "
                    + "puntos desc;";

            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String nombre_equipo = result.getString("nombre_equipo");
                String partidos_jugados = result.getString("partidos_jugados");
                String partidos_ganados = result.getString("partidos_ganados");
                String partidos_empatados = result.getString("partidos_empatados");
                String partidos_perdidos = result.getString("partidos_perdidos");
                String goles_favor = result.getString("goles_favor");
                String goles_contra = result.getString("goles_contra");
                String puntos = result.getString("puntos");
                System.out.println(nombre_equipo + " || " + partidos_jugados + " || "
                        + partidos_ganados + " || " + partidos_empatados + " || " + partidos_perdidos
                        + " || " + goles_favor + " || " + goles_contra + " || " + puntos);
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

    public void JugadorMasValioso() {

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
            String sql = "SELECT * FROM jugadores "
                    + "order by goles_anotados desc, tarjetas_amarillas asc, tarjetas_rojas asc, "
                    + "faltas asc";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String nombre = result.getString("nombre");
                String equipo = result.getString("equipo");
                String goles_anotados = result.getString("goles_anotados");
                String tarjetas_amarillas = result.getString("tarjetas_amarillas");
                String tarjetas_rojas = result.getString("tarjetas_rojas");
                String faltas = result.getString("faltas");

                System.out.println("Nombre: " + nombre + " | Equipo: " + equipo + " | Goles: "
                        + goles_anotados + " | Tarjetas Amarillas: " + tarjetas_amarillas + " | Tarjetas Rojas: " + tarjetas_rojas
                        + " | Faltas: " + faltas);
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
