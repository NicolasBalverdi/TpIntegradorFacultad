package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Carrera {
	 
	    private String nombre;
	    private int cantidadmaterias;
	    private ArrayList <Materia> Materias;

	    public Carrera(){}

	    public Carrera(String nombre,int cantidadmaterias,ArrayList <Materia> Materias){
	        super();
	        
	        this.nombre=nombre;
	        this.cantidadmaterias=cantidadmaterias;
	        this.Materias=Materias;

	    }
	    
	    public void crearCarrera(){
	    	Scanner sc=new Scanner(System.in);
	    	ArrayList<Materia> listaMateria = new ArrayList<Materia>();
			System.out.println("Agregar materia");
			System.out.println("1 - SI");
			System.out.println("0 - NO");
			int agregarMateria = sc.nextInt();
			sc.nextLine();
			while(agregarMateria == 1) 
			{
				System.out.println("Materia");
				String nMateria = sc.nextLine();
				
				Materia materia = new Materia(nMateria);
				listaMateria.add(materia);
				System.out.println("Ingresar mas materias");
				System.out.println("1 - SI");
				System.out.println("0 - NO");
				agregarMateria = sc.nextInt();
			}
	    }

	    
	    public String getNombre(){return nombre;}
	    public int getCantidadMaterias(){return cantidadmaterias;}


	    
	    public void setNombre(String nombre){this.nombre=nombre;}
	    public void setCantidadMaterias(int cantidadmaterias){this.cantidadmaterias=cantidadmaterias;}

}
