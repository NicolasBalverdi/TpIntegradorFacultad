package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Persona{
	
	public void insertarCarrera(Carrera carrera1, Connection conexion)throws SQLException{
        Connection connection = conexion;
        PreparedStatement as=null;
        try {
            as=connection.prepareStatement("INSERT INTO carreras VALUES (?,?)");
            as.setString(1,carrera1.getNombre());
            as.setInt(2,carrera1.getCantidadMaterias());
			/* as.setArrayList<Materia>(5,carrera1.getMaterias()); */

            int response = as.executeUpdate();
            if (response>0) {
                System.out.println("Insertado correctamente");
                
            as.close();
            connection.close();
            }
        } catch (SQLException sqle) {
            System.out.println("Sqlstate: "+ sqle.getSQLState());
            System.out.println("SlqError: "+ sqle.getErrorCode());
            sqle.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            if (connection != null) {
                try {
                    as.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	public void crearAdministrador(Connection conexion) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------------------------");
		System.out.println("Datos del Administrador");
		System.out.println("------------------------");
		System.out.println("Apellido :");
		String apellido = sc.nextLine(); 
		System.out.println("Nombre :");
		String nombre = sc.nextLine();
		System.out.println("Documento :");
		String documento = sc.nextLine();



		
		try {
			Statement statement = conexion.createStatement();
			String sql = "SELECT idpersona FROM persona order by idPersona DESC LIMIT 1;";
			ResultSet rs = statement.executeQuery(sql);
			int idpersona = 0;
			while(rs.next()) 
			{
				idpersona = rs.getInt("idPersona");
			}
			PreparedStatement stmt = conexion.prepareStatement("INSERT INTO persona VALUES (?,?,?,?)");
        	stmt.setInt(1,idpersona+1);
        	stmt.setString(2,nombre);
        	stmt.setString(3,apellido);
        	stmt.setString(4,documento);
        	int response = stmt.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se creo persona correctamente");
        	}
        	
        	Statement statementAdministrador = conexion.createStatement();
			sql = "SELECT idadministrador FROM administrador order by idadministrador DESC LIMIT 1;";
			rs = statementAdministrador.executeQuery(sql);
			int idadministrador = 0;
			while(rs.next()) 
			{
				idadministrador = rs.getInt("idadministrador");
			}
        	PreparedStatement stmtadministrador = conexion.prepareStatement("INSERT INTO administrador VALUES (?,?)");
        	stmtadministrador.setInt(1,idadministrador+1);
        	stmtadministrador.setInt(2,idpersona+1);
      
        	
        	response = stmtadministrador.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se creo administrador correctamente");
        	}
        	
		}catch (SQLException sqle){
            System.out.println("SQLState: "+ sqle.getSQLState());
            System.out.println("SQLErrorCode: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
	}

}
