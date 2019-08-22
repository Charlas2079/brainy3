package com.poll.brainy;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GeneralPoll implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idEncuesta;
	private Integer idCliente;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_encuesta;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date fecha_cierre;
	private String nombre_encuesta;	
	@OneToMany
	private List<GeneralQuestion> questions;
	@OneToMany
	private List<GeneralUser> users;
	
	public Integer getIdEncuesta() {
		return idEncuesta;
	}
	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFecha_encuesta() {
		return fecha_encuesta;
	}
	public void setFecha_encuesta(Date fecha_encuesta) {
		this.fecha_encuesta = fecha_encuesta;
	}
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
	public List<GeneralQuestion> getQuestions() {
		return questions;
	}
	public void setQuestions(List<GeneralQuestion> questions) {
		this.questions = questions;
	}
	public List<GeneralUser> getUsers() {
		return users;
	}
	public void setUsers(List<GeneralUser> users) {
		this.users = users;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha_cierre == null) ? 0 : fecha_cierre.hashCode());
		result = prime * result + ((fecha_encuesta == null) ? 0 : fecha_encuesta.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((idEncuesta == null) ? 0 : idEncuesta.hashCode());
		result = prime * result + ((nombre_encuesta == null) ? 0 : nombre_encuesta.hashCode());
		//result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		//result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		GeneralPoll other = (GeneralPoll) obj;
		if (fecha_cierre == null) {
			if (other.fecha_cierre != null)
				return false;
		} else if (!fecha_cierre.equals(other.fecha_cierre))
			return false;
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
		if (nombre_encuesta == null) {
			if (other.nombre_encuesta != null)
				return false;
		} else if (!nombre_encuesta.equals(other.nombre_encuesta))
			return false;
		/*if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;*/
		return true;
	}
	@Override
	public String toString() {
		return "GeneralPoll [idEncuesta=" + idEncuesta + ", idCliente=" + idCliente + ", fecha_encuesta="
				+ fecha_encuesta + ", fecha_cierre=" + fecha_cierre + ", nombre_encuesta=" + nombre_encuesta
				+ ", questions="  + ", users="  + "]";
	}
	
}
