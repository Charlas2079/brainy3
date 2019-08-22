package com.poll.brainy;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ENCUESTA")
@SequenceGenerator(name="encuesta_id_encuesta_seq", initialValue=1, allocationSize=1)
public class Encuesta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="encuesta_id_encuesta_seq")
	@Column(name="ID_ENCUESTA")
	private Integer idEncuesta;
	
	@Column(name="ID_CLIENTE")
	private Integer idCliente;
	
	@Column(name="NUMERO_PERSONAS")
	private Integer numero_personas;
	
	@Column(name="NUMERO_PREGUNTAS")
	private Integer numero_preguntas;
	
	@Column(name="FECHA_ENCUESTA")
	private Date fecha_encuesta;

	@Column(name="FECHA_CIERRE")
	private Date fecha_cierre;
	
	@Column(name="NOMBRE_ENCUESTA")
	private String nombre_encuesta;
	
	public Date getFecha_cierre() {
		return fecha_cierre;
	}
	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}
	public String getNombre_encuesta() {
		return nombre_encuesta;
	}
	public void setNombre_encuesta(String nombre_encuesta) {
		this.nombre_encuesta = nombre_encuesta;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Integer getNumero_personas() {
		return numero_personas;
	}
	public void setNumero_personas(Integer numero_personas) {
		this.numero_personas = numero_personas;
	}
	public Integer getNumero_preguntas() {
		return numero_preguntas;
	}
	public void setNumero_preguntas(Integer numero_preguntas) {
		this.numero_preguntas = numero_preguntas;
	}
	public Date getFecha_encuesta() {
		return fecha_encuesta;
	}
	public void setFecha_encuesta(Date fecha_encuesta) {
		this.fecha_encuesta = fecha_encuesta;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha_encuesta == null) ? 0 : fecha_encuesta.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idEncuesta == null) ? 0 : idEncuesta.hashCode());
		result = prime * result + ((numero_personas == null) ? 0 : numero_personas.hashCode());
		result = prime * result + ((numero_preguntas == null) ? 0 : numero_preguntas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Encuesta other = (Encuesta) obj;
		if (fecha_encuesta == null) {
			if (other.fecha_encuesta != null)
				return false;
		} else if (!fecha_encuesta.equals(other.fecha_encuesta))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (idEncuesta == null) {
			if (other.idEncuesta != null)
				return false;
		} else if (!idEncuesta.equals(other.idEncuesta))
			return false;
		if (numero_personas == null) {
			if (other.numero_personas != null)
				return false;
		} else if (!numero_personas.equals(other.numero_personas))
			return false;
		if (numero_preguntas == null) {
			if (other.numero_preguntas != null)
				return false;
		} else if (!numero_preguntas.equals(other.numero_preguntas))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Poll [idEncuesta=" + idEncuesta + ", idCliente=" + idCliente + ", numero_personas=" + numero_personas
				+ ", numero_preguntas=" + numero_preguntas + ", fecha_encuesta=" + fecha_encuesta + "]";
	}
	
	public Integer getIdEncuesta() {
		return idEncuesta;
	}
	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	

}
