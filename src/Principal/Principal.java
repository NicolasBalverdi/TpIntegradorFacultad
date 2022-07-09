package Principal;

import java.util.InputMismatchException;
import java.util.Scanner;

import Clases.Registro;
import Conexion.Conexion;

public class Principal {

	public static void main(String[] args) {
		Conexion cn = new Conexion();
        cn.conectar();
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
 
        while (!salir) {
 
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesion");         
            System.out.println("3. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        Registro registro=new Registro();
                        registro.comprobar(cn.getConnection());
                        break;
                    case 2:
                    	
                       
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

}
