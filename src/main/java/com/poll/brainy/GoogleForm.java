package com.poll.brainy;

import java.io.Serializable;
import java.util.List;

public class GoogleForm implements Serializable {
	
	private Integer idEncuesta;
	private String nombre_encuesta;
	private List<Pregunta> preguntas;
	public Integer getIdEncuesta() {
		return idEncuesta;
	}
	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}
	public String getNombre_encuesta() {
		return nombre_encuesta;
	}
	public void setNombre_encuesta(String nombre_encuesta) {
		this.nombre_encuesta = nombre_encuesta;
	}
	public List<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEncuesta == null) ? 0 : idEncuesta.hashCode());
		result = prime * result + ((nombre_encuesta == null) ? 0 : nombre_encuesta.hashCode());
		result = prime * result + ((preguntas == null) ? 0 : preguntas.hashCode());
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
		GoogleForm other = (GoogleForm) obj;
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
		if (preguntas == null) {
			if (other.preguntas != null)
				return false;
		} else if (!preguntas.equals(other.preguntas))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GoogleForm [idEncuesta=" + idEncuesta + ", nombre_encuesta=" + nombre_encuesta + ", preguntas="
				+ preguntas + "]";
	}
	

}
