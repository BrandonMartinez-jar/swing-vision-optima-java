package Programa;




import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Connect {
    public static Connection con;
    public static final String driver="com.mysql.jdbc.Driver";
    public static String user="";
    public static String pass="";
    public static final String url="jdbc:mysql://localhost:3306/proyect";
    public static String message="";

public static Connection conector() throws SQLException {
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
                message="Conexion establecida";
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            message="Error de conexion" + e;
        }return null;
}      

//tabla citas

public static void Buscar(String Buscar, int idCita, String Nombre, String Cedula, String Fecha, String Hora, String noc) throws SQLException{
    ResultSet rs;
    java.sql.Connection Conectar = null;
    PreparedStatement pst;
    try{
        Conectar = Connect.conector();
        pst = Conectar.prepareStatement("SELECT * FROM citas WHERE " + noc + " = ?");
        pst.setString(1, Buscar);
        rs = pst.executeQuery();
        if(rs.next()){
            idCita = rs.getInt("idCita");
            Nombre = "Nombre: " + rs.getString("Nombre");
            Cedula = "Cedula: " + rs.getString("Cedula");
            Fecha = "Fecha: " + rs.getString("Fecha");
            Hora = "Hora : " + rs.getString("Hora");
         
        }
         
    }catch(Exception e){
        System.err.println(e);
    }
    }


}