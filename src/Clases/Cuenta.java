package Clases;

public class Cuenta {
	private String user;
	private String contrasena;
	

	public Cuenta(String user, String contrasena) {
		this.user = user;
		this.contrasena = contrasena;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	

}
