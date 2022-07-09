package Clases;

public class Persona{

	    protected String nombre;
	    private String apellido;
	    private long dni;
	    private Cuenta cuenta;

	    public Persona(){}

	    public Persona(String nombre, String apellido, long dni,String provincia, String carrera, Cuenta cuenta){
	      
	        this.nombre=nombre;
	        this.apellido=apellido;
	        this.dni=dni;
	        this.cuenta=cuenta;
	    }

	    public String getNombre(){return nombre;}
	    public String getApellido(){return apellido;}
	    public long getDni(){return dni;}


	    public Cuenta getCuenta() {return cuenta;}


	    public void setNombre(String nombre){this.nombre=nombre;}
	    public void setApellido(String apellido){this.apellido=apellido;}
	    public void setDni(long dni){this.dni=dni;}


	    public void setCuenta(Cuenta cuenta) {this.cuenta=cuenta;}
}
