package Clases;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

import Conexion.Conexion;

public class Registro {
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
                        registrarAdministrador(conexion);
                        break;
                    case 2:
                        registrarAlumno(conexion);
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
	public void registrarAlumno(Connection cn) {
		Alumno alumno=new Alumno();
		alumno.crearAlumno(cn);
	}
	public void registrarAdministrador(Connection cn) {
		Administrador admin=new Administrador();
		admin.crearAdministrador(cn);
	}

}
