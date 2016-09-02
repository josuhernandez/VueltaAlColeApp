package com.ipartek.formacion.pojo;

public class Usuario {

	// propiedades
	private long id;
	private String nombre;
	private String password;
	private String email;

	// Constructor por defecto
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.password = "";
		this.email = "";
	}

	// Getters and Setters
	public long getId() {

		return this.id;

	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Funciones o Metodos
	@Override()
	public String toString() {
		return "Usuario [id=" + this.id + ", nombre=" + this.nombre + ", password=" + this.password + ", email="
				+ this.email + "]";
	}

}
