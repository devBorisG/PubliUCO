import java.sql.*;
public class Prueba {

    private static final String driver = "org.postgresql.Driver";
    private static final String bbdd = "jdbc:postgresql://localhost:5432/yhqguzmb";
    private static final String usuario = "yhqguzmb";
    private static final String clave = "zeF0x2MgKJSPFLGt1EbTATHyEFWOPvPc";
    public static void main(String[] args) {
        Connection conex = null;

        try{
            Class.forName(driver);
            conex = DriverManager.getConnection(bbdd,usuario,clave);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
