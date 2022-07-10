package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Alumno extends Persona{
	
	
	public void alumnoregular(String dni, Connection conexion) {
        Connection connection = conexion;
        PreparedStatement as = null;
        ResultSet rs=null;
        try {
            as=connection.prepareStatement("SELECT * FROM usuarios WHERE Documento=" + "'"+dni+"'");
            rs= as.executeQuery();
            if (rs.next()) {
                System.out.println("Es alumno regular");
                as.close();
                connection.close();
            }
            else{
                System.out.println("No es alumno regular");
            }
            
        } catch (SQLException sqle) {
            System.out.println("Sqlstate: " + sqle.getSQLState());
            System.out.println("SlqError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }

    }
	 
	
	public void crearAlumno(Connection conexion) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("------------------------");
		System.out.println("Datos del Alumno");
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
        	
        	Statement statementAlumno = conexion.createStatement();
			sql = "SELECT idAlumno FROM alumno order by idAlumno DESC LIMIT 1;";
			rs = statementAlumno.executeQuery(sql);
			int idalumno = 0;
			while(rs.next()) 
			{
				idalumno = rs.getInt("idAlumno");
			}
        	PreparedStatement stmtalumno = conexion.prepareStatement("INSERT INTO alumno VALUES (?,?)");
        	stmtalumno.setInt(1,idalumno+1);
        	stmtalumno.setInt(2,idpersona+1);
        	response = stmtalumno.executeUpdate();
        	if(response>0) 
        	{
        		System.out.println("se creo alumno correctamente");
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
