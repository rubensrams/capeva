package mx.com.sistema.cap.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String email;
	private String password;
	private String nombre;
	private String paterno;
	private String materno;
	private int estatus;
	private String username;
	
	
	
	public UsuarioDTO(Long id, String email, String password, String nombre, String paterno, String materno) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.paterno = paterno;
		this.materno = materno;
	}
	
	
	
	public UsuarioDTO(String email, String password, String nombre) {
		super();
		this.email = email;
		this.password = password;
		this.nombre = nombre;
	}

	public UsuarioDTO(String username) {
		this.username = username;
	}

		
	
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}



}
