package paquete.example.the_factory_hka_definitivo.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Usuario {
	
	@DatabaseField(generatedId = true)
	int codigo;
	@DatabaseField
	private String nombre;
	@DatabaseField
	private String apellido;
	@DatabaseField
	private String sexo;
	@DatabaseField
	private String correo;
	@DatabaseField
	private String telefono;
	@DatabaseField
	private String nombreUsuario;
	@DatabaseField
	private int password;
	
	public Usuario(int codigo, String nombre, String apellido, String sexo,
			String correo, String telefono, String nombreUsuario,
			int password) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.correo = correo;
		this.telefono = telefono;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	

}
