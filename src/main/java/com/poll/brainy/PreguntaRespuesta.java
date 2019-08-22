package com.poll.brainy;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="PREGUNTA_RESPUESTA")
@IdClass(value = PreguntaRespuesta.class)
public class PreguntaRespuesta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ENCUESTA")
	private Integer idEncuesta;
	
	@Id
	@Column(name="ID_PREGUNTA")
	private Integer idPregunta;

	@Id
	@Column(name="ID_RESPUESTA")
	private Integer idRespuesta;
	
	public Integer getIdEncuesta() {
		return idEncuesta;
	}

	public void setIdEncuesta(Integer idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public Integer getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Integer idPregunta) {
		this.idPregunta = idPregunta;
	}

	public Integer getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Integer idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEncuesta == null) ? 0 : idEncuesta.hashCode());
		result = prime * result + ((idPregunta == null) ? 0 : idPregunta.hashCode());
		result = prime * result + ((idRespuesta == null) ? 0 : idRespuesta.hashCode());
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
		PreguntaRespuesta other = (PreguntaRespuesta) obj;
		if (idEncuesta == null) {
			if (other.idEncuesta != null)
				return false;
		} else if (!idEncuesta.equals(other.idEncuesta))
			return false;
		if (idPregunta == null) {
			if (other.idPregunta != null)
				return false;
		} else if (!idPregunta.equals(other.idPregunta))
			return false;
		if (idRespuesta == null) {
			if (other.idRespuesta != null)
				return false;
		} else if (!idRespuesta.equals(other.idRespuesta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PreguntaRespuesta [idEncuesta=" + idEncuesta + ", idPregunta=" + idPregunta + ", idRespuesta="
				+ idRespuesta + "]";
	}
	

	
	
	
	
}
