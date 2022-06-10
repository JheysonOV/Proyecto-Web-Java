package pe.speedy.model;

import javax.persistence.Column;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Table(name = "mascota")
public class Mascota {

	@Id
	@Column(name = "mascota")
	private Integer idMascota;
	
	@Column(name = "nombreMascota")
	private String nombreMascota;
	
	@Column(name = "edad")
	private Integer edad;
	
	public Integer getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	public Mascota(Integer idMascota, String nombreMascota, Integer edad) {
		super();
		this.idMascota = idMascota;
		this.nombreMascota = nombreMascota;
		this.edad = edad;
	}
	
	public Mascota() {

	}
	
	
}
