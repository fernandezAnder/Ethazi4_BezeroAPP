package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author oier, ander, aintzane
 *
 */
public class Conexion {
	private String  maquina="localhost/bidaion";
    private String  usuario="root";
    private String  clave="";
    private int puerto= 3306;
    private String  servidor="127.0.0.1";
    private static Connection conexion  = null;
    private String baseDatos="bidaion";
    //CONSTRUCTOR
  
    public Conexion(){
       
    		
    	
    	this.servidor="jdbc:mysql://"+this.maquina+":"+ this.puerto+"/"+baseDatos;

        //Registrar el driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR AL REGISTRAR EL DRIVER");
            System.exit(0); //parar la ejecución
        }
 
        //Establecer la conexión con el servidor
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://"+this.maquina,this.usuario, this.clave);
        } catch (SQLException e) {
            System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
            System.exit(0); //parar la ejecución
        }
        System.out.println("Conectado a "+baseDatos);
    }
 
/**
 * 
 * @return conexion
 */
    //Devuelve el objeto Connection que se usará en la clase Controller
    public static Connection getConexion() {
        return conexion;
    }
 
}

