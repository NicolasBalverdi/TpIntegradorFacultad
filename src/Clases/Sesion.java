package Clases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sesion {
	public void comprobar(Connection conexion) {
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Administrador");
            System.out.println("2. Alumno");
            System.out.println("3. Atras");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        sesionAdministrador(conexion);
                        break;
                    case 2:
                        sesionAlumno(conexion);
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
	public void sesionAlumno(Connection cn) {
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Inscribirse a una carrera");
            System.out.println("2. Inscribirse a una mesa de examen");
            System.out.println("3. Generar certificado de alumno regular");
            System.out.println("4. Darse de baja en una mesa");
            System.out.println("5. Ver historial academico");
            System.out.println("6. Atras");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                    	System.out.println("Ingrese dni");
                    	String dni=sn.nextLine();
                    	Alumno alumno=new Alumno();
                    	alumno.alumnoregular(dni, cn);
                        break;
                    case 4:
                        
                        break;
                    case 5:
    
                    	break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
	}
	public void sesionAdministrador(Connection cn) throws SQLException {
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Crear una carrera");
            System.out.println("2. Crear una materia");
            System.out.println("3. Crear mesa");
            System.out.println("4. Ver resultado de examenes");
            System.out.println("5. Atras");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                    	System.out.println("----------------------");
                    	System.out.println("Nombre de la carrera");
                    	String nCarrera=sn.nextLine();
                    	System.out.println("Cantidad de materias");
                    	int cMaterias=sn.nextInt();
                    	Carrera carrera =new Carrera(nCarrera,cMaterias);
                    	Administrador admin=new Administrador();
                    	admin.insertarCarrera(carrera, cn);
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
	}

}
