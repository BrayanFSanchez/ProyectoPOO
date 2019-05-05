
package proyectopoocliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author bacral
 */
public class Calendario {
  
    public void CrearCalendario(String equipo1, String equipo2, String equipo3, String equipo4,
            String equipo5, String equipo6, String equipo7, String equipo8, String equipo9,
            String equipo10) {

        //Jornadas de IDA
        String J1Enc_1 = equipo10 + " X " + equipo1;
        String J1Enc_2 = equipo2 + " X " + equipo9;
        String J1Enc_3 = equipo3 + " X " + equipo8;
        String J1Enc_4 = equipo4 + " X " + equipo7;
        String J1Enc_5 = equipo5 + " X " + equipo6;

        String J2Enc_1 = equipo6 + " X " + equipo10;
        String J2Enc_2 = equipo7 + " X " + equipo5;
        String J2Enc_3 = equipo8 + " X " + equipo4;
        String J2Enc_4 = equipo9 + " X " + equipo3;
        String J2Enc_5 = equipo1 + " X " + equipo2;

        String J3Enc_1 = equipo10 + " X " + equipo2;
        String J3Enc_2 = equipo3 + " X " + equipo1;
        String J3Enc_3 = equipo4 + " X " + equipo9;
        String J3Enc_4 = equipo5 + " X " + equipo8;
        String J3Enc_5 = equipo6 + " X " + equipo7;

        String J4Enc_1 = equipo7 + " X " + equipo10;
        String J4Enc_2 = equipo8 + " X " + equipo6;
        String J4Enc_3 = equipo9 + " X " + equipo5;
        String J4Enc_4 = equipo1 + " X " + equipo4;
        String J4Enc_5 = equipo2 + " X " + equipo3;

        String J5Enc_1 = equipo10 + " X " + equipo3;
        String J5Enc_2 = equipo4 + " X " + equipo2;
        String J5Enc_3 = equipo5 + " X " + equipo1;
        String J5Enc_4 = equipo6 + " X " + equipo9;
        String J5Enc_5 = equipo7 + " X " + equipo8;

        String J6Enc_1 = equipo8 + " X " + equipo10;
        String J6Enc_2 = equipo9 + " X " + equipo7;
        String J6Enc_3 = equipo1 + " X " + equipo6;
        String J6Enc_4 = equipo2 + " X " + equipo5;
        String J6Enc_5 = equipo3 + " X " + equipo4;

        String J7Enc_1 = equipo10 + " X " + equipo4;
        String J7Enc_2 = equipo5 + " X " + equipo3;
        String J7Enc_3 = equipo6 + " X " + equipo2;
        String J7Enc_4 = equipo7 + " X " + equipo1;
        String J7Enc_5 = equipo8 + " X " + equipo9;

        String J8Enc_1 = equipo9 + " X " + equipo10;
        String J8Enc_2 = equipo1 + " X " + equipo8;
        String J8Enc_3 = equipo2 + " X " + equipo7;
        String J8Enc_4 = equipo3 + " X " + equipo6;
        String J8Enc_5 = equipo4 + " X " + equipo5;

        String J9Enc_1 = equipo10 + " X " + equipo5;
        String J9Enc_2 = equipo6 + " X " + equipo4;
        String J9Enc_3 = equipo7 + " X " + equipo3;
        String J9Enc_4 = equipo8 + " X " + equipo2;
        String J9Enc_5 = equipo9 + " X " + equipo1;

        //Vuelta
        String J10Enc_1 = equipo1 + " X " + equipo10;
        String J10Enc_2 = equipo9 + " X " + equipo2;
        String J10Enc_3 = equipo8 + " X " + equipo3;
        String J10Enc_4 = equipo7 + " X " + equipo4;
        String J10Enc_5 = equipo6 + " X " + equipo5;

        String J11Enc_1 = equipo10 + " X " + equipo6;
        String J11Enc_2 = equipo5 + " X " + equipo7;
        String J11Enc_3 = equipo4 + " X " + equipo8;
        String J11Enc_4 = equipo3 + " X " + equipo9;
        String J11Enc_5 = equipo2 + " X " + equipo1;

        String J12Enc_1 = equipo2 + " X " + equipo10;
        String J12Enc_2 = equipo1 + " X " + equipo3;
        String J12Enc_3 = equipo9 + " X " + equipo4;
        String J12Enc_4 = equipo8 + " X " + equipo5;
        String J12Enc_5 = equipo7 + " X " + equipo6;

        String J13Enc_1 = equipo10 + " X " + equipo7;
        String J13Enc_2 = equipo6 + " X " + equipo8;
        String J13Enc_3 = equipo5 + " X " + equipo9;
        String J13Enc_4 = equipo4 + " X " + equipo1;
        String J13Enc_5 = equipo3 + " X " + equipo2;

        String J14Enc_1 = equipo3 + " X " + equipo10;
        String J14Enc_2 = equipo2 + " X " + equipo4;
        String J14Enc_3 = equipo1 + " X " + equipo5;
        String J14Enc_4 = equipo9 + " X " + equipo6;
        String J14Enc_5 = equipo8 + " X " + equipo7;

        String J15Enc_1 = equipo10 + " X " + equipo8;
        String J15Enc_2 = equipo7 + " X " + equipo9;
        String J15Enc_3 = equipo6 + " X " + equipo1;
        String J15Enc_4 = equipo5 + " X " + equipo2;
        String J15Enc_5 = equipo4 + " X " + equipo3;

        String J16Enc_1 = equipo4 + " X " + equipo10;
        String J16Enc_2 = equipo3 + " X " + equipo5;
        String J16Enc_3 = equipo2 + " X " + equipo6;
        String J16Enc_4 = equipo1 + " X " + equipo7;
        String J16Enc_5 = equipo9 + " X " + equipo8;

        String J17Enc_1 = equipo10 + " X " + equipo9;
        String J17Enc_2 = equipo8 + " X " + equipo1;
        String J17Enc_3 = equipo7 + " X " + equipo2;
        String J17Enc_4 = equipo6 + " X " + equipo3;
        String J17Enc_5 = equipo5 + " X " + equipo4;

        String J18Enc_1 = equipo5 + " X " + equipo10;
        String J18Enc_2 = equipo4 + " X " + equipo6;
        String J18Enc_3 = equipo3 + " X " + equipo7;
        String J18Enc_4 = equipo2 + " X " + equipo8;
        String J18Enc_5 = equipo1 + " X " + equipo9;

        Calendario oCalendario = new Calendario();
        //IDA
        oCalendario.AgregarNumJornadaEnc_x(1, J1Enc_1, J1Enc_2, J1Enc_3, J1Enc_4, J1Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(2, J2Enc_1, J2Enc_2, J2Enc_3, J2Enc_4, J2Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(3, J3Enc_1, J3Enc_2, J3Enc_3, J3Enc_4, J3Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(4, J4Enc_1, J4Enc_2, J4Enc_3, J4Enc_4, J4Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(5, J5Enc_1, J5Enc_2, J5Enc_3, J5Enc_4, J5Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(6, J6Enc_1, J6Enc_2, J6Enc_3, J6Enc_4, J6Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(7, J7Enc_1, J7Enc_2, J7Enc_3, J7Enc_4, J7Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(8, J8Enc_1, J8Enc_2, J8Enc_3, J8Enc_4, J8Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(9, J9Enc_1, J9Enc_2, J9Enc_3, J9Enc_4, J9Enc_5);

        //Vuelta
        oCalendario.AgregarNumJornadaEnc_x(10, J10Enc_1, J10Enc_2, J10Enc_3, J10Enc_4, J10Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(11, J11Enc_1, J11Enc_2, J11Enc_3, J11Enc_4, J11Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(12, J12Enc_1, J12Enc_2, J12Enc_3, J12Enc_4, J12Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(13, J13Enc_1, J13Enc_2, J13Enc_3, J13Enc_4, J13Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(14, J14Enc_1, J14Enc_2, J14Enc_3, J14Enc_4, J14Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(15, J15Enc_1, J15Enc_2, J15Enc_3, J15Enc_4, J15Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(16, J16Enc_1, J16Enc_2, J16Enc_3, J16Enc_4, J16Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(17, J17Enc_1, J17Enc_2, J17Enc_3, J17Enc_4, J17Enc_5);
        oCalendario.AgregarNumJornadaEnc_x(18, J18Enc_1, J18Enc_2, J18Enc_3, J18Enc_4, J18Enc_5);
    }

    public void AgregarNumJornadaEnc_x(int num_jornada, String enc_1,
            String enc_2, String enc_3, String enc_4, String enc_5) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BaseProyecto",
                            "postgres", "123456");
            c.setAutoCommit(false);
            //System.out.println("Acceso base de datos exitoso");

            stmt = c.createStatement();

            String sql = "INSERT INTO jornadas (num_jornada, enc_1, enc_2, enc_3, enc_4, enc_5) "
                    + "VALUES ('" + num_jornada + "', '" + enc_1 + "', '" + enc_2 + "',"
                    + "'" + enc_3 + "','" + enc_4 + "', '" + enc_5 + "');";

            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            //System.exit(0);
        }
    }

    public void ImprimirCalendario() {

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
            String sql = "SELECT num_jornada, enc_1, enc_2, enc_3, "
                    + "enc_4, enc_5 FROM jornadas ";
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                String num_jornada = result.getString("num_jornada");
                String enc_1 = result.getString("enc_1");
                String enc_2 = result.getString("enc_2");
                String enc_3 = result.getString("enc_3");
                String enc_4 = result.getString("enc_4");
                String enc_5 = result.getString("enc_5");
                System.out.println("Jornada: " + num_jornada + " || " + enc_1
                        + " || " + enc_2 + " || " + enc_3 + " || " + enc_4 + " || "
                        + enc_5);
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
