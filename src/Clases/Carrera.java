package Clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Carrera {
	 
	    private String nombre;
	    private int cantidadmaterias;
	    private ArrayList <Materia> Materias;

	    public Carrera(){}

	    public Carrera(String nombre,int cantidadmaterias){
	        super();
	        
	        this.nombre=nombre;
	        this.cantidadmaterias=cantidadmaterias;

	    }
	    
	    
	    

	    
	    public String getNombre(){return nombre;}
	    public int getCantidadMaterias(){return cantidadmaterias;}
	    public ArrayList<Materia> getMaterias() {
			return Materias;
		}

		

		public void setNombre(String nombre){this.nombre=nombre;}
	    public void setCantidadMaterias(int cantidadmaterias){this.cantidadmaterias=cantidadmaterias;}
	    public void setMaterias(ArrayList<Materia> materias) {
			Materias = materias;
		}

}
