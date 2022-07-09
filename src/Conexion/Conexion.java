package Conexion;

import java.sql.*;
import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import Clases.*;

public class Conexion {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/facultad";
    private static final String USER = "root";
    private static final String PASS = "0203";
    
    Connection connection;

    public String conectar() 
	{
		String respuesta="";
		
		try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL,USER,PASS);
            if(this.connection != null) 
            {
            	respuesta = "Conectado";
            }
            else 
            {
            	respuesta = "No conectado";
            }
        }catch (ClassNotFoundException e) {
			respuesta="ocurre una ClassNotFoundException : "+e.getMessage();
		}
		catch (SQLSyntaxErrorException e) {
			respuesta="ocurre una SQLSyntaxErrorException: "+e.getMessage()+"\n";
			respuesta+="Verifique que se este usando la base de datos y tablas correctas...";
		}
		catch (CommunicationsException e) {
			respuesta="ocurre una CommunicationsException: "+e.getMessage()+"\n";
			respuesta+="Verifique que la base de datos fue iniciada...";
		}
		catch (SQLException e) {
			respuesta="ocurre una SQLException: "+e.getMessage()+"\n";
			respuesta+="Este es un problema general de SQL, verifique con el administrador";
		}
		
		return respuesta;
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
	public void desconectar(){
		this.connection = null;
	}

       
}