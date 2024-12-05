package mx.com.sistema.cap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the obras_cargas_poa database table.
 * 
 */
/**
 * 
 */
@Entity
@Table(name="users")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user")
	private Long id;
	
	private String username;
	
	private String password;
	
	private int enabled;

	private String email;

	private String name;
	
	private String paterno;
	
	private String materno;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false, insertable = false, updatable = false)
    private RolEntity roles;

	
	
	

	public UsuarioEntity(String username, String password, int enabled, String email, String name, String paterno,
			String materno, RolEntity roles) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
		this.name = name;
		this.paterno = paterno;
		this.materno = materno;
		this.roles = roles;
	}


	public UsuarioEntity() {

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getEnabled() {
		return enabled;
	}


	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public RolEntity getRoles() {
		return roles;
	}


	public void setRoles(RolEntity roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", email=" + email + ", name=" + name + ", paterno=" + paterno + ", materno=" + materno + ", roles="
				+ roles + "]";
	}

	

}